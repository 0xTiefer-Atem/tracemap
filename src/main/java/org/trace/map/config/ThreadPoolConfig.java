package org.trace.map.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2022/4/7 下午 03:08
 * @Created by wangqian30
 * @description:
 */
@Slf4j
@Configuration
public class ThreadPoolConfig {
    @Value("${maxRtaThreadNum:200}")
    int maxRtaThreadNum = 200;

    @Bean
    public ExecutorService rtaThreadPool() {
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;
        log.info("rta availableProcessors:{}", corePoolSize);
        return new ThreadPoolExecutor(corePoolSize, maxRtaThreadNum,
                500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));
    }

    @Value("${maxExtraAdThreadNum:200}")
    int maxExtraAdThreadNum = 200;

    @Bean
    public ExecutorService extraAdThreadPool() {
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;
        log.info("extraAdSelect availableProcessors:{}", corePoolSize);
        return new ThreadPoolExecutor(corePoolSize, maxExtraAdThreadNum,
                500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));
    }

    @Bean
    public ExecutorService commonThreadPool() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(corePoolSize, 200,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(500), new ThreadPoolExecutor.DiscardPolicy());
    }
}