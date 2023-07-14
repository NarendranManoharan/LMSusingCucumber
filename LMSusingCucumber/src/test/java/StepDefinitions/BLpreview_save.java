package StepDefinitions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import CommonUtils.Wordutilities;
import CommonUtils.commonUtils;
import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.BL_Preview;
import Page_objects.Booking_Inquiry;
import freemarker.template.utility.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BLpreview_save {
	public static  Robot robot;
            
	private static final Logger LOGGER=LogManager.getLogger(BLpreview_save.class);
	
	@Given("Click on the BL preview")
	public void click_on_the_bl_preview() {
		try {
		DriverManager.getDriver().switchTo().defaultContent();
		Booking_Inquiry.getinstance().click_BLpreview();
		LOGGER.info("B/L preview button clicked");
		}
		catch(Exception e){
			LOGGER.error(e);
		}
		
	}

	@When("user should see the BL print preview page")
	public void user_should_see_the_bl_print_preview_page() {
	     constants.BLPreviewwindow=commonUtils.getinstance().windowhandling();
	     DriverManager.getDriver().manage().window().maximize();
	}

	@When("click on the charge type as all")
	public void click_on_the_charge_type_as_all() {
		try {
		 BL_Preview.getinstance().click_charge_all();
		 LOGGER.info("selected the Charge type as all");
		 }
		catch(Exception e) {
			LOGGER.error(e);
		}
	
	}
	@Then("click on the print button")
	public void click_on_the_print_button() {
		try {
		BL_Preview.getinstance().click_print();
		LOGGER.info("Print button clicked");
		}
		catch(Exception e) {
			LOGGER.error(e);
		}
	
	}

	@Then("system should take the screenshot")
	public void system_should_take_the_screenshot(){
		try {
			Wordutilities.getinstance().passcase("B/L preview Load successfully");
			 Thread.sleep(7000);
			commonUtils.getinstance().takescreenshot("BLpreview", "pass");
		 LOGGER.info("BL screenshot taken and saved in local folder");
		 
		
		}
		catch(Exception e) {
			LOGGER.error(e);
		}
	
	}

	@Then("cancel the print page")
	public void cancel_the_print_page() {
		try {
			
			
		     robot = new Robot();
		     robot.delay(4000);
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     robot.delay(4000);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         LOGGER.info("Cancel the print window using robot class");
		}
		catch(Exception e) {
			LOGGER.error(e);
		}
	
	}


}
