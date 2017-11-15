package com.dashboard_framework.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class Dashboard_Page {
	WebDriver driver;
	@FindBy(xpath="//div/button[text()='×']")
	private WebElement success_message_close;
	
	@FindBy(id="branch_Ids")
	private WebElement branchName;
	
	@FindBy(id="service_type")
	private WebElement services;
	
	@FindBy(xpath="//div[text()='Fulfilled Orders']")
	private WebElement fulfilled_Orders;
	
	@FindBy(xpath=("(//div[@class='order-number'])[3]"))
	private WebElement fulfilled_Orders_count;
	
	@FindBy(xpath=("//tr/td[text()='fullfilled']"))
	private List<WebElement> status_fullfilled;
	
	@FindBy(xpath="//div[text()='Cancel Orders']")
	private WebElement cancel_Orders;
	
	@FindBy(xpath="(//div[@class='order-number'])[4]")
	private WebElement cancel_Orders_count;
	
	@FindBy(xpath="//td[text()='cancelled']")
	private List<WebElement> status_cancelled;
	
	@FindBy(xpath="//div[contains(text(),'Upcoming Orders')]")
	private WebElement upcoming_Orders;
	
	@FindBy(xpath="(//div[@class='order-number'])[2]")
	private WebElement upcoming_Orders_count;
	
	@FindBy(xpath="//td[text()='upcoming']")
	private List<WebElement> status_Upcoming;
	
	@FindBy(xpath="//div[text()='New Orders']")
	private WebElement new_Orders;
	
	@FindBy(xpath="(//div[@class='order-number'])[1]")
	private WebElement new_Orders_count;
	
	@FindBy(xpath="//td[text()='new']")
	private List<WebElement> status_New;
	
	public Dashboard_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void select_branch_name_services(String branchname,String service) throws InterruptedException{

		
		Select select=new Select(branchName);
		select.selectByVisibleText(branchname);
		Thread.sleep(3000);
		Select select1=new Select(services);
		select1.selectByVisibleText(service);
			
	}
		
	public void verify_fullfilled(){
		fulfilled_Orders.click();
		String text = fulfilled_Orders_count.getText();
		int count = Integer.parseInt(text);
		int size = status_fullfilled.size();
		Assert.assertTrue(count == size);
		Reporter.log("fulfilled Orders count is matching "+count+" = "+size,true);
		}
	
	public void verify_cancel_orders(){
		
		cancel_Orders.click();
		String text = cancel_Orders_count.getText();
		int count = Integer.parseInt(text);
		int size = status_cancelled.size();
		Assert.assertTrue(count==size);
		Reporter.log("cancel Orders count is matching "+count+" = "+size,true);
	}
	
	public void verify_Upcoming_Orders(){
		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+new_Orders.getLocation().x+")");
		upcoming_Orders.click();
		int count = Integer.parseInt(upcoming_Orders_count.getText());
		int size = status_Upcoming.size();
		Assert.assertTrue(count==size);
		Reporter.log("Upcoming Orders count is matching "+count+" = "+size,true);
	}
	
	public void verify_New_Orders(){
		
	    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+new_Orders.getLocation().x+")");
		new_Orders.click();
		String text = new_Orders_count.getText();
		int count = Integer.parseInt(text);
		int size = status_New.size();
		Assert.assertTrue(count==size);
		Reporter.log("New Orders count is matching "+count+" = "+size,true);
	}
	
	
	
	}

