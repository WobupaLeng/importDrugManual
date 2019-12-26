package com.electric.manual.pasring;

import com.electric.manual.common.utils.FileUtil;

import java.io.File;

public class StartProcess {
    public static void main(String[] args) {
        String dirPath = "F:\\drugManuals_txt";
        ConvertToEntity convertToEntity = new ConvertToEntity();
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        assert fs != null;
        StringBuilder echo = new StringBuilder("process ===> start");
        int index = 0;
        int total = fs.length;
        for (File f : fs) {
            index++;
            String context = FileUtil.readFile(f);
            convertToEntity.textMark(context, f.getName());
            System.out.println(echo.append((index * 100) / total).append("%"));
            echo.delete(0,echo.length());
        }
        System.out.println(echo);
    }
}
