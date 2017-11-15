package com.framework.genericsUtils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshot {
	
	public static void getScreenshot(String name){
		TakesScreenshot ts=(TakesScreenshot) BaseTest.driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fs, new File("./screenshots/"+name+".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
