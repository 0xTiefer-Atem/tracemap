package org.trace.map.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.trace.map.entity.Trajectory;

import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/26 下午 11:32
 */

@Mapper
public interface TraceInfoMapper {
    public List<Trajectory> getTraceInfoList();
}
