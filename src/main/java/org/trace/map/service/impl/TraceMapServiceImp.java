package org.trace.map.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.trace.map.entity.TraceInfo;
import org.trace.map.mapper.TraceInfoMapper;
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
    @Autowired
    private TraceInfoMapper traceInfoMapper;

    @Override
    public List<List<JSONObject>> getTraceMap(String traceId) {
        List<List<JSONObject>> response = new ArrayList();

        List<TraceInfo> traceInfoList = traceInfoMapper.getTraceInfoList(traceId);

        traceInfoList.forEach( t -> {
            List<JSONObject> tempList = new ArrayList<>();
            JSONObject fromLoc = new JSONObject();
            fromLoc.put("name", t.getFromLoc());

            JSONObject toLoc = new JSONObject();
            toLoc.put("name", t.getToLoc());


            // 这里根据公式计算最终的感染情况
            Double value = 0.7 * t.getStayTime() * 20;


            toLoc.put("value", value.intValue());

            tempList.add(fromLoc);
            tempList.add(toLoc);

            response.add(tempList);

        });

        return response;
    }
}
