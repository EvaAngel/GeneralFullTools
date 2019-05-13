package com.general.full.tools.coding;

import java.io.UnsupportedEncodingException;



public class UTF_8Coding {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    /**
     * 本功能实现utf-8编码
     * https://www.coderxing.com/java-string-conv-principle.html   Java内部的编码原理详解
     * **/
    public static String enUtf_8(String string) throws UnsupportedEncodingException {
        String str=bytesToHex(string.getBytes("UTF-8"));
        StringBuilder stringBuilder=new StringBuilder();
        int count=str.length()/string.length();
        int begin=0;
        for(int i=0;i<string.length();i++)
        {
            stringBuilder.append("\\u").append(str.substring(begin,begin+count));
            begin+=count;
        }
        return stringBuilder.toString();
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    /**
     * https://blog.csdn.net/u013905744/article/details/74452012/  实现utf-8的解码
     * **/
    public static String deUtf_8(String string)
    {
        String[] strings=string.split("\\\\u");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<strings.length;i++)
        {
            stringBuilder.append(convertUTF8ToString(strings[i]));
        }
        return stringBuilder.toString();
    }
    public static String convertUTF8ToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        try {
            s = s.toUpperCase();
            int total = s.length() / 2;
            //标识字节长度
            int pos = 0;
            byte[] buffer = new byte[total];
            for (int i = 0; i < total; i++) {
                int start = i * 2;
                //将字符串参数解析为第二个参数指定的基数中的有符号整数。
                buffer[i] = (byte) Integer.parseInt(s.substring(start, start + 2), 16);
                pos++;
            }
            //通过使用指定的字符集解码指定的字节子阵列来构造一个新的字符串。
            //新字符串的长度是字符集的函数，因此可能不等于子数组的长度。
            return new String(buffer, 0, pos, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(UTF_8Coding.enUtf_8("付鑫"));
        System.out.println(UTF_8Coding.deUtf_8("\\uE4BB98\\uE991AB"));
    }
}
