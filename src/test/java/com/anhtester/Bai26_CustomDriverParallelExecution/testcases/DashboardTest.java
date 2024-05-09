package com.anhtester.Bai26_CustomDriverParallelExecution.testcases;

import com.anhtester.Bai26_CustomDriverParallelExecution.pages.CustomerPage;
import com.anhtester.Bai26_CustomDriverParallelExecution.pages.DashboardPage;
import com.anhtester.Bai26_CustomDriverParallelExecution.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage() {
        //Login
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

    }

    @Test
    public void testAdminRole() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(PropertiesHelper.getValue("EMAIL"), PropertiesHelper.getValue("PASSWORD"));
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }

    @Test
    public void testProjectRole() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("project@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportNotDisplay();
    }

}
