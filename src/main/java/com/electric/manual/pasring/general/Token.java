package com.electric.manual.pasring.general;

import java.util.HashMap;
import java.util.Map;

public class Token {
    public static final int TOKEN_TEXT = 0; // html text.
    public static final int TOKEN_COMMENT = 1; // comment like <!-- comments... -->
    public static final int TOKEN_TAG = 2; // tag like <pre>, <font>, etc.
    public static final int TOKEN_SCRIPT = 3;

    private static final char[] TAG_BR = "<br".toCharArray();
    private static final char[] TAG_P = "<p".toCharArray();
    private static final char[] TAG_LI = "<li".toCharArray();
    private static final char[] TAG_PRE = "<pre".toCharArray();
    private static final char[] TAG_HR = "<hr".toCharArray();

    private static final char[] END_TAG_TD = "</td>".toCharArray();
    private static final char[] END_TAG_TR = "</tr>".toCharArray();
    private static final char[] END_TAG_LI = "</li>".toCharArray();

    private static final Map<String, String> SPECIAL_CHARS = new HashMap<>();

    private int type;
    private String html;
    private String text = null;
    private int length;
    private boolean isPre = false;

    static {
        SPECIAL_CHARS.put("&quot;", "/");
        SPECIAL_CHARS.put("&lt;", "<");
        SPECIAL_CHARS.put("&gt;", ">");
        SPECIAL_CHARS.put("&amp;", "&");
        SPECIAL_CHARS.put("&reg;", "(r)");
        SPECIAL_CHARS.put("&copy;", "(c)");
        SPECIAL_CHARS.put("&nbsp;", " ");
        SPECIAL_CHARS.put("&pound;", "?");
    }

    public Token(int type, char[] data, int start, int end, boolean previousIsPre) {
        this.type = type;
        this.length = end - start;
        this.html = new String(data, start, length);
        //System.out.println("[Token] html=" + html + ".");
        parseText(previousIsPre);
        //System.out.println("[Token] text=" + text + ".");
    }

    public int getLength() {
        return length;
    }

    public boolean isPreTag() {
        return isPre;
    }

    private void parseText(boolean previousIsPre) {
        if (type == TOKEN_TAG) {
            /*char[] cs = html.toCharArray();
            if (compareTag(TAG_P, cs))
                text = "/n";
            else if (compareTag(TAG_BR, cs))
                text = "/n";
            else if (compareTag(TAG_LI, cs))
                text = "/n* ";
            else if (compareTag(TAG_PRE, cs))
                isPre = true;
            else if (compareTag(TAG_HR, cs))
                text = "/n--------/n";
            else if (compareString(END_TAG_TD, cs))
                text = "/t";
            else if (compareString(END_TAG_TR, cs) || compareString(END_TAG_LI, cs))
                text = "/n";*/
        }
        // text token:
        else if (type == TOKEN_TEXT) {
            text = toText(html, previousIsPre);
        }
    }

    public String getText() {
        return text == null ? "" : text;
    }

    private String toText(String html, final boolean isPre) {
        char[] cs = html.toCharArray();
        StringBuilder buffer = new StringBuilder(cs.length);
        int start = 0;
        boolean continueSpace = false;
        char current, next;
        while (start < cs.length) {
            current = cs[start]; // read current char
            if (start + 1 < cs.length) // and next char
                next = cs[start + 1];
            else
                next = '/' + '0';
            if (current == ' ') {
                if (isPre || !continueSpace) {
                    buffer.append(' ');
                }
                continueSpace = true;
                start++;
                continue;
            }
            // not ' ', so:
            if (current == ('/' + 'r') && next == ('/' + 'n')) {
                if (isPre) {
                    //buffer.append(('/' + 'n'));
                }
                start += 2;
                continue;
            }
            if (current == ('/' + 'n') || current == ('/' + 'r')) {
                if (isPre) {
                    //buffer.append(('/' + 'n'));
                }
                start++;
                continue;
            }

            continueSpace = false;
            if (current == '&') {
                // maybe special char:
                int length = readUtil(cs, start);
                if (length == (-1)) {
                    buffer.append('&');
                    start++;
                } else {
                    String spec = new String(cs, start, length);
                    String specChar = SPECIAL_CHARS.get(spec);
                    if (specChar != null) { // special chars!
                        buffer.append(specChar);
                        start += length;
                    } else { // check if like '&#1234':
                        if (next == '#') { // maybe a char
                            String num = new String(cs, start + 2, length - 3);
                            try {
                                int code = Integer.parseInt(num);
                                if (code > 0 && code < 65536) { // this is a special char:
                                    buffer.append((char) code);
                                    start++;
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            buffer.append("&#");
                            start += 2;
                        } else { // just '&':
                            buffer.append('&');
                            start++;
                        }
                    }
                }
            } else {
                buffer.append(current);
                start++;
            }
        }
        return buffer.toString();
    }

    private int readUtil(char[] cs, int start) {
        for (int i = start; i < start + 10; i++) {
            if (cs[i] == ';') {
                return i - start + 1;
            }
        }
        return (-1);
    }

    private boolean compareTag(char[] ori_tag, char[] tag) {
        if (ori_tag.length >= tag.length)
            return false;
        for (int i = 0; i < ori_tag.length; i++) {
            if (Character.toLowerCase(tag[i]) != ori_tag[i])
                return false;
        }

        char c = Character.toLowerCase(tag[ori_tag.length]);
        return c < 'a' || c > 'z';
    }

    private boolean compareString(char[] ori, char[] comp) {
        if (ori.length > comp.length)
            return false;
        for (int i = 0; i < ori.length; i++) {
            if (Character.toLowerCase(comp[i]) != ori[i])
                return false;
        }
        return true;
    }

    public String toString() {
        return html;
    }
}

