package com.anhtester.Bai28_ReadExcelFile;

import com.anhtester.Bai26_CustomDriverParallelExecution.pages.DashboardPage;
import com.anhtester.Bai26_CustomDriverParallelExecution.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UsersData.xlsx", "Sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1)
        );
        loginPage.verifyLoginSuccess();
        CaptureHelper.captureScreenshot("testLoginSuccess");
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UsersData.xlsx", "Sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2)
        );
        loginPage.verifyLoginFail();
        CaptureHelper.captureScreenshot("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/UsersData.xlsx", "Sheet1");

        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("email", 3),
                excelHelper.getCellData("password", 3)
        );
        loginPage.verifyLoginFail();
        CaptureHelper.captureScreenshot("testLoginWithPasswordInvalid");
    }
}
