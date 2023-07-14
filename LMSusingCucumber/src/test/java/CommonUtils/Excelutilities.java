package CommonUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import Constants.constants;

public class Excelutilities {
	
	
	
	
	
	 FileInputStream excel;
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 String data;
	 String key;
	 String value;
	 
	 LinkedHashMap<String, String> linkedhashmap=new LinkedHashMap<String, String>();
	 
	
	public void readexcel() {
		try {
	  excel=new FileInputStream("D:\\testing\\Automation\\InputDetails.xlsx");
	  workbook=new XSSFWorkbook(excel);
	  sheet=workbook.getSheetAt(0);
	  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void getdata_from_excel() {
		Iterator<Row> rowiterator=sheet.rowIterator();
		while(rowiterator.hasNext()) {
			Row row=rowiterator.next();
			Iterator<Cell> celliterator=row.iterator();
			int i=2;
			while(celliterator.hasNext()) {
				Cell cell=celliterator.next();
				
				if(i%2==0) {
				key=cell.getStringCellValue().toString().trim();
				}
				else {
					value=cell.getStringCellValue().toString().trim();
				}
				linkedhashmap.put(key, value);
				i++;
		}
	
		}
		
	}
	
	public void assinging_excel_values() {
		constants.URL=linkedhashmap.get("url");
		constants.BrowserName=linkedhashmap.get("Browsername");
		constants.Username=linkedhashmap.get("Username");
		constants.Password=linkedhashmap.get("password");
		constants.officecode=linkedhashmap.get("Office code");
		constants.booking_number=linkedhashmap.get("Booking no");
		constants.email_id=linkedhashmap.get("email");
		
	}
}
