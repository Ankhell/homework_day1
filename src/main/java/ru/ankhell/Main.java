package ru.ankhell;

public class Main {
    public static String intToBin(long input_number){
        return Long.toBinaryString(input_number);
    }
    public static String intToHex(long input_number){
        return  Long.toHexString(input_number);
    }
    public static String binToHex(String input_hexNumber) throws NumberFormatException{
//        Ну раз уж у нас есть функционал проверки корректности входных данных, то почему бы и нет?..
        try{
            return Long.toHexString(Long.parseLong(input_hexNumber, 2));
        }
        catch (NumberFormatException error){
            throw new NumberFormatException("Входящая строка не является двоичным числом");
        }
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
