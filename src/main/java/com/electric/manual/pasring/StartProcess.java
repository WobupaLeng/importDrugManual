package com.electric.manual.pasring;

public class StartProcess {
    public static void main(String[] args) {
        String dirPath = "F:\\drugManuals_HTML";
        String newPath = "F:\\new_txt";
        generalConvert.convert(dirPath, newPath);
        jsoupConvert.convert(dirPath,newPath);
    }
}
