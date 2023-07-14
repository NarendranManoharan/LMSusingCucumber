package StepDefinitions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.Excelutilities;
import CommonUtils.Wordutilities;
import CommonUtils.commonUtils;
import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.Booking_Inquiry;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;





public class CommonStepdefinitions {
	 
	private static String scenarioName=null;
	
	  public static String getScenarioName() {
		return scenarioName;
	}
	  

	private static Logger Logger=LogManager.getLogger(CommonStepdefinitions.class);
       
	@Before
	public void beforescenario(Scenario scenario) {

		    scenarioName=scenario.getName();
		    Logger.info("Initialize the common utilities");
		   
		  //  commonUtils.getinstance().loadproperties();
		    
		    Excelutilities excelutilities=new Excelutilities();
		    excelutilities.readexcel();
		    excelutilities.getdata_from_excel();
		    excelutilities.assinging_excel_values();
		    
		   
		    
		    if(DriverManager.getDriver()==null) {
			DriverManager.launchbrowser();
		    Logger.info("Browser launched");
		    DriverManager.getDriver().manage().window().maximize();
			 DriverManager.getDriver().navigate().to("D:\\testing\\Automation\\frontpage.html");
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(50000));
				wait.until(ExpectedConditions.alertIsPresent());
				DriverManager.getDriver().switchTo().alert().accept();
		    }
			commonUtils.getinstance().initWebelements();
		
	}
	
	@AfterStep
	public void takescreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
		final byte[] screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "errorscreen");
	}
	}
	
	@BeforeAll
	public static void beforeall() {
		
		 Wordutilities.getinstance().CreatewordDocument();
		 Wordutilities.getinstance().wordtitle();
		 
		 
		
	}

	
	@AfterAll
	public static void quitbrowser() {
		
		try {
			Wordutilities.document.write(Wordutilities.word);
			Wordutilities.document.close();
		} catch (Exception e) {
			Logger.error(e);
		}
		DriverManager.getDriver().quit();
		Logger.info("Quit the browser");
	}
	
	}

