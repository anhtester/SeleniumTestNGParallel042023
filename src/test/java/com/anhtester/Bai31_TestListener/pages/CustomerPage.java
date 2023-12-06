package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CustomerPage {

    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");

    //Trang Customers List
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href, 'clients/all_contacts')]");
    private By inputSearchCustomers = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");

    //Add New Customer
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVatNumber = By.xpath("//input[@id='vat']");
    public By inputPhone = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroups = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@aria-label='Search']");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    public void clickButtonAddNew() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void verifyRedirectCustomerPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCustomerPage).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(WebUI.getElementText(headerCustomerPage), "Customers Summary", "Giá trị header của Customer page không đúng");
        WebUI.assertContains(WebUI.getElementText(headerCustomerPage), "Customers Summary", "");
    }

    public void inputDataCustomer(String companyName) {
        WebUI.setText(inputCompany, companyName);
        WebUI.setText(inputVatNumber, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://viettel.com.vn");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroups, "Gold");
        WebUI.sleep(1);
        //driver.findElement(inputSearchGroups).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchGroups, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress, "Hà Nội");
        WebUI.setText(inputCity, "Hà Nội");
        WebUI.setText(inputState, "Thăng Long");
        WebUI.setText(inputZipCode, "1234");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        //driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public ProfilePage searchCustomer(String companyName) {
        WebUI.setText(inputSearchCustomers, companyName);
        WebUI.sleep(2);
        WebUI.clickElement(firstItemCustomerOnTable);


        return new ProfilePage();
    }

}
