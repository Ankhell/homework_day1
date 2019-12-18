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

    public static boolean isNumber(String input_string){
        try {
            Long.parseLong(input_string, 16);
        }
        catch (NumberFormatException num){
            try {
                Long.parseLong(input_string, 8);
            }
            catch (NumberFormatException num1){
                try {
                    Long.parseLong(input_string, 2);
                }
                catch (NumberFormatException num3){
                    return false;
                }
            }
        }
        return true;
    }
}
