package com.example.micar.service;

import com.example.micar.dto.Result;

import java.util.Map;


public interface IWarnService {
    Result queryWarn(Long carFrameId, Long ruleId, Map<String, Double> signal);
}
