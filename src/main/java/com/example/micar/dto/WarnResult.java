package com.example.micar.dto;

import lombok.Data;

import java.util.List;

@Data
public class WarnResult {
    // 车架编号
    private Long carFrameId;

    // 电池类型
    private String batteryType;

    // 规则名称
    private String ruleName;

    // 报警等级：0-4，0等级最高，5等级不报警
    private String alertLevel;
}
