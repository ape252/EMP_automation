package com.framework.genericsUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonFunctionalities {
	
	WebDriver driver;
	@FindBy(xpath="//span[@class='notification-counter']")
	private WebElement notification_Count;
	
	@FindBy(xpath="(//a[contains(text(),'My Tasks')])[1]")
	private WebElement notification_symbol_MyTasks;
	
	@FindBy(xpath="(//a[contains(text(),'Messages')])[1]")
	private WebElement notification_symbol_Message;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//ul/li[6]/a")
	private WebElement logout_Link;
	
//	@FindBy(xpath="//img[@alt='Manage Catalog icon']")
//	private WebElement manage_catalog_icon;
	
	@FindBy(partialLinkText="Manage Catalog")
	private WebElement manage_catalog_icon;
	
//	@FindBy(xpath="//img[@alt='Manage Branch icon']")
//	private WebElement manage_branch_icon;
	
	@FindBy(partialLinkText="Manage Branch")
	private WebElement manage_branch_icon;
	
//	@FindBy(xpath="(//img[@alt='Manage User icon'])[1]")
//	private WebElement manage_user_icon;
	
	@FindBy(partialLinkText="Manage User")
	private WebElement manage_user_icon;
	
	//@FindBy(xpath="(//img[@alt='Manage User icon'])[2]")
	//private WebElement orderCalendar;  
	
	@FindBy(partialLinkText="Order Calendar")
	private WebElement orderCalendar; 
	
	
	@FindBy(xpath="//img[@alt='Menu dashboard']")
	private WebElement dashboard;
	
	public CommonFunctionalities(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void notification_MyTask(){
		Actions actions=new Actions(driver);
		actions.moveToElement(notification_Count);
		actions.perform();
		notification_symbol_MyTasks.click();
		Reporter.log("Successfully redirecting to My Task page",true);
	}
	
	public void notification_Message_count(){
		 int count = Integer.parseInt(notification_Count.getText());
		 Reporter.log("count"+count,true);
		 String message = notification_symbol_Message.getText();
		 Reporter.log("count"+message,true);
//		 int task = Integer.parseInt(notification_symbol_MyTasks.getText());
//		 Reporter.log("count"+task,true);
//		 Assert.assertEquals(count, message+task);
//		 Reporter.log("Successfull"+count+"="+message+task,true);
	}
	
	public void notification_Message(){
		Actions actions=new Actions(driver);
		actions.moveToElement(notification_Count);
		actions.perform();
		notification_symbol_Message.click();
		Reporter.log("Successfully redirecting to Message page",true);
	}
	
	public void myAccount(){
		myAccount.click();
	}
	
	public void logoutlink(){
		logout_Link.click();
	}
	
	public void manage_catalog(){
		manage_catalog_icon.click();
		Reporter.log("Successfully redirecting to Manage Catalog",true);
		}
	
	public void manage_Branch(){
		manage_branch_icon.click();
		Reporter.log("Successfully redirecting to Manage Branch",true);
	}
	
	public void manage_user(){
		manage_user_icon.click();
		Reporter.log("Successfully redirecting to Manage User",true);
	} 
	
	public void manage_Calendar(){
		orderCalendar.click();
		Reporter.log("Successfully redirecting to Manage Calendar",true);
	}
	
	public void dashBoard(){
		
		dashboard.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("https://uat.qwik.events/service_providers/dashboard"));
	}
}

