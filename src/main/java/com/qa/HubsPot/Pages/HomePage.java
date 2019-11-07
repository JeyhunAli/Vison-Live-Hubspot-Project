package com.qa.HubsPot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.HubspotUtility.ElementUtility;

public class HomePage extends BasePage{
	//init webdriver
	WebDriver driver; 
	ElementUtility elementUtil;


	//init pageobject or object repo
	By header = By.className("private-page__title");
	By accountName = By.cssSelector("a#account-menu>span");
	
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");

	//init constructor 
	public HomePage (WebDriver driver) {
		this.driver = driver;
	 elementUtil = new ElementUtility(driver);
	}


	public String getHomePageTitle() {
		String title = elementUtil.waitForTitlePresent(Constants.HOME_PAGE_title, 15);
		System.out.println("home page title is: "+title);
		return title;

	}

	public boolean isHeaderPresent() {
		return elementUtil.isElementDisplayed(header);
		
	}

	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	
	}
	
	public  boolean account_Name_Present() {
		return elementUtil.isElementDisplayed(accountName);

	}
	
	public String getAccount_Name_PresentValue () {
		return elementUtil.doGetText(accountName);
	}
	
	
	public void clickOnContacts() {
		elementUtil.waitForElementPresent(mainContactsLink, 15);
		elementUtil.doClick(mainContactsLink);
		
		elementUtil.waitForElementPresent(childContactsLink, 5);
		elementUtil.doClick(childContactsLink);
	}

	
	/**
	 * 
	 * @return here is returning new contacts page
	 * inside the gotoContactsPage I'm calling  clickonContacts method 
	 * then returning new contacts page
	 * method calling inside the method concept 
	 * 
	 * 
	 * 
	 * this calls page chaining model concept in selenium 
	 */
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
