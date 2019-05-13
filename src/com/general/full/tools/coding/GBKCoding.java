package com.general.full.tools.coding;

import java.io.UnsupportedEncodingException;

public class GBKCoding {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    /**
     *http://www.knowsky.com/resource/gb2312tbl.htm   gbk对照表
     * 实现gbk编码
     * **/
    public static String enGBK(String string) throws UnsupportedEncodingException {
        String str=bytesToHex(string.getBytes("GBK"));
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
     * 解码
     * **/
    public static String deGBK(String string) throws Exception {
        String[] strings=string.split("\\\\u");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<strings.length;i++)
        {
            stringBuilder.append(GBK2Chinese(strings[i]));
        }
        return stringBuilder.toString();
    }
    //16进制GBK字符串转换成中文
    public static String GBK2Chinese(String GBKStr)throws Exception{
        byte[] b = HexString2Bytes(GBKStr);
        String chineseStr = new String(b, "gbk");//输入参数为字节数组
        return chineseStr;
    }

    //把16进制字符串转换成字节数组
    public static byte[] HexString2Bytes(String hexStr) {
        byte[] b = new byte[hexStr.length() / 2];
        for (int i = 0; i < b.length; i++)
            b[i]=(byte) Integer.parseInt(hexStr.substring(2*i,2*i+2),16);
        return b;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(GBKCoding.enGBK("付鑫"));
        System.out.println(GBKCoding.deGBK("\\uB8B6\\uF6CE"));
    }
}
