package com.Hubspot.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.qa.HubsPot.Pages.LoginPage;

public class LoginPageTest {


	/**
	 *  BeforeMethod - Test - AfterTest
	 *  here in class level I'm defining base page, properties, webdriver and loginpage to access all the parameters 
	 */

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();                   //creating object
		prop = basePage.init_properties();           //creating object
		String browser = prop.getProperty("browser");  //getting property driver by keyname. keyname is in the properties file  
		driver = basePage.init_driver(browser);        //init driver is in base page by base class name I'm calling and passing driver
		driver.get(prop.getProperty("url"));           //

	
		loginPage = new LoginPage(driver);         //creating object passing constructor driver
	}

	@Test(priority = 1)
	public void verifyLoginPagTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), Constants.login_PAGE_title, "Login page title is mismatched...");
	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed....");
	}

	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

		@Test(priority = 4)
		public void ShowPasswordTest() {
			Assert.assertTrue(loginPage.verifyShowPassword(), "show password link is not displayed ...");;
			System.out.println("show password displayed ");
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}







