package com.electric.manual.pasring;

import static com.electric.manual.pasring.general.Convert.convert;

public class StartProcess {
    public static void main(String[] args) {
        String dirPath = "F:\\drugManuals_HTML";
        String newPath = "F:\\new_txt";
        general(dirPath, newPath);
        //jsoup(dirPath);
    }

    public static void general(String dirPath, String newPath) {
        convert(dirPath, newPath);
    }

    public static void jsoup(String dirPath, String newPath) {
        convert(dirPath, newPath);
    }
}
