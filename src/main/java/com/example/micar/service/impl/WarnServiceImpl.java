package com.example.micar.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.micar.dto.Result;
import com.example.micar.dto.WarnInfo;
import com.example.micar.dto.WarnResult;
import com.example.micar.mapper.CarMapper;
import com.example.micar.mapper.RuleMapper;
import com.example.micar.service.IWarnService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class WarnServiceImpl implements IWarnService {
    @Resource
    private CarMapper carMapper;
    @Resource
    private RuleMapper ruleMapper;

    @Override
    /*
     * 参数：车架编号，规则编号，信号
     */
    public Result queryWarn(Long carFrameId, Long ruleId, Map<String, Double> signal) {
        // 1.根据车架编号，查出电池类型
        if (carFrameId == null) {
            return Result.fail("没有车架编号传入！");
        }
        String batteryType = carMapper.selectBatteryType(carFrameId);
        log.debug("该车的电池类型为：" + batteryType);
        if (batteryType == null){
            return Result.fail("车架编号有误！");
        }

        // 2.处理传入的信号, 999表示未传入
        if (signal == null) {
            return Result.fail("没有信号传入！");
        }
        double voltageDiff = signal.containsKey("Mx") && signal.containsKey("Mi") ? signal.get("Mx") - signal.get("Mi") : 999;
        double currentDiff = signal.containsKey("Ix") && signal.containsKey("Ii") ? signal.get("Ix") - signal.get("Ii") : 999;
        if(voltageDiff < 0 || currentDiff < 0){
            return Result.fail("信号量有误！");
        }
        // 3.如果没有规则编号
        List<WarnInfo> warnInfoList; // 记录查询结果
        if (ruleId == null) {
            // 如果没传入电压信息，用规则2
            if (voltageDiff == 999){
                warnInfoList = ruleMapper.selectRuleInfoById(2, batteryType, voltageDiff, currentDiff);
            }
            // 如果没有传入电流信息，用规则1
            else if (currentDiff == 999){
                warnInfoList = ruleMapper.selectRuleInfoById(1, batteryType, voltageDiff, currentDiff);
            }
            // 电压信息和电流信息都传入了，两个规则都用
            else{
                // 查出多条数据
                warnInfoList = ruleMapper.selectRuleInfoNoId(batteryType, voltageDiff, currentDiff);
            }
            // warnInfoList.forEach(System.out::print);
        }

        // 4.如果指定了规则编号
        else {
            if (ruleId != 1 && ruleId != 2){
                return Result.fail("规则编号有误！");
            }
            if ((ruleId == 1 && voltageDiff == 999) || (ruleId == 2 && currentDiff == 999)) {
                return Result.fail("信号量缺失！");
            }
            // 去数据库查询得到ruleName和alertLevel (一条数据)
            warnInfoList = ruleMapper.selectRuleInfoById(ruleId, batteryType, voltageDiff, currentDiff);
            // System.out.println(warnInfo);
        }

        // 5.封装后返回
        List<WarnResult> results = new ArrayList<>();
        for (WarnInfo info : warnInfoList) {
            WarnResult warnResult = new WarnResult();
            warnResult.setCarFrameId(carFrameId);
            warnResult.setBatteryType(batteryType);
            warnResult.setRuleName(info.getRuleName());
            if (info.getAlertLevel() == 5) {
                warnResult.setAlertLevel("不报警");
            } else {
                warnResult.setAlertLevel(info.getAlertLevel().toString());
            }
            results.add(warnResult);
        }
        results.forEach(System.out::println);
        return Result.ok(results);
    }
}
