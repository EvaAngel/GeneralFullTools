package com.general.full.tools.coding;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

public class HexCoding {
    public static String enHex(String string) throws UnsupportedEncodingException {
        return Hex.encodeHexString(string.getBytes("UTF-8"));
    }
    public static String deHex(String string) throws UnsupportedEncodingException, DecoderException {
        return new String(Hex.decodeHex(string.toCharArray()),"UTF-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
        System.out.println(HexCoding.enHex("付"));
        System.out.println(HexCoding.deHex("e4bb98"));
    }
}
