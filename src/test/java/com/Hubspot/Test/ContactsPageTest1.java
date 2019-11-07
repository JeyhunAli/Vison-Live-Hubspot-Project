package com.Hubspot.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.HubspotUtility.ExcelUtility;
import com.qa.HubsPot.Pages.ContactsPage;
import com.qa.HubsPot.Pages.HomePage;
import com.qa.HubsPot.Pages.LoginPage;

public class ContactsPageTest1 {
	
	
	

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitle() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data = ExcelUtility.getTestData(Constants.CONTACTS_SHEET_NAME_contacts2);
		return data;
	}

	@Test(priority = 2, dataProvider = "getContactsTestData")
	public void createContactsTest(String email, String firstName, String lastName, String jobTitle)
			throws InterruptedException {
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

