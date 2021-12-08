package it.alushkja.crypto;

import org.apache.commons.codec.binary.Hex;

public class Utils {

    private Utils(){ }
    public static boolean isNullOrEmpty(String s){return s == null || s.trim().length() == 0;}
    public static boolean isNotEmpty(String s){
        return s != null && s.trim().length() > 0;
    }
    public static void printByteArray(String name, byte[] bytes) {
        System.out.println(name + ": "+ Hex.encodeHexString(bytes));
        System.out.println(name + " length: " + bytes.length + " bytes, " + bytes.length * 8 + " bits.");
        System.out.println("\r\n");
    }
    public static void printText(String name, byte[] bytes) {
        System.out.println(name + ": "+ new String(bytes));
        System.out.println(name + "length: " + bytes.length + " bytes, " + bytes.length * 8 + " bits.");
        System.out.println("\r\n");
    }
}
