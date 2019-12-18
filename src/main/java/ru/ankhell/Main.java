package ru.ankhell;

public class Main {
    public static String intToBin(long input_number){
        return Long.toBinaryString(input_number);
    }
    public static String intToHex(long input_number){
        return  Long.toHexString(input_number);
    }
    public static String BinToHex(String input_hexNumber){
        return  Long.toHexString(Long.parseLong(input_hexNumber,2));
    }
}
