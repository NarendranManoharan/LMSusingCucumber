package CommonUtils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import Constants.constants;
import DriverManager.DriverManager;
import Page_objects.Booking_Inquiry;
import Page_objects.BL_Preview;
import Page_objects.Booking_Documentation;
import Page_objects.LMSMainpage;
import Page_objects.LoginPage;
import StepDefinitions.BLpreview_save;
import StepDefinitions.CommonStepdefinitions;


public class commonUtils {

	static File destfile;
	static BufferedImage srcfile;
	static FileInputStream fis;
	static Robot robotforimage;
	static String image;

	private static final Logger LOGGER=LogManager.getLogger(commonUtils.getinstance());

	private static commonUtils commonUtilsinstance=null;

	private commonUtils() {

	}

	public static commonUtils getinstance(){

		if(commonUtilsinstance==null) {
			commonUtilsinstance=new commonUtils();
		}
		return commonUtilsinstance;
	}

	FileReader reader;

	/*	public void loadproperties() {

		/*
	 * try { reader=new FileReader("config.properties"); } catch(Exception e){
	 * System.out.println("File not found"); }
	 *
		Properties properties=new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}
		catch(Exception e) {
			System.out.println("Cant load the property file");
		}

		constants.BrowserName=properties.getProperty("Browser");
		constants.URL=properties.getProperty("URL");
		constants.Username=properties.getProperty("Username");
		constants.Password=properties.getProperty("Password");
		constants.officecode=properties.getProperty("officecode");

	}
	 */

	public void initWebelements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), LMSMainpage.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), Booking_Documentation.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), Booking_Inquiry.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), BL_Preview.getinstance());
	}

	public  String windowhandling() 
	{
		Set<String> windows1=DriverManager.getDriver().getWindowHandles(); 
		for (String x :  windows1){ 
			DriverManager.getDriver().switchTo().window(x); 
		}

		return DriverManager.getDriver().getWindowHandle();

	}

	public void takescreenshot(String name, String result) {

		try {
			robotforimage = new Robot();
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle=new Rectangle(screensize);
			BufferedImage srcfile=robotforimage.createScreenCapture(rectangle);
			destfile=new File("D:\\testing\\Automation\\screenshot\\"+ name +".jpg");
			ImageIO.write(srcfile, "jpg", destfile);
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		
		
		try {
			image=destfile.getName();
			fis = new FileInputStream(destfile);	
			if(result.equalsIgnoreCase("pass")) {
			Wordutilities.pass.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, image, Units.toEMU(400), Units.toEMU(250));
			Wordutilities.pass.addCarriageReturn();
			Wordutilities.pass.addCarriageReturn();
			}
			else {
				Wordutilities.fail.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, image, Units.toEMU(400), Units.toEMU(250));
				Wordutilities.fail.addCarriageReturn();
				Wordutilities.fail.addCarriageReturn();
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*public void highlighter(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("argument[0].setAttribute('style','border: 3px solid red');", element);
	}*/


	public void dropdown(WebElement element ,String selectedtype, String dropdownvalue) {
		Select dropdown=new Select(element);

		switch(selectedtype) {

		case "index":
			dropdown.selectByIndex(Integer.parseInt(dropdownvalue));
			break;

		case "value":
			dropdown.selectByValue(dropdownvalue);
			break;

		case "visibletext":
			dropdown.selectByVisibleText(dropdownvalue);
			break;

		default:
			LOGGER.error("Select the appropriate value");

		}
	}

	public void navigatetomainpage() {
		Set<String> totalwindows=DriverManager.getDriver().getWindowHandles();
		for (String currentwindow : totalwindows) {
			if(!constants.Mainpage.equals(currentwindow)) {
				DriverManager.getDriver().switchTo().window(currentwindow);
				DriverManager.getDriver().close();

			}

		}
	}

}
