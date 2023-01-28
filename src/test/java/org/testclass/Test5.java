package org.testclass;

import org.baseclass.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test5 extends BaseClass{
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
public static void main(String[] args) {
	launchFirefoxBrowser();
	launchUrl("http://demo.automationtesting.in/Alerts.html");
	
	//button.click();
	//acceptAlert();
	//WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	//dismissAlert();
	WebElement alrt=driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
	alrt.click();
	WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-info']"));
	button.click();
	promptAlert("Kavipriya");
	
}
}
