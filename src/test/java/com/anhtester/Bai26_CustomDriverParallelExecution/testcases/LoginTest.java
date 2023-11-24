package com.anhtester.Bai26_CustomDriverParallelExecution.testcases;

import com.anhtester.Bai26_CustomDriverParallelExecution.pages.DashboardPage;
import com.anhtester.Bai26_CustomDriverParallelExecution.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.dataprovider.DataProviderFactory;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(dataProvider = "DataLoginSuccess", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
        dashboardPage.logOut();
    }

    @Test(dataProvider = "DataLoginFail", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithEmailInvalid(String email, String password) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
