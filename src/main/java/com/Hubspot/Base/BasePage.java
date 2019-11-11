package com.Hubspot.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	
		
	
	
	
		
//		public WebDriver driver;
//		public Properties prop;
//
//		public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
//		
//		public static synchronized WebDriver getDriver() {
//			return tldriver.get();
//		}
//		
		
		
	/**Jeyhun's note 
	 * this method is used to initialize the driver on the basis of the browserName
	 * 
	 * @param browserName
	 * @return driver 
	 */
	public WebDriver init_driver(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//tldriver.set(new ChromeDriver());
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			//tldriver.set(new FirefoxDriver());
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("safari")) {
			
		}
		else {
			System.out.println( browserName+"Browser Value is Wrong please pass the correct browser Name...");
			
		}
		
		
//		getDriver().manage().window().fullscreen();
//		getDriver().manage().deleteAllCookies();
//        getDriver().get(prop.getProperty("url"));
//		return getDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
		
		return driver;
			
	}
	
	/**
	 * this method is used to read all the properties from properties file 
	 * @return ---->> prop
	 */
	public Properties init_properties() {
		
		 prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("/Users/jey/eclipse-workspace/VisionLiveHubspotProject/src/main/java/com/qa/hubspotConfig/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("config file is missing please check it then correct it....");
			} catch (IOException e) {
				System.out.println("properties file couldn't be loaded ");
			e.printStackTrace();
		}
		return prop;
		//this return statement says give me the browser i will give you driver 
		
	}
	
	
//	public String getScreenshot() {
//		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
//		File destination = new File(path);
//		try {
//			FileUtils.copyFile(src, destination);
//		} catch (IOException e) {
//			System.out.println("Capture Failed " + e.getMessage());
//		}
//		return path;
//	}
//	
//	
//	
//	
	
	
	
	
	

}
