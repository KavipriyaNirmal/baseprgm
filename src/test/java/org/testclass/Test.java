package org.testclass;

	import java.sql.Driver;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Test {
		public static WebDriver driver;
		public static void jEsendkeys(String word,WebElement WebE) {
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].setAttribute('value','"+word+"')",WebE);
		}
			public static void jEClick(WebElement WbE) {
				JavascriptExecutor j=(JavascriptExecutor)driver;
				j.executeScript("arguments[0].click()",WbE);
	}
			public static void getTitle() {	
				String title = driver.getTitle();
				System.out.println("Title :"+title);
			}
			public static void getCurrentUrl() {
				String url = driver.getCurrentUrl();
				System.out.println("Url :"+url);

			}
			public static void quit() {
			driver.quit();
			}
			
		public static void main(String[] args) {
			 WebDriverManager.firefoxdriver().setup();
	         driver=new FirefoxDriver();
		     driver.get("https://www.facebook.com/");
		WebElement user = driver.findElement(By.id("email"));
		jEsendkeys("Kavipriya", user);
		WebElement psw = driver.findElement(By.id("pass"));
		jEsendkeys("Kavipriya", psw);
		WebElement lgn = driver.findElement(By.name("login"));
		jEClick(lgn);
		getTitle();
		getCurrentUrl();
		//quit();
		}
	}

