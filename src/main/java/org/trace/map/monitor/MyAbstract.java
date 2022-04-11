package org.trace.map.monitor;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date 2022/3/10 下午 05:32
 * @Created by wangqian30
 * @description:
 */
public abstract class MyAbstract {

    @Autowired
    MeterRegistry registry;

    public abstract void test();

    public void test1(){
        Timer.Sample sample = Timer.start(Clock.SYSTEM);
        System.out.println(getClass().getSimpleName());
        sample.stop(registry.timer("ConstantEnum.MetricName.GRPC.getName()", "ConstantEnum.GRPC", getClass().getSimpleName()));

    }

}
