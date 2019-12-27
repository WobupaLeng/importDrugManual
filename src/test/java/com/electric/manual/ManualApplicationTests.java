package com.electric.manual;

import com.electric.manual.pasring.ConvertToEntity;
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
        int batchCount = 1000;
        String dirPath = "F:\\drugManuals_txt";
        //String dirPath = "F:\\test";

        ConvertToEntity convert = new ConvertToEntity();
        List<DrugManual> drugManuals = convert.startProcess(dirPath);

        System.out.println("获得说明书个数：" + drugManuals.size());
        System.out.println("开始保存到数据库...");
        drugManualService.saveBatch(drugManuals, batchCount);
        System.out.println("finish");
    }
}
