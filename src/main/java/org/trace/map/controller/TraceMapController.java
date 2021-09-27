package org.trace.map.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trace.map.service.TraceMapService;
import org.trace.map.util.ResponseHelper;
import org.trace.map.util.ResponseV2;

import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/25 下午 11:30
 */
@RestController
@CrossOrigin
@RequestMapping("/map")
public class TraceMapController {
    @Autowired
    private TraceMapService traceMapService;


    @GetMapping("/trace")
    public ResponseV2 getTraceMap() {
        List<JSONObject> traceList = traceMapService.getTraceMap();
        System.out.println(JSON.toJSONString(traceList));
        return ResponseHelper.create(traceList);
    }
}
