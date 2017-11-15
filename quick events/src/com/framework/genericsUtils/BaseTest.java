package com.framework.genericsUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {

	public static WebDriver driver;
	@BeforeMethod
	//@BeforeTest
	
	public void openBrowser() {
		//driver=new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(caps);
		
		File file=new File("./propertiesfile/config.properties");
		FileInputStream fis=null;
		
		try{
			fis=new FileInputStream(file);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		Properties prop=new Properties();
		try{
			prop.load(fis);
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@AfterMethod
		//@AfterTest
	public void closeBrowser() throws InterruptedException{
		//Thread.sleep(3000);
		driver.close();
	}
}
