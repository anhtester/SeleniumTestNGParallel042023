package com.anhtester.dataprovider;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "DataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess() {
//        return new Object[][]{
//                {"admin@example.com", "123456"},
//                {"admin@example.com", "123456"}
//        };
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/LoginData.xlsx", "Sheet1");
        return data;
    }

    @DataProvider(name = "DataLoginFail", parallel = true)
    public Object[][] dataLoginFail() {
        return new Object[][]{
                {"admin123@example.com", "123456"},
                {"customer123@example.com", "123456"}
        };
    }

    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable( "src/test/resources/testdata/LoginData.xlsx", "Sheet1", 4, 3);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

}
