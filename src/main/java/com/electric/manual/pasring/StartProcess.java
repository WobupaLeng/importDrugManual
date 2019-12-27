package com.electric.manual.pasring;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.common.utils.FileUtil;
import com.electric.manual.system.entity.DrugManual;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StartProcess {
    public static void main(String[] args) {
        String dirPath = "F:\\drugManuals_txt";
        int batchCount = 100;
        StartProcess startProcess = new StartProcess();
        startProcess.startProcess(dirPath, batchCount);
    }

    public List<DrugManual> startProcess(String dirPath, int batchCount) {
        ConvertToEntity convertToEntity = new ConvertToEntity();
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        assert fs != null;
        StringBuilder echo = new StringBuilder("process ===> start");

        int index = 0;
        int total = fs.length;
        List<DrugManual> drugManualList = new ArrayList<>(total);
        for (File f : fs) {
            index++;
            String context = FileUtil.readFile(f);
            List<Map.Entry<DrugManualAttr, Integer>> list = convertToEntity.textMark(context);
            drugManualList.add(convertToEntity.parseToEntity(context, list, f.getName().replaceAll(".txt", "")));

            if (index % 200 == 0) {
                System.out.println(echo.append((index * 100) / total).append("%"));
                echo.delete(0, echo.length());
            }
        }
        return drugManualList;
    }
}
