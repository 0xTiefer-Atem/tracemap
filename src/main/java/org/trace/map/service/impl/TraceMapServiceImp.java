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
        list1.add(tracePath1);

        JSONObject tracePath2 = new JSONObject();
        tracePath2.put("name", "北京");
        tracePath2.put("value", 80);
        list1.add(tracePath2);

        List<JSONObject> list2 = new ArrayList<>();
        JSONObject tracePath3 = new JSONObject();
        tracePath3.put("name", "北京");
        list2.add(tracePath3);

        JSONObject tracePath4 = new JSONObject();
        tracePath4.put("name", "上海");
        tracePath4.put("value", 100);
        list2.add(tracePath4);

        List<JSONObject> list3 = new ArrayList<>();
        JSONObject tracePath5 = new JSONObject();
        tracePath5.put("name", "北京");
        list3.add(tracePath5);

        JSONObject tracePath6 = new JSONObject();
        tracePath6.put("name", "广州");
        tracePath6.put("value", 150);
        list3.add(tracePath6);


        List<JSONObject> list4 = new ArrayList<>();
        JSONObject tracePath7 = new JSONObject();
        tracePath7.put("name", "上海");
        list4.add(tracePath7);

        JSONObject tracePath8 = new JSONObject();
        tracePath8.put("name", "包头");
        tracePath8.put("value", 120);
        list4.add(tracePath8);


        List<JSONObject> list5 = new ArrayList<>();
        JSONObject tracePath9 = new JSONObject();
        tracePath9.put("name", "上海");
        tracePath9.put("value", 0);
        list5.add(tracePath9);

        JSONObject tracePath10 = new JSONObject();
        tracePath10.put("name", "昆明");
        tracePath10.put("value", 90);
        list5.add(tracePath10);


        List<JSONObject> list6 = new ArrayList<>();
        JSONObject tracePath11 = new JSONObject();
        tracePath11.put("name", "广州");
        list6.add(tracePath11);

        JSONObject tracePath12 = new JSONObject();
        tracePath12.put("name", "福州");
        tracePath12.put("value", 10);
        list6.add(tracePath12);



        List<JSONObject> list7 = new ArrayList<>();
        JSONObject tracePath13 = new JSONObject();
        tracePath13.put("name", "北京");
        tracePath13.put("value", 0);
        list7.add(tracePath13);

        JSONObject tracePath14 = new JSONObject();
        tracePath14.put("name", "上海");
        tracePath14.put("value", 100);
        list7.add(tracePath14);



        List<JSONObject> list8 = new ArrayList<>();
        JSONObject tracePath15 = new JSONObject();
        tracePath15.put("name", "北京");
        tracePath15.put("value", 0);
        list8.add(tracePath15);

        JSONObject tracePath16 = new JSONObject();
        tracePath16.put("name", "上海");
        tracePath16.put("value", 100);
        list8.add(tracePath16);

        response.add(list1);
        response.add(list2);
        response.add(list3);
        response.add(list4);
        response.add(list5);
        response.add(list6);
        response.add(list7);
        response.add(list8);


        return response;
    }
}
