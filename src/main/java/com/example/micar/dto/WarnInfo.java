package com.example.micar.dto;

import lombok.Data;

@Data
public class WarnInfo {
    // 规则名称
    private String ruleName;

    // 报警等级：0-4，0等级最高
    private Integer alertLevel;
}
