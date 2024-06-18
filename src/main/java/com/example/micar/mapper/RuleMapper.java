package com.example.micar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.micar.dto.WarnInfo;
import com.example.micar.entity.Rule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RuleMapper extends BaseMapper<Rule> {
    // 查询规则名称和报警等级
    // 有坑：mybatis-plus会把tinyint(1)自动转换为Boolean
    @Select("SELECT rule_name, MIN(alert_level) as alert_level FROM rule_info " +
            "WHERE rule_id = #{ruleId} " +
            "AND battery_type = #{batteryType} AND (voltage_diff <= #{voltageDiff} OR current_diff <= #{currentDiff})" +
            "GROUP BY rule_name")
    List<WarnInfo> selectRuleInfoById(@Param("ruleId") long ruleId, @Param("batteryType") String batteryType,
                                @Param("voltageDiff") double voltageDiff, @Param("currentDiff") double currentDiff);

    @Select("SELECT rule_name, MIN(alert_level) as alert_level FROM rule_info " +
            "WHERE battery_type = #{batteryType} " +
            "AND (voltage_diff <= #{voltageDiff} OR current_diff <= #{currentDiff})" +
            "GROUP BY rule_name")
    List<WarnInfo> selectRuleInfoNoId(@Param("batteryType") String batteryType,
                            @Param("voltageDiff") double voltageDiff, @Param("currentDiff") double currentDiff);
}
