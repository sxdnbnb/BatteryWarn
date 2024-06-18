package com.example.micar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("car_info")
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L; // 定义一个常量，用于实现序列化
    // 主键：序号
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 规则编号
    private Long ruleId;

    // 规则名称
    private String ruleName;

    // 电池类型
    private String batteryType;

    // 最高电压与最小电压之差
    private Double voltageDiff;

    // 最高电流与最小电流之差
    private Double currentDiff;

    // 报警等级：0-4，0等级最高
    private Integer alertLevel;
}
