package org.trace.map.monitor;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.*;

/**
 * @Date 2022/4/2 上午 11:54
 * @Created by wangqian30
 * @description:
 */
@Service
public class ThreadPoolMonitor implements InitializingBean {
    private final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    @Resource(name = "rtaThreadPool")
    private ThreadPoolExecutor rtaThreadPool;

    @Resource(name = "extraAdThreadPool")
    private ThreadPoolExecutor extraAdThreadPool;

    @Resource(name = "commonThreadPool")
    private ThreadPoolExecutor commonThreadPool;

    private Runnable monitor = () -> {
        monitorThreadPool("rtaThreadPool", rtaThreadPool);
        monitorThreadPool("commonThreadPool", commonThreadPool);
        monitorThreadPool("extraAdThreadPool", extraAdThreadPool);
    };

    private void monitorThreadPool(String threadPoolName, ThreadPoolExecutor threadPool) {
        Iterable<Tag> TAG = Collections.singletonList(Tag.of("thread.pool.name", threadPoolName));
        //这里需要捕获异常,尽管实际上不会产生异常,但是必须预防异常导致调度线程池线程失效的问题
        try {
            Metrics.gauge("thread.pool.core.size", TAG, threadPool, ThreadPoolExecutor::getCorePoolSize);
            Metrics.gauge("thread.pool.largest.size", TAG, threadPool, ThreadPoolExecutor::getLargestPoolSize);
            Metrics.gauge("thread.pool.max.size", TAG, threadPool, ThreadPoolExecutor::getMaximumPoolSize);
            Metrics.gauge("thread.pool.active.count", TAG, threadPool, ThreadPoolExecutor::getActiveCount);
            Metrics.gauge("thread.pool.pool.size", TAG, threadPool, ThreadPoolExecutor::getPoolSize);
            // 注意如果阻塞队列使用无界队列这里不能直接取size
            Metrics.gauge("thread.pool.queue.size", TAG, threadPool, e -> e.getQueue().size());
        } catch (Exception e) {
            //ignore
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 每5秒执行一次
        scheduledExecutor.scheduleWithFixedDelay(monitor, 0, 5, TimeUnit.SECONDS);
    }

    public void shortTimeWork() {
        rtaThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //ignore
            }
        });

        extraAdThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //ignore
            }
        });

        commonThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //ignore
            }
        });
    }

    public void longTimeWork() {
        rtaThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //ignore
            }
        });

        extraAdThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //ignore
            }
        });

        commonThreadPool.execute(() -> {
            try {
                // 5秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //ignore
            }
        });
    }

    public void clearTaskQueue() {
        rtaThreadPool.getQueue().clear();
        extraAdThreadPool.getQueue().clear();
        commonThreadPool.getQueue().clear();
    }
}
