package com.general.full.tools.coding;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Coding {

    /**
     * 本方法实现字符串的base64编码
     * **/
    public static String enBase64(String string) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(string.getBytes("UTF-8"));
    }


    /**
     * 本方法实现字符串的base64解码
     * **/
    public static String deBase64(String string) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(string),"UTF-8");
    }


    /**
     * 主方法
     * **/
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(enBase64("付"));
        System.out.println(deBase64("5LuY"));
    }

}
