package com.example.micar;

import com.example.micar.service.IWarnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;


@SpringBootTest
class MiCarApplicationTests {
    @Autowired
    public IWarnService warnService;

    @Test
    void warnServiceByIdTest() {
        Long carFrameId = 1L;
        Long ruleId = 1L;
        HashMap<String, Double> map = new HashMap<>();
        map.put("Mx", 1.6);
        map.put("Mi", 0.6);
        warnService.queryWarn(carFrameId, ruleId, map);
    }

    @Test
    void warnServiceNoIdTest() {
        Long carFrameId = 1L;
        Long ruleId = null;
        HashMap<String, Double> map = new HashMap<>();
        map.put("Mx", 1.6);
        map.put("Mi", 0.6);
        map.put("Ix", 1.6);
        map.put("Ii", 0.6);
        warnService.queryWarn(carFrameId, ruleId, map);
    }

}
