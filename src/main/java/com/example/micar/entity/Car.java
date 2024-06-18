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
public class Car implements Serializable {
    private static final long serialVersionUID = 1L; // 定义一个常量，用于实现序列化
    // 主键：车辆识别码
    @TableId(value = "vid", type = IdType.NONE)
    private String vid;

    // 车架编号
    private Long carFrameId;

    // 电池类型
    private String batteryType;

    // 总里程（km）
    private Long mileage;

    // 电池健康状态(%)
    private Integer batteryHealthStatus;
}
