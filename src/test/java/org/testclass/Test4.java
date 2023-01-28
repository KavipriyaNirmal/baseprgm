package org.testclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Test4 extends BaseClass {
public static void screenshot(String name) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sc=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\NirmalKavi\\eclipse-workspace\\BaseClass\\Img\\"+name+".png");
	FileUtils.copyFile(sc,dest);
}
public static void main(String[] args) throws IOException {
	launchChromeBrowser();
	launchUrl("http://www.greenstechnologys.com/");
	screenshot("gt");
}
}
