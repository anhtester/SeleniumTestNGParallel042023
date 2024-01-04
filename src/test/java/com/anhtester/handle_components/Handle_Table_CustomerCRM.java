package com.anhtester.handle_components;

import com.anhtester.Bai31_TestListener.pages.CustomerPage;
import com.anhtester.Bai31_TestListener.pages.DashboardPage;
import com.anhtester.Bai31_TestListener.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class Handle_Table_CustomerCRM extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testCheckDataOnTable(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.searchCustomerOnTable("Viettel A1"); //Tra ra 25 records /page
        //customerPage.checkPageTotal(5);
        customerPage.checkSearchTableByColumn(3, "Viettel A1"); //So sanh contains
    }

}
