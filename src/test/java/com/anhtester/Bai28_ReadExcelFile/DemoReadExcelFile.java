package com.anhtester.Bai28_ReadExcelFile;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFile {

    @Test
    public void testReadExcelFile(){
        //Khởi tạo đối tượng class ExcelHelper
        ExcelHelper excelHelper = new ExcelHelper();

        //Gọi hàm setExcelFile
        excelHelper.setExcelFile("src/test/resources/testdata/UsersData.xlsx", "Sheet1");

        //Gọi hàm getCellData để lấy giá trị của từng ô trong excel file
        System.out.println(excelHelper.getCellData("email", 1));
        System.out.println(excelHelper.getCellData("password", 1));
        System.out.println(excelHelper.getCellData(2, 1));
    }

    @Test
    public void testSetDataToExcel(){
        ExcelHelper excelHelper = new ExcelHelper();

        excelHelper.setExcelFile("src/test/resources/testdata/UsersData.xlsx", "Sheet1");

        excelHelper.setCellData("Success", 3, 1);
        excelHelper.setCellData("Fail", "status", 2);

    }

}
