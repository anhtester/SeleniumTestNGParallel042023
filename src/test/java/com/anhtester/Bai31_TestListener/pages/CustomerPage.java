package com.anhtester.Bai31_TestListener.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
    private By pageTotal = By.xpath("//div[@id='DataTables_Table_0_info']");

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

    public void searchCustomerOnTable(String companyName) {
        WebUI.setText(inputSearchCustomers, companyName);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded();
    }

    public int checkPageTotal(int total) {
        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println(pageTotalText);
        //Showing 1 to 25 of 159 entries (filtered from 519 total entries)
        String pageTotalNumber1[] = pageTotalText.split(" ");
        //System.out.println(pageTotalNumber1);
        String pageTotalNumber2 = pageTotalText.split(" ")[3];
        System.out.println("Check Page Total: " + pageTotalNumber2);

        Assert.assertEquals(Integer.parseInt(pageTotalNumber2), total, "The page total not match.");

        return Integer.parseInt(pageTotalNumber2);

    }

    public int checkPageTotal() {
        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println(pageTotalText);
        //Showing 1 to 25 of 159 entries (filtered from 519 total entries)
        String pageTotalNumber1[] = pageTotalText.split(" ");
        //System.out.println(pageTotalNumber1);
        String pageTotalNumber2 = pageTotalText.split(" ")[3];
        System.out.println("Check Page Total: " + pageTotalNumber2);

        return Integer.parseInt(pageTotalNumber2);

    }

    public void checkSearchTableByColumn(int column, String value) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);

        //Assert.assertEquals(rowTotal, checkPageTotal(), "The page total not equals records total");

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);

            System.out.print(value + " - "); //Expected
            System.out.println(elementCheck.getText()); //Actual
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }

}