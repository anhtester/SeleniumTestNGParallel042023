package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.drivers.DriverManager;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {

    public void verifyCustomerDetail(String companyName) {
        Assert.assertEquals(DriverManager.getDriver().findElement(inputCompany).getAttribute("value"), companyName, "Message");
        //Viết thêm cho các fields khác
    }

}
