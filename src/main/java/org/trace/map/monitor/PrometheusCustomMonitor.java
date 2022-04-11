package org.trace.map.monitor;

import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Date 2022/2/11 下午 04:03
 * @Created by wangqian30
 * @description: Prometheus自定义监控
 */

@Component
public class PrometheusCustomMonitor {

    private final MeterRegistry registry;

    private AtomicLong gaugeRef = new AtomicLong(0);

    @Autowired
    public PrometheusCustomMonitor(MeterRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    private void init() {

    }

    public void createGauge(String orderName) {
//        registry.gauge("yx_ptr_gauge", Tags.of("cat", orderName), new AtomicInteger(0));
    }

    public void log2Counter(String orderName, double num) {
        Counter counter = registry.counter("yx_access_count", Tags.of("cat", orderName, "os", "1", "positionId", "1"));
        counter.increment(num);
    }

    public void log2Gauge(String orderName, Long num) {
        gaugeRef = new AtomicLong(num);
        Metrics.gauge("yx_ptr_num", Tags.of("cat", orderName, "os", "1", "positionId", "1"), gaugeRef);
    }

    public void log2Summary(String orderName, long num) {
        DistributionSummary summary = registry.summary("yx_ptr_summary", Tags.of("cat", orderName, "os", "1", "positionId", "1"));
        summary.record(num);
    }
}
