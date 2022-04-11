package org.trace.map.monitor;

import org.springframework.stereotype.Component;

/**
 * @Date 2022/3/10 下午 05:32
 * @Created by wangqian30
 * @description:
 */
@Component
public class MyClass extends MyAbstract{
    @Override
    public void test() {
        System.out.println("子类调用");
        super.test1();
    }

    public static void main(String[] args) {
        MyClass myclass = new MyClass();
        myclass.test();
    }
}
