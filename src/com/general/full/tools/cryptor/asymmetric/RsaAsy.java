package com.general.full.tools.cryptor.asymmetric;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaAsy {
    //生成秘钥对
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    //获取公钥(Base64编码)
    public static String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return byte2Base64(bytes);
    }

    //获取私钥(Base64编码)
    public static String getPrivateKey(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return byte2Base64(bytes);
    }

    //将Base64编码后的公钥转换成PublicKey对象
    public static PublicKey string2PublicKey(String pubStr) throws Exception {
        byte[] keyBytes = base642Byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey string2PrivateKey(String priStr) throws Exception {
        byte[] keyBytes = base642Byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //公钥加密
    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    //私钥解密
    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    //字节数组转Base64编码
    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    //Base64编码转字节数组
    public static byte[] base642Byte(String base64Key) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }

    public static void main(String[] args) {
        try {
            KeyPair keyPair = RsaAsy.getKeyPair();
            String publicKeyStr = RsaAsy.getPublicKey(keyPair);
            String privateKeyStr = RsaAsy.getPrivateKey(keyPair);
            System.out.println("RSA公钥Base64编码:" + " " + publicKeyStr);
            System.out.println("RSA私钥Base64编码：" + " " + privateKeyStr);
            String mingwen = "rsa测试";
            PublicKey publicKey = RsaAsy.string2PublicKey(publicKeyStr);
            byte[] publicEncript = RsaAsy.publicEncrypt(mingwen.getBytes(), publicKey);
            String byte2Base64 = RsaAsy.byte2Base64(publicEncript);
            System.out.println("公钥加密并base64编码的结果" + " " + byte2Base64);
            //----------------------------------------------------------------------
            PrivateKey privateKey = RsaAsy.string2PrivateKey(privateKeyStr);
            byte[] base642Byte = RsaAsy.base642Byte(byte2Base64);
            byte[] privateDecrypt = RsaAsy.privateDecrypt(base642Byte, privateKey);
            System.out.println("解密后的明文" + " " + new String(privateDecrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
