package com.general.full.tools.coding;

public class AsciiCoding {
    /**
     *
     * 本方法实现字符的ascii编码
     * **/
    public static String charToInt(String str)
    {
        StringBuilder stringBuilder=new StringBuilder();
        char[] chars=str.toCharArray();
        for(char c:chars)
        {
            stringBuilder.append((int)c).append(" ");
        }
        return stringBuilder.toString();
    }
    /**
     * 该功能实现由ascii串到字符串转化
     * **/
    public static String intToString(String str)
    {
        StringBuilder stringBuilder=new StringBuilder();
        String[] chars=str.split(" ");
        for(String s:chars) {
            stringBuilder.append((char)Integer.parseInt(s));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(new AsciiCoding().charToInt("A"));
            System.out.println("中".getBytes().length);
        System.out.println(new AsciiCoding().intToString("97"));

    }
}

