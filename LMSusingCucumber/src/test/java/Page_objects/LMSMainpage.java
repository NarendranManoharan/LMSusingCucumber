package Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LMSMainpage {

	private static LMSMainpage lmsMainpageinstance;

	public LMSMainpage() {

	}

	public static LMSMainpage getinstance() {
		if(lmsMainpageinstance==null) {
			lmsMainpageinstance=new LMSMainpage();
		}
		return lmsMainpageinstance;

	}

	@FindBy(xpath = "//*[@name='s_usr_chg_ofc_cd']")
	private WebElement officecodedropdown;

	@FindBy(xpath = "//li[@class='gnb-svcMGMT']")
	private WebElement servicemanagement;

	@FindBy(xpath = "//a[@href='/opuscntr/opusMainTobe.do?parentPgmNo=ESM_BKG_M001']")
	private WebElement BookingandDocumentation;



	public WebElement getOfficecodedropdown() {
		return officecodedropdown; 
		}

		
		 public WebElement getServicemanagement(){ 
			 return servicemanagement;
		 }
		 

	public WebElement getBookingandDocumentation() { 
		return BookingandDocumentation;
		}






}
