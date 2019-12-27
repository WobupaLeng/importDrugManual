package com.electric.manual;

import com.electric.manual.pasring.StartProcess;
import com.electric.manual.system.entity.DrugManual;
import com.electric.manual.system.service.IDrugManualService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManualApplicationTests {
    @Autowired
    private IDrugManualService drugManualService;
    @Test
    void contextLoads() {
        System.out.println("start");

        StartProcess process = new StartProcess();
        List<DrugManual> drugManuals = process.startProcess("F:\\drugManuals_txt", 100);

        System.out.println("获得说明书个数：" + drugManuals.size());
        System.out.println("开始保存到数据库...");
        drugManualService.saveBatch(drugManuals, 100);
        System.out.println("finish");
    }

}
