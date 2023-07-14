package StepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.Wordutilities;
import CommonUtils.commonUtils;
import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.Booking_Documentation;
import Page_objects.Booking_Inquiry;
import Page_objects.LMSMainpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Booking_Inquiry_retrieve {

	private static final Logger logger= LogManager.getLogger(Booking_Inquiry_retrieve.class);

	@Given("Select the office code")
	public void select_the_office_code(){
		try {
					
			constants.Mainpage=commonUtils.getinstance().windowhandling();
			commonUtils.getinstance().dropdown(LMSMainpage.getinstance().getOfficecodedropdown(), "visibletext", constants.officecode);
			logger.info("Office code selected");
			Alert officecodealert=DriverManager.getDriver().switchTo().alert();
			officecodealert.accept();
			logger.info("Alert msg accepted");
		}
		catch(Exception e) {
			logger.error(e);
		}
	}

	@When("click on the Booking & Documentation under service management")
	public void click_on_the_booking_documentation_under_service_management() {

		try {
			
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			LMSMainpage.getinstance().getServicemanagement().click();
			logger.info("Service Management selected");

			WebDriverWait driverwait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
			WebElement BKGDOCbutton=driverwait.until(ExpectedConditions.elementToBeClickable(LMSMainpage.getinstance().getBookingandDocumentation()));
			BKGDOCbutton.click();

			//LMSMainpage.BookingandDocumentation.click();
			logger.info("Booking and Documentation selected");
		}
		catch(Exception e) {
			logger.error(e);
		}

	}

	@When("click the Booking Inquiry tab")
	public void click_the_booking_inquiry_tab_booking_booking_booking_inquiry() {	
		try {
			constants.Booking_Documentation_window=commonUtils.getinstance().windowhandling();
			DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(By.id("gnb_frame")));
			Booking_Documentation.getinstance().getBooking().click();
			Booking_Documentation.getinstance().getBooking_booking().click();
			Booking_Documentation.getinstance().getBookingInquiry().click();
		}
		catch(Exception e) {
			logger.error(e);
			//Assert.fail(e.getMessage());
		}

	}

	@Then("user should see the Booking Inquiry page")
	public void user_should_see_the_booking_inquiry_page() {
		try {
			constants.Booking_Inquiry_window=commonUtils.getinstance().windowhandling();
			WebElement frame=DriverManager.getDriver().findElement(By.id("t1frame"));
			DriverManager.getDriver().switchTo().frame(frame);
			
			logger.info("Booking Inquiry page loaded succesfully");
		}
		catch(Exception e) {
			logger.error(e);
		}
	}

	@Then("enter the booking number in BKG NO field and click retrieve")
	public void enter_the_booking_number_in_BKG_NO_field_and_click_retrieve() {
		try {

			Booking_Inquiry.getinstance().enterBKG_NO(constants.booking_number);
			Booking_Inquiry.getinstance().clickretrieve();
		}
		catch(Exception e) {
			logger.error(e);
		}
	}

	@Then("user should see the booking information")
	public void user_should_see_the_booking_information() {
		try {
			String Bookingalert=DriverManager.getDriver().switchTo().alert().getText();
			Wordutilities.getinstance().failcase("FAILED: " + Bookingalert);
			commonUtils.getinstance().takescreenshot("BookingrRetrieveFailed", "fail");
			DriverManager.getDriver().switchTo().alert().accept();
			logger.error("Bookingr Retrieve Failed");
			DriverManager.getDriver().quit();
			
		}
		catch(Exception e) {
	          String bkgno=DriverManager.getDriver().findElement(By.name("bkg_no")).getText();
			 Wordutilities.getinstance().passcase("Booking retrieved successfully");
			commonUtils.getinstance().takescreenshot("BookingrRetrieve", "pass");
			logger.info("Booking Retrieved");
		}
	}


}
