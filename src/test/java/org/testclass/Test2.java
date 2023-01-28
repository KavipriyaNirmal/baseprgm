package org.testclass;

import java.awt.Desktop.Action;
import java.sql.Driver;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test2 extends BaseClass{
	public static WebDriver driver;
public static void mouseover(WebElement target) {
	Actions a=new Actions(driver);
a.moveToElement(target);
}
public static void dragAndDrop(WebElement src,WebElement des) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, des).perform();
}
public static void main(String[] args) {
	launchChromeBrowser();
	launchUrl("http://www.greenstechnologys.com/");
	WebElement course = driver.findElement(By.xpath("//a[text()='COURSES']"));
	mouseover(course);
	WebElement python = driver.findElement(By.xpath("(//span[text()='Python'])[1]"));
	jEClick(python);
}
}
