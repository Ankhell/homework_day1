package ru.ankhell;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static ru.ankhell.Main.*;

public class TestMain {
    private void soutThread(){
        System.out.println((Thread.currentThread().getId()));
    }

    @DataProvider(name = "intBinProvider", parallel = true)
    public Object[][] dP1(){
        return new Object[][]{
                {256,"100000000"},{212,"11010100"},{911,"1110001111"}
        };
    }

    @Test(description = "Проверка метода intToBin", dataProvider = "intBinProvider")
    public void testIntToBin(int input_integer, String expectedResult){
        soutThread();
        Assert.assertEquals(intToBin(input_integer),expectedResult);
    }

    @DataProvider(name = "intHexProvider", parallel = true)
    public Object[][] dP2(){
        return new Object[][]{
                {256,"100"},{212,"d4"},{911,"38f"}
        };
    }

    @Test(description = "Проверка метода intToHex", dataProvider = "intHexProvider")
    public void testIntToHex(int input_integer, String expectedResult){
        soutThread();
        Assert.assertEquals(intToHex(input_integer),expectedResult);
    }

    @DataProvider(name = "BinHexProvider", parallel = true)
    public Object[][] dP3(){
        return new Object[][]{
                {"10001010101101","22ad"},{"100010101","115"},{"1111010101001010011","7aa53"}
        };
    }

    @Test(description = "Проверка метода binToHex", dataProvider = "BinHexProvider")
    public void testBinToHex(String input_string, String expectedResult){
        soutThread();
        Assert.assertEquals(binToHex(input_string),expectedResult);
    }

    @DataProvider(name = "notBinStringProvider", parallel = true)
    public Object[] dp4(){
        return new Object[]{"nan","16ad","2135","400"};
    }

    @Test(description = "Проверка реакции метода binToHex на некорректный ввод", dataProvider = "notBinStringProvider",expectedExceptions = NumberFormatException.class)
    public void incorrectInputBinToHex(String inputString){
        soutThread();
        binToHex(inputString);
    }

    @DataProvider(name = "isNumPositive", parallel = true)
    public Object[] dp5(){
        return new Object[]{"400","16ad","1010111"};
    }

    @Test(description = "Положительный тест метода isNum", dataProvider = "isNumPositive")
    public void isNumPositiveTest(String inputString){
        soutThread();
        Assert.assertTrue(isNumber(inputString));
    }

    @DataProvider(name = "isNumNegative", parallel = true)
    public Object[] dp6(){
        return new Object[]{null,"nan","Hello world!"};
    }

    @Test(description = "Отрицательный тест метода isNum", dataProvider = "isNumNegative")
    public void isNumNegativeTest(String inputString){
        soutThread();
        Assert.assertFalse(isNumber(inputString));
    }

}
