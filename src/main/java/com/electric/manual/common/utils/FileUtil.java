package com.electric.manual.common.utils;

import java.io.*;

public class FileUtil {
    public static void writeFile(String fileInfo, String result) {
        try {
            File writeName = new File(fileInfo);
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖

            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);

            out.write(result);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
