package org.testclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseclass.BaseClass;

public class A extends BaseClass {
public static void main(String[] args) throws IOException {
	//readExcel(0,1);
	//public static String readExcel(int rowNum,int cellNum) throws IOException {
		File f=new File("C:\\Users\\NirmalKavi\\eclipse-workspace\\BaseClass\\Excel\\Exams list.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet mySheet=w.getSheet("Sample Datas");
		Row r = mySheet.getRow(1);
		Cell c = r.getCell(1);
		int cellType=c.getCellType();
		String value="";
		if (cellType==1) {
			value=c.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(c)) {
			Date d=c.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat("dd MMMM yyyy");
			value=s.format(d);
		}else {
				double dd=c.getNumericCellValue();
				long l=(long)dd;
				value=String.valueOf(l);
				}
	System.out.println(value);
	   }
}

