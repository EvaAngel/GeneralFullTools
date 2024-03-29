package com.general.full.tools.cryptor.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512 {
    public static String SHA512(String string)
    {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-512");
            digest.update(string.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(Sha512.SHA512("付鑫"));
    }
}
