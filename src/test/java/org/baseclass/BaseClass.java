	package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	//===================BroWser Launch =====================
	public static void launchChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
	}
		
	public static void ieDriver() {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
	}
	public static void launchFirefoxBrowser() {
           WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
	}
	
	//===================Maximize Window================================
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	//=====================Launch URL=====================================
	public static void launchUrl(String url) {
        driver.get(url);
	}
	
	
	//==============GetTitle===================================
	public static void getTitle() {	
		String title = driver.getTitle();
		System.out.println("Title :"+title);
	}
	
	//===================CurrentUrl=====================================
	public static void getCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Url :"+url);
	}
	
	//================Click      Text         Attributes=========================
	public static void click(WebElement clk) {
	clk.click();
	}
	
	
	 public static void getText(WebElement txt) {
		String t = txt.getText();
		System.out.println(t);
	} 
	 
	 public static void getAttributes(WebElement txt) {
			String t = txt.getAttribute("value");
			System.out.println(t);
		} 
	 
	 
	
	//=========================JavaScript Executor==================
		public static void jEsendkeys(String word,WebElement WebE) {
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].setAttribute('value','"+word+"')",WebE);
	}
		
		public static void jEClick(WebElement WbE) {
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].click()",WbE);
			}	
		public static void jEGetAttributes(WebElement W) {
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].getAttribute('value')",W);
	}
		
		public static void jEScroll(WebElement We) {
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView('true')",We);
	}
		
	
		//========================Actions========================
		public static void mouseover(WebElement target) {
			Actions a=new Actions(driver);
		a.moveToElement(target);
		}
		
		public static void dragAndDrop(WebElement src,WebElement des) {
			Actions a=new Actions(driver);
			a.dragAndDrop(src, des).perform();
		}
		
		public static void doubleClick(WebElement txt) {
			Actions a=new Actions(driver);
			a.moveToElement(txt).doubleClick().perform();
		}
		
		public static void contextClick(WebElement txt) {
			Actions a=new Actions(driver);
			a.moveToElement(txt).contextClick().perform();
		}
			
		
		//==================WindoeHandle=========================
		public static void childwindow() {
			String parId=driver.getWindowHandle();
			System.out.println(parId);
			Set<String> allwin = driver.getWindowHandles();
			System.out.println(allwin);
			
			for (String i : allwin) {
				if (i!=parId) {
					driver.switchTo().window(i);
				}	
			   }
			}
		
		
		public static void parentWindow() {
			String parwin = driver.getWindowHandle();
			Set<String> allwin = driver.getWindowHandles();
			for (String i : allwin) {
					driver.switchTo().window(i);
				}	
			}
		
		//============================ScreenShot=======================================
		public static void screenshot(String name) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sc=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\NirmalKavi\\eclipse-workspace\\BaseClass\\Img\\"+name+".png");
			FileUtils.copyFile(sc,dest);
		}
		//=================Alert========================================================
		
		public static void acceptAlert() {
			Alert a=driver.switchTo().alert();
			a.accept();
		}
		public static void dismissAlert() {
			Alert a=driver.switchTo().alert();
			a.dismiss();
		}
		public static void promptAlert(String text) {
			Alert a=driver.switchTo().alert();
			String info=a.getText();
			System.out.println(info); 
			a.sendKeys(text);
			a.accept();
			
		}
		
		//===================================DropDown Select============================
		public static void dropDownSelectByIndex(int num,WebElement txt) {
			Select s=new Select(txt);
			s.selectByIndex(num);
		}
		
		public static void dropDownSelectByVisibleText(String  txt,WebElement webName) {
			Select s=new Select(webName);
			s.selectByVisibleText(txt);
		}
		
		public static void dropDownSelectByValue(String num,WebElement txt) {
			Select s=new Select(txt);
			s.selectByValue(num);
		}
		
		
		public static void dropDownGetOption(int num,WebElement txt) {
		Select s=new Select(txt);
		List<WebElement>allopt=s.getOptions();
		WebElement opt=allopt.get(num);
		System.out.println(opt.getText());
		for (WebElement itr : allopt) {
			System.out.println(itr.getText());
		}
		}
		
		
		public static void deselectdropDownSelectByIndex(int num,WebElement txt) {
			Select s=new Select(txt);
			s.deselectByIndex(num);
		}
		
		public static void dropdownDeselectAll(WebElement txt) {
			Select s=new Select(txt);
			s.deselectAll();
		}
		
		//===================Web Table==================================================
		public static void webTableGetAllText(WebElement table) {
		String text = table.getText();
		System.out.println(text);
		}
		public static void webTableGetParticularText(String txt,int num,WebElement table) {
		List<WebElement> row=table.findElements(By.tagName(txt));
		WebElement allrow = row.get(num);
		List<WebElement> partirow=allrow.findElements(By.tagName(txt));
		WebElement select = partirow.get(num);
		System.out.println(select.getText());
		}
		
		//============Frame===========================================================
		public static void gotoFrameWithName(String name) {
			driver.switchTo().frame(name);
		}
		public static void gotoFrameWithId(String Id) {
			driver.switchTo().frame(Id);
		}
		public static void gotoFrameWithIndex(String Index) {
			driver.switchTo().frame(Index);
		}
		public static void gotoFrameWithWebElement(String webElement) {
			driver.switchTo().frame(webElement);
		}
		public static void gotoParentFrame() {
			driver.switchTo().parentFrame();
		}
		public static void gotoDefaultPage() {
			driver.switchTo().defaultContent();
		}
		
		
		
		//==========================Quit==================================================
		public static void quit() {
		driver.quit();
		}
		public static void closeWind() {
			driver.close();;
			}
		
		//==============================ReadExcel=============================================
		public static String readExcel(int rowNum,int cellNum) throws IOException {
			File f=new File("C:\\Users\\NirmalKavi\\eclipse-workspace\\BaseClass\\Excel\\Exams list.xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fis);
			Sheet mySheet=w.getSheet("Sample Datas");
			Row r = mySheet.getRow(rowNum);
			Cell c = r.getCell(cellNum);
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
		return value;
		   }
		//==========================================================================================
		
}


