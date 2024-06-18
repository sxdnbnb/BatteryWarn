package com.example.micar.controller;

import com.example.micar.dto.Result;
import com.example.micar.service.IWarnService;
import com.example.micar.dto.Body;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WarnController {
    @Resource
    public IWarnService warnService;

    // 查询报警等级
    @PostMapping("/warn")
    public Result queryWarn(@RequestBody Body requestBody){
        return warnService.queryWarn(requestBody.getCarFrameId(), requestBody.getRuleId(), requestBody.getSignal());
    }
}
