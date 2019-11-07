
//a[@id="nav-primary-home"]


package com.Hubspot.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.qa.HubsPot.Pages.HomePage;
import com.qa.HubsPot.Pages.LoginPage;

public class HomePageTest {
	
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();                   //creating object
		prop = basePage.init_properties();           //creating object
		String browser = prop.getProperty("browser");  //getting property driver by keyname. keyname is in the properties file  
		driver = basePage.init_driver(browser);        //init driver is in base page by base class name I'm calling and passing driver
		driver.get(prop.getProperty("url"));           //

		
		loginPage = new LoginPage(driver);  //creating object
	    homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	    
	    }
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("title of the home page is: " +title );
		Assert.assertEquals(title, Constants.HOME_PAGE_title, "home page title is missing check it out ");
		
	}
	
	@Test (priority = 2)
	public void verifyHeaderTest() {
		Assert.assertTrue(homePage.isHeaderPresent(), "header is not present or locator is not created properly ");
		String header = homePage.getHomePageHeaderValue();
		System.out.println("home page header value is :" + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
		
	}
	
	@Test (priority = 3)
	public void verifyLogedInUser() {
		Assert.assertTrue(homePage.account_Name_Present(), "loged user is not present ");
		String accountValue = homePage.getAccount_Name_PresentValue();
		System.out.println("account value is :" + accountValue);
		Assert.assertEquals(accountValue, prop.getProperty("accountName"));
		
		
	}
	
	
	
	
	public void tearDown() {
		driver.quit();
	}
	

}
























































