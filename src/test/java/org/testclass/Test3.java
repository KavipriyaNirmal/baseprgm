package org.testclass;

import java.util.Set;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3 extends BaseClass {
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
public static void main(String[] args) throws InterruptedException {
	launchChromeBrowser();
	launchUrl("http://www.greenstechnologys.com/python-training.html");
	WebElement srh=driver.findElement(By.xpath("(//h3[@id='Python-Solutions-Architect-Training'])[4]"));
jEClick(srh);
WebElement h=driver.findElement(By.xpath("//h3[text()='Selenium Day 10 Task']"));
jEClick(h);
WebElement q=driver.findElement(By.xpath("//button[text()='Windows Handling']"));
jEClick(q);
childwindow();
WebElement print=driver.findElement(By.xpath("//pre[contains(text(),child)]"));
String p = print.getText();
System.out.println(p);

}

}
