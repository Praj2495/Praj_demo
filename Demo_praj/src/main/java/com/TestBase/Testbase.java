package com.TestBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void start() {
		logger=Logger.getLogger("Dalalstreet Framework");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Execution ended");
	}
	@AfterClass
	public void end() {
		logger.info("Execution ended");
	}
	@BeforeMethod
	public void setup() throws InterruptedException{
		String browser="Chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://apps.dalalstreet.ai/login\r\n");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		Thread.sleep(4000);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
