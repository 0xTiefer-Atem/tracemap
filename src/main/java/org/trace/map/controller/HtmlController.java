package org.trace.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author WangQian
 * @Date 2021/9/23 下午 10:01
 */

@Controller
public class HtmlController {


    @GetMapping("home")
    public String index() {
        return "index";
    }

}
