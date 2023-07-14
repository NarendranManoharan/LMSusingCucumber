package Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static LoginPage loginpageInstance;
	
	public LoginPage() {
		
	}
	
	public static LoginPage getinstance() {
		
		if(loginpageInstance==null) {
		loginpageInstance=new LoginPage();
		}
		return loginpageInstance;
	}
	
	
	
	@FindBy(id = "j_username")
	private WebElement Username;
	
	@FindBy(id = "j_password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@onclick=\"submitFormClick();\"]")
	private WebElement Login_Button;

	/*
	 * public WebElement getUsername() { return Username; }
	 * 
	 * public WebElement getPassword() { return Password; }
	 * 
	 * public WebElement getLogin_Button() { return Login_Button; }
	 * 
	 */	
	
	public void enterUsername(String username) {
		Username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		Password.sendKeys(password);
	}
	public void clicklogin() {
		Login_Button.click();
	}
	
	
}
