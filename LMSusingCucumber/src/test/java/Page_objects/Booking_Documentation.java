package Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Booking_Documentation {
	
	private static Booking_Documentation booking_Documentation_instance;
	
	public Booking_Documentation(){
		
	}
	
	public static Booking_Documentation getinstance() {
		if(booking_Documentation_instance==null) {
			booking_Documentation_instance=new Booking_Documentation();
		}
		return booking_Documentation_instance;
	}

	@FindBy(xpath = "//li[@pgmno='ESM_BKG_M019']")
	private WebElement Booking;
	
	@FindBy(xpath = "//li[@pgmno='ESM_BKG_M020']")
	private WebElement Booking_booking;
	
	@FindBy(xpath = "//li[@pgmno='ESM_BKG_0079_Q']")
	private WebElement BookingInquiry;

	public WebElement getBooking() {
		return Booking;
	}

	public WebElement getBooking_booking() {
		return Booking_booking;
	}

	public WebElement getBookingInquiry() {
		return BookingInquiry;
	}
	
	
	
}
