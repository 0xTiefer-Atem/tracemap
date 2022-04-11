package org.trace.map.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @Date 2022/3/3 下午 02:57
 * @Created by wangqian30
 * @description:
 */

@Configuration
public class MicrometerConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> {
            registry.config().meterFilter(
                    new MeterFilter() {
                        @Override
                        public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
                            if (id.getType() == Meter.Type.TIMER && id.getName().matches("^(http|hystrix|grpc){1}.*")) {
                                return DistributionStatisticConfig.builder()
                                        .percentiles(0.5, 0.90, 0.95, 0.99)
                                        .build()
                                        .merge(config);
                            } else {
                                return config;
                            }
                        }
                    });
        };
    }
}
