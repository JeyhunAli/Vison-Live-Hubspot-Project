//package com.Hubspot.Test;
//
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.Hubspot.Base.BasePage;
//import com.HubspotUtility.Constants;
//import com.qa.HubsPot.Pages.ContactsPage;
//import com.qa.HubsPot.Pages.HomePage;
//import com.qa.HubsPot.Pages.LoginPage;
//
//public class ContactsPageTest {
//	
//	
//	
//	BasePage basePage;
//	Properties prop;
//	WebDriver driver;
//	LoginPage loginPage;
//	HomePage homePage;
//	ContactsPage contactsPage;
//
//	@BeforeTest
//	public void setUp() {
//		basePage = new BasePage();
//		prop = basePage.init_properties();
//		String browser = prop.getProperty("browser");
//		driver = basePage.init_driver(browser);
//		driver.get(prop.getProperty("url"));
//		loginPage = new LoginPage(driver);
//		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		contactsPage = homePage.goToContactsPage();
//	}
//	
//	@Test(priority=1)
//	public void verifyContactsPageTitle(){
//		String title = contactsPage.getContactsPageTitle();
//		System.out.println("contacts page title is: "+ title);
//		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
//	}
//	
//	
//	@Test(priority=2)
//	public void createContactsTest(){
//		contactsPage.createNewContact("Emiliya@gmail.com", "Emiliya", "Aliyeva", "Sen Qa Eng");
//	}
//	
//	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
//	
//	
//	
//	
//
//}
//
//
