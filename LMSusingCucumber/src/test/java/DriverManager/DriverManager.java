package DriverManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.commonUtils;
import Constants.constants;
import StepDefinitions.CommonStepdefinitions;
import io.github.bonigarcia.wdm.WebDriverManager;

public  class DriverManager {
	
      static WebDriver driver;
      private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	
public static void launchbrowser() {
		
		
		switch(constants.BrowserName) 
		{
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			LOGGER.info("Initialize the chrome driver");
			driver=new ChromeDriver();
		break;
		
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			LOGGER.info("Initialize the Firefox driver");
		    driver=new FirefoxDriver();
         break;
         
		}
}

public static WebDriver getDriver() {
	return driver;
}


}
