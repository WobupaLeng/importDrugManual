package com.electric.manual.pasring.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.File;

import static com.electric.manual.common.utils.FileUtil.readFile;

public class Convert {
    public void convert(String dirPath, String newPath) {
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        assert fs != null;
        for (File f : fs) {
            String content = readFile(f);
            Document doc = Jsoup.parse(content);
            String title = doc.title();
            System.out.println(title);

            Element a = doc.getElementById("panel_Profile");
            Elements li_content = a.getElementsByTag("li");

            //提取方式一:
            for (Element i : li_content) {
                String tag = i.tagName();
                if (tag.equals("li")) {
                    System.out.println(i.text());
                }
            }

            //提取方式二:
            for (Element i : li_content) {
                String tag = i.tagName();
                if (tag.equals("li")) {
                    String fre_content = i.ownText();

                    System.out.println(fre_content);
                    if (i.children().size() > 0 && i.children() != null) {
                        String after_content = i.child(0).text();
                        System.out.println(after_content);
                    }
                }
            }

            //提取方式三:
            for (Element i : li_content) {
                String tag = i.tagName();
                if (tag.equals("li")) {
                    String all_content = i.text();
                    String all_string = Jsoup.clean(all_content, Whitelist.none());
                    String[] all = all_string.split("：");
                    if (all.length > 0) {
                        String fre_content = all[0].toString();
                        System.out.println(fre_content);
                        String after_content = all[1].toString();
                        System.out.println(after_content);
                    }
                }
            }
        }
    }
}
