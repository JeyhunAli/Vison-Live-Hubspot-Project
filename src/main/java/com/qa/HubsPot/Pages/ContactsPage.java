package com.qa.HubsPot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Hubspot.Base.BasePage;
import com.HubspotUtility.Constants;
import com.HubspotUtility.ElementUtility;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementUtility elementUtil;

	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//div[text()='Create contact']");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtility(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 15);
	}

	/**
	 * here in this method for now I'm passing string and all the parameters which i need to create new Contacts 
	 * @param mail
	 * @param FN
	 * @param LN
	 * @param jobtitle
	 * @throws InterruptedException 
	 */
	public void createNewContact(String mail, String FN, String LN, String jobtitle) throws InterruptedException {
		Thread.sleep(5000);
		elementUtil.waitForElementPresent(createContactButton, 15);
		elementUtil.doActionsClick(createContactButton);
		
		elementUtil.waitForElementPresent(email, 15);
		elementUtil.doActionsSendKeys(email, mail);
		//elementUtil.doSendKeys(email, mail);

		elementUtil.waitForElementPresent(firstName, 5);
		elementUtil.doSendKeys(firstName, FN);

		elementUtil.waitForElementPresent(lastName, 5);
		elementUtil.doSendKeys(lastName, LN);

		elementUtil.waitForElementPresent(jobTitle, 5);
		//elementUtil.doSendKeys(jobTitle, jobtitle);
		elementUtil.doActionsSendKeys(jobTitle, jobtitle);

		elementUtil.waitForElementPresent(createContactFormButton, 5);
		//elementUtil.doClick(createContactFormButton);
		elementUtil.doActionsClick(createContactFormButton);
	}

}