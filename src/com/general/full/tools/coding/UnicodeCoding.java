package com.general.full.tools.coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 本类实现字母、汉字的Unicode编码
 **/
public class UnicodeCoding {
    /**
     * http://www.cnblogs.com/tsiangleo/p/4433410.html
     * java 默认使用Unicode进行编码，所以所有的字符都是两字节组成
     * https://blog.csdn.net/gjb724332682/article/details/43229563
     **/
    public static String enUnicode(String str) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            // 取出每一个字符,这个地方如果是汉字自动转换为十进制数字
            char c = str.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    public static String deUnicode(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(UnicodeCoding.enUnicode("付鑫"));
        System.out.println(UnicodeCoding.deUnicode("\\u4e2d\\u56fd\\u4eba"));
    }

}
