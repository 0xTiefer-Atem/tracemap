package org.trace.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.trace.map.monitor.MyClass;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

    @Autowired
    MyClass myclass;

    @Test
    public void test11111() {
        myclass.test();
        System.out.println("00000");
    }

}
