package org.trace.map.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.trace.map.entity.TraceInfo;
import org.trace.map.entity.Trajectory;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/26 下午 11:32
 */

@Mapper
public interface TraceInfoMapper {
    public List<String> getTraceGroup();

    public List<TraceInfo> getTraceInfoList(@Param("traceId") String traceId);
}
