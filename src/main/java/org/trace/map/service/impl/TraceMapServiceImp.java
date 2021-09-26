package org.trace.map.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.trace.map.service.TraceMapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/25 下午 11:48
 */
@Service("TraceMapService")
public class TraceMapServiceImp implements TraceMapService {
    @Override
    public List<List<JSONObject>> getTraceMap() {
        List<List<JSONObject>> response = new ArrayList();
        List<JSONObject> list1 = new ArrayList<>();
        JSONObject tracePath1 = new JSONObject();
        tracePath1.put("name", "沈阳");
        tracePath1.put("value", 0);
        list1.add(tracePath1);
        JSONObject tracePath2 = new JSONObject();
        tracePath2.put("name", "北京");
        tracePath2.put("value", 80);
        list1.add(tracePath2);

        List<JSONObject> list2 = new ArrayList<>();
        JSONObject tracePath3 = new JSONObject();
        tracePath3.put("name", "北京");
        tracePath3.put("value", 0);
        list2.add(tracePath3);
        JSONObject tracePath4 = new JSONObject();
        tracePath4.put("name", "上海");
        tracePath4.put("value", 100);
        list2.add(tracePath4);


        return null;
    }
}
