package org.trace.map.controller;

import com.alibaba.fastjson.JSON;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trace.map.monitor.PrometheusCustomMonitor;
import org.trace.map.monitor.ThreadPoolMonitor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2022/2/9 下午 04:10
 * @Created by wangqian30
 * @description:
 */
@RestController
public class TestController {

    private Random random = new Random();

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private MeterRegistry registry;

    @GetMapping("/test")
    public String test(@RequestParam("id") String id) {
        int sleep = random.nextInt(200);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("test");
        return "ok";
    }

    @GetMapping("")
    public String home() {
        logger.info("home");
        return "ok";
    }

//    @Bean
//    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
//        return (registry) -> registry.config().commonTags("application", applicationName);
//    }

    @Resource
    private PrometheusCustomMonitor monitor;

    @RequestMapping("/order")
    public String order(HttpServletRequest request) throws Exception {
        Random random = new Random();
        int i = random.nextInt(2);
        String orderName = "test_svc_" + i;
        // 统计下单次数
        monitor.log2Counter(orderName, Double.parseDouble(1 + ""));
        int amount = random.nextInt(100);
        // 统计金额
        monitor.log2Gauge(orderName, Long.parseLong(amount +""));
        monitor.log2Summary(orderName, Long.parseLong(amount + ""));

        Timer.Sample sample = Timer.start();
        recall();
        sample.stop(registry.timer("grpc", Tags.of("grpcType", "RsIndex")));


        System.out.println(request.getRequestURI());

        return "下单成功, 金额: " + amount;
    }

    public static void recall() throws InterruptedException {
        Random random = new Random();
        int abs = Math.abs(random.nextInt(100));
        Thread.sleep(abs);
    }

    @Autowired
    private ThreadPoolMonitor threadPoolMonitor;

    @GetMapping(value = "/shortTimeWork")
    public ResponseEntity<String> shortTimeWork() {
        threadPoolMonitor.shortTimeWork();
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "/longTimeWork")
    public ResponseEntity<String> longTimeWork() {
        threadPoolMonitor.longTimeWork();
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "/clearTaskQueue")
    public ResponseEntity<String> clearTaskQueue() {
        threadPoolMonitor.clearTaskQueue();
        return ResponseEntity.ok("success");
    }
}
