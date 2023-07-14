package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.Wordutilities;
import CommonUtils.commonUtils;
import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.LoginPage;
import io.cucumber.core.options.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogintoLMS {
	
	public static Logger logger=LogManager.getLogger(LogintoLMS.class);
	
	
	@Given("^User need to load the LMSTEST environment$")
	public void user_need_to_load_the_LMSTEST_environment()  {
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String CurrentURL=DriverManager.getDriver().getCurrentUrl();
			String ExpectedURL="http://lmstest.pilship.com/opuscntr/SignOn.do";
			if(CurrentURL.equals(ExpectedURL)) {
			Wordutilities.getinstance().passcase("Page Loaded successfully");
			logger.info("User need to load the LMTEST environment"); 
			commonUtils.getinstance().takescreenshot("Loginpage", "pass");  
			}
		}	
		
		catch(Exception e){
			logger.error(e);
			Wordutilities.getinstance().failcase("FAILED: Invalid URL");
			commonUtils.getinstance().takescreenshot("Invalid URL", "fail");
			try {
				DriverManager.getDriver().quit();
			} catch (Exception e1) {
				logger.error(e1);
			}
			
		}
	}

	@When("^user enter the valid username and password$")
	public void user_enter_the_valid_username_and_password() {
		try {
			LoginPage.getinstance().enterUsername(constants.Username);
			LoginPage.getinstance().enterPassword(constants.Password);
			logger.info("user enter the valid username and password");
		
		}
		catch(Exception e) {
			logger.error(e);
			
		}
	}

	@When("^click on the login button$")
	public void click_on_the_login_button() {
		try {
		
			LoginPage.getinstance().clicklogin();
			logger.info("click on the login button");
			
		}
		catch(Exception e) {
			logger.error(e);
		
		}
	}

	@Then("^user should see the mainpage of the LMSTEST environment$")
	public void user_should_see_the_mainpage_of_the_LMSTEST_environment() {
		try {
		
			String Loginalert=DriverManager.getDriver().switchTo().alert().getText();
			Wordutilities.getinstance().failcase("Failed: "+ Loginalert);
			commonUtils.getinstance().takescreenshot("Login failed", "fail");
			DriverManager.getDriver().switchTo().alert().accept();
			DriverManager.getDriver().quit();
				
		}
		
		catch(Exception e) {
			//logger.error(e);
			Wordutilities.getinstance().passcase("Login Successful");
			commonUtils.getinstance().takescreenshot("mainpage", "pass");
			logger.info("user should see the mainpage of the LMSTEST environment");

			
			
		}
	}
}
