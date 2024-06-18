package com.example.micar.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Body {
    // 车架编号
    private Long carFrameId;

    // 规则编号
    private Long ruleId;

    // 信号
    private Map<String, Double> signal;
}
