package StepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;


import CommonUtils.Wordutilities;
import CommonUtils.commonUtils;
import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.BL_Preview;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class email_Send {

	private static final Logger LOGGER=LogManager.getLogger(email_Send.class);

	@Given("Click on the email button")
	public void click_on_the_email_button() {
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			BL_Preview.getinstance().click_Email();
			LOGGER.info("email button clicked");
		}
		catch(Exception e) {
			LOGGER.error(e);
		}


	}

	@When("enter the valid email id")
	public void enter_the_valid_email_id() {
		try {
			String emailwindow=commonUtils.getinstance().windowhandling();
			LOGGER.info("Control change to email window");
			DriverManager.getDriver().manage().window().maximize();
			BL_Preview.getinstance().Email_textfield.clear();
			LOGGER.info("Clear the email text field");
			BL_Preview.getinstance().enter_email_id(constants.email_id);
			LOGGER.info("email id entered");
		}
		catch(Exception e) {
			LOGGER.error(e);
		}


	}


	@When("click on the send button")
	public void click_on_the_send_button() {
		try {
			BL_Preview.getinstance().click_email_send();
			LOGGER.info("Email send button clicked");
			Thread.sleep(2000);


		}
		catch(Exception e) {
			LOGGER.error(e);
		}

	}

	@Then("accept the email sent alert")
	public void accept_the_email_sent_alert() {


		constants.Currentemailalert=DriverManager.getDriver().switchTo().alert().getText();
		constants.Expectedemailalert="E-mail was transmitted successfully.";

		if(constants.Currentemailalert.equals(constants.Expectedemailalert)) {
			Wordutilities.getinstance().passcase("Pass: "+constants.Currentemailalert);
			commonUtils.getinstance().takescreenshot("emailsent", "pass");
			Alert emailsentalert=DriverManager.getDriver().switchTo().alert();
			emailsentalert.accept();
			LOGGER.info("Email sent to the respective mail id");
			DriverManager.getDriver().switchTo().window(constants.BLPreviewwindow);
			commonUtils.getinstance().navigatetomainpage();
			LOGGER.info("navigated to mainpage");
		}

		else {
			Wordutilities.getinstance().failcase("FAILED: " + constants.Currentemailalert);
			commonUtils.getinstance().takescreenshot("emailnotsent", "fail");
			Alert emailnotesentalert=DriverManager.getDriver().switchTo().alert();
			emailnotesentalert.accept();
			LOGGER.error("Invlid email id entered");
			DriverManager.getDriver().switchTo().window(constants.BLPreviewwindow);
			commonUtils.getinstance().navigatetomainpage();
			LOGGER.info("navigated to mainpage");

		}

	}
}



