package com.general.full.tools.coding;

import com.general.full.tools.computer_principle.NumberToNumber;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlCoding {
    /**
     *
     * 本功能实现url编码
     *
     * 说明：只能实现非字母、数字的url编码，因为对于字母或数字，可以直接转化为ascii码，再转化为16进制
     * **/
    public static String enUrlCoding(String str,String code)
    {
        String urlcode=null;
        try {
            urlcode=URLEncoder.encode(str,code);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlcode;
    }
    /**
     * 实现字母、数字的url编码，即进行了一个十六进制转后加入%    这里还是使用的unicode编码
     * **/
    public static String enUrlCoding2(String str)
    {
        StringBuilder stringBuilder=new StringBuilder();
        if(str.matches("[^0-9]*")) {
            char[] chars = str.toCharArray();
            for(char c:chars)
            {
                String s=NumberToNumber.decimalToHex(String.valueOf((int)c)).toUpperCase();
                stringBuilder.append("%").append(s);
            }
        }
        else
        {
            String s=NumberToNumber.decimalToHex(str).toUpperCase();
            stringBuilder.append("%").append(s);
        }
        return stringBuilder.toString();
    }
    /**
     * 此方法实现全量字母数字的url解码操作
     * **/
    public static String deUrlCoding2(String string)
    {
        String[] strings=string.split("%");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<strings.length;i++)
        {
            stringBuilder.append(UnicodeCoding.deUnicode("\\u"+strings[i]));
        }
        return stringBuilder.toString();
    }

    /***
     *  此方法实现仅对非字母、数字的字符进行解码操作
     * **/
    public static String deUrlCoding(String string,String code)
    {
        String urlcode=null;
        try {
            urlcode= URLDecoder.decode(string,code);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlcode;
    }




    public static void main(String[] args)
    {
        /*System.out.println(new UrlCoding().enUrlCoding("付鑫","UNICODE"));
        System.out.println(new UrlCoding().enUrlCoding("付鑫","UTF-8"));
        System.out.println(new UrlCoding().enUrlCoding("<img src=@ onerror=alert(/xss/)>","UNICODE"));
        System.out.println(new UrlCoding().enUrlCoding2("<img src=@ onerror=alert(/xss/)>"));
        System.out.println(new UrlCoding().enUrlCoding2("付鑫"));*/
        System.out.println(UrlCoding.deUrlCoding2("%4ED8%946B"));
        System.out.println(new UrlCoding().enUrlCoding2("123"));
    }
}
