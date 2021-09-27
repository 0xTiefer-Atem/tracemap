package org.trace.map.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author WangQian
 * @Date 2021/9/26 下午 11:23
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraceInfo {
    private int id;
    private String traceId;
    private String fromLoc;
    private String toLoc;
    private int stayTime;
    private Date createTime;
}
