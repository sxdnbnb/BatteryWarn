package com.example.micar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.micar.entity.Car;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CarMapper extends BaseMapper<Car> {
    // 根据汽车编号查询电池类型
    @Select("SELECT battery_type FROM car_info WHERE carframe_id = #{carFrameId}")
    String selectBatteryType(@Param("carFrameId") Long carFrameId);
}
