package com.qa.HubsPot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.HubspotUtility.ElementUtility;

public class LoginPage extends BasePage {

	
	WebDriver driver;
	ElementUtility elementutil;
	
	//1. page object /object repo/ By Locators 
	
	By emailId = By.id("username");
	By password = By.id("password");
	By LoginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By showPassword = By.xpath("//button[@type='button']/span");
	
	
	//2. creating constructor of page class
	//2. constructor of page class:
		public LoginPage(WebDriver driver){
			this.driver = driver;
			//creating utility object by constructor level and passing driver
			 elementutil = new ElementUtility(driver);
			 elementutil.waitForTitlePresent(Constants.login_PAGE_title, 15);
			
		}
		
		//3. page actions / page methods:
		public String getPageTitle(){
			
			String title = elementutil.waitForTitlePresent(Constants.login_PAGE_title, 15);
			System.out.println("login page title is: "+ title);
			return title;
		}
		
		public boolean verifySignUpLink(){
			return elementutil.isElementDisplayed(signUpLink);
			
		}
		
		public boolean verifyShowPassword() {
			elementutil.waitForElementPresent(showPassword, 10);
			return elementutil.isElementDisplayed(showPassword);
			
		}
		
		//this is the page generic method thats why I'm trying to avoid to write the hard coded here just it will read from prop file 
		//later on i will ad this method will return home page 
		public HomePage doLogin(String username, String pwd) {
			
			System.out.println("credentials are : "+ username + " - "+ pwd);
			elementutil.doSendKeys(emailId, username);
			elementutil.doSendKeys(password, pwd);
			elementutil.doClick(LoginButton);
		    elementutil.waitForTitlePresent(Constants.HOME_PAGE_title, 15);
	
			return new HomePage(driver);
		}

	}
	
