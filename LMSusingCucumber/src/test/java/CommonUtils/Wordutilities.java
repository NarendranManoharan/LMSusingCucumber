package CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import Constants.constants;

public class Wordutilities {
	public static FileOutputStream word;
	public static XWPFDocument document;
	public static XWPFParagraph paragraph;
	public static XWPFRun run;
	public static XWPFRun pass;
	public static XWPFRun fail;
	
	
	
	private static Wordutilities wordutilitiesinstance=null;
	
	private Wordutilities(){
		
	}
	
	public static Wordutilities getinstance() {
		if(wordutilitiesinstance==null) {
			wordutilitiesinstance=new Wordutilities();
		}
		return wordutilitiesinstance;
	}
	
	
	
	public void CreatewordDocument() {
		try {
			File file=new File("D:\\AutomationResults");
			file.mkdirs();
			
			word=new FileOutputStream("D:\\AutomationResults\\OutputDocument"+System.currentTimeMillis()+".docx");
			document=new XWPFDocument();
			 paragraph=document.createParagraph();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public void wordtitle() {
		run=paragraph.createRun();
		run.setBold(true);
		run.setFontSize(18);
		run.setColor(constants.header);
		run.setUnderline(UnderlinePatterns.DOUBLE);
		run.setText("Automation Results");
		run.addBreak();
		run.addCarriageReturn();
		run.addCarriageReturn();
			
	}
	public void passcase(String text) {
	    pass = paragraph.createRun();
		pass.setText(text);
		pass.setColor(constants.passcase);
		pass.setBold(true);
		pass.setFontSize(16);
		pass.addCarriageReturn();
		pass.addCarriageReturn();
	}
public void failcase(String text) {
	    fail=paragraph.createRun();
		fail.setText(text);
		fail.setColor(constants.failcase);
		fail.setBold(true);
		fail.setFontSize(16);
		fail.addCarriageReturn();
		fail.addCarriageReturn();
	}
	
	/*public void attachscreenshot(FileInputStream picturedata, String filename) {
		try {
			run.addPicture(picturedata, XWPFDocument.PICTURE_TYPE_JPEG, filename, Units.toEMU(400), Units.toEMU(250));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
