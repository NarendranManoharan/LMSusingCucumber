package Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import StepDefinitions.BLpreview_save;

public class Booking_Inquiry {

	private static Booking_Inquiry booking_Inquiry_instance;

	public Booking_Inquiry() {

	}

	public static Booking_Inquiry getinstance() {
		if(booking_Inquiry_instance==null) {
			booking_Inquiry_instance=new Booking_Inquiry();
		}
		return booking_Inquiry_instance;
	}

	@FindBy(name = "bkg_no")
	private WebElement Bkg_no;

	@FindBy(id = "btn_t1retrieve")
	private WebElement Retrieve_button;
	
	@FindBy(id = "btn_BLPreview")
	private WebElement BL_Preview;

	/*
	 * public WebElement getBkg_no() { return Bkg_no; }
	 * 
	 * public WebElement getRetrieve_button() { return Retrieve_button; }
	 */
	
	public void enterBKG_NO(String bkgno) {
		Bkg_no.sendKeys(bkgno);
	}
	
	public void clickretrieve() {
		Retrieve_button.click();
	}
	
	public void click_BLpreview() {
		BL_Preview.click();
	}

	
}
