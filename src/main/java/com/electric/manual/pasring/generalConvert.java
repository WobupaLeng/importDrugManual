package com.electric.manual.pasring;

import java.io.File;

import static com.electric.manual.common.utils.FileUtil.*;

class generalConvert {
    static void convert(String dirPath, String newPath){
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        assert fs != null;
        StringBuilder echo = new StringBuilder("process ===> start");
        int index = 0;
        int total = fs.length;
        for (File f : fs) {
            index++;
            String newFile = f.getName().substring(0, f.getName().lastIndexOf(".")) + ".txt";
            String fileInfo = newPath + "\\" + newFile;
            String str = readFile(f);

            String result = htmlToText(str);

            writeFile(fileInfo, result);
            if (index % 50 == 0) {
                echo.append((index * 100) / total).append("%");
                System.out.println(echo);
                echo.delete(0, echo.length());
            }
        }
        System.out.println("finish");
    }

    private static String htmlToText(String html) {
        StringBuilder sb = new StringBuilder(html.length());
        char[] data = html.toCharArray();
        int start = 0;
        boolean previousIsPre = false;
        Token token;

        for (; ; ) {
            token = parse(data, start, previousIsPre);
            if (token == null)
                break;
            previousIsPre = token.isPreTag();
            if (!token.getText().equals("\r\n") && !token.getText().equals("\r\n "))
                sb.append(token.getText());
            start += token.getLength();
        }
        return sb.toString();
    }

    private static Token parse(char[] data, int start, boolean previousIsPre) {
        if (start >= data.length)
            return null;
        // try to read next char:
        char c = data[start];
        if (c == '<') {
            // this is a tag or comment or script:
            int end_index = indexOf(data, start + 1, '>');
            if (end_index == (-1)) {
                // the left is all text!
                return new Token(Token.TOKEN_TEXT, data, start, data.length, previousIsPre);
            }
            String s = new String(data, start, end_index - start + 1);
            // now we got s="<...>":
            if (s.startsWith("<!--")) { // this is a comment!
                int end_comment_index = indexOf(data, start + 1, "-->");
                if (end_comment_index == (-1)) {
                    // illegal end, but treat as comment:
                    return new Token(Token.TOKEN_COMMENT, data, start, data.length, previousIsPre);
                } else
                    return new Token(Token.TOKEN_COMMENT, data, start, end_comment_index + 3, previousIsPre);
            }
            String s_lowerCase = s.toLowerCase();
            if (s_lowerCase.startsWith("<script")) { // this is a script:
                int end_script_index = indexOf(data, start + 1, "</script>");
                if (end_script_index == (-1))
                    // illegal end, but treat as script:
                    return new Token(Token.TOKEN_SCRIPT, data, start, data.length, previousIsPre);
                else
                    return new Token(Token.TOKEN_SCRIPT, data, start, end_script_index + 9, previousIsPre);
            } else { // this is a tag:
                return new Token(Token.TOKEN_TAG, data, start, start + s.length(), previousIsPre);
            }
        }
        // this is a text:
        int next_tag_index = indexOf(data, start + 1, '<');
        if (next_tag_index == (-1))
            return new Token(Token.TOKEN_TEXT, data, start, data.length, previousIsPre);
        return new Token(Token.TOKEN_TEXT, data, start, next_tag_index, previousIsPre);
    }

    private static int indexOf(char[] data, int start, String s) {
        char[] ss = s.toCharArray();
        // TODO: performance can improve!
        for (int i = start; i < (data.length - ss.length); i++) {
            // compare from data[i] with ss[0]:
            boolean match = true;
            for (int j = 0; j < ss.length; j++) {
                if (data[i + j] != ss[j]) {
                    match = false;
                    break;
                }
            }
            if (match)
                return i;
        }
        return -1;
    }

    private static int indexOf(char[] data, int start, char c) {
        for (int i = start; i < data.length; i++) {
            if (data[i] == c)
                return i;
        }
        return (-1);
    }
}
