package Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BL_Preview {
	
	private static BL_Preview BL_Preview_instance;
	
	public BL_Preview(){
		
	}
	
	public static BL_Preview getinstance() {
		if(BL_Preview_instance==null) {
			BL_Preview_instance=new BL_Preview();
		}
		return BL_Preview_instance;
	}
	
	@FindBy(id = "rdo_form_level1")
	private WebElement All_radio_button;
	
	@FindBy(id="btn_Print")
	private WebElement Print_button;
	
	@FindBy(id="btn_Email")
	private WebElement Email_button;
	
	@FindBy(id="email")
	public WebElement Email_textfield;
	
	@FindBy(id = "btn_send")
	private WebElement Email_send;
	
	public void click_charge_all() {
	  All_radio_button.click();
	}
	
	public void click_print() {
		  Print_button.click();
		}
	
	public void click_Email() {
		  Email_button.click();
		}
	
	public void enter_email_id(String email) {
		Email_textfield.sendKeys(email);
		}
	
	public void click_email_send() {
		Email_send.click();
		}
}
