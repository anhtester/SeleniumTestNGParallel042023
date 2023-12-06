package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class DashboardPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("(//a[.='Logout'])[1]");
    private By optionProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");

    public CustomerPage clickMenuCustomers() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        System.out.println("Click on menu Customers");

        return new CustomerPage();
    }

    public void clickMenuProjects() {
        WebUI.clickElement(menuProjects);
        System.out.println("Click on menu Projects");
    }

    public LoginPage logOut() {
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdown Profile");
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");

        return new LoginPage();
    }

}
