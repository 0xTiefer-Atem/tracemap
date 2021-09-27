package org.trace.map.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/25 下午 11:48
 */

@Service
public interface TraceMapService {
    List<List<JSONObject>> getTraceMap(String traceId);
}
