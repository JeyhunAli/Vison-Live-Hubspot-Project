package com.HubspotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {

	WebDriver driver;

	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to get webElement By locator.
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("excpetion formed while creating webElement...");
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	
	
	public void doActionsClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception occurred while clicking on the webelement....");
			System.out.println(e.getMessage());

		}
	}
	
	
	
	public void doActionsSendKeys(By locator, String value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception occurred while passing value to the webelement....");
			System.out.println(e.getMessage());

		}
	}
	
	
	/**
	 * This method is used to click on element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("excpetion formed while clicking on webElement...");
			System.out.println(e.getMessage());

		}
	}

	public boolean isElementDisplayed(By locator) {
		try {
		getElement(locator).isDisplayed();
		return true;
		}
		catch(Exception e) {
			System.out.println("exception formed while checking if element is displayed");
			System.out.println(e.getMessage());
			return false;
					
		}
		
	}
	public String doGetText(By Locator) {
		try {
		
			return getElement(Locator).getText();
		}
		catch (Exception e) {
			System.out.println("exception formed while getting text of the element");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * This method is used to pass the values in a webelement
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occurred while passing value to the webelement....");
			System.out.println(e.getMessage());

		}
	}

}
