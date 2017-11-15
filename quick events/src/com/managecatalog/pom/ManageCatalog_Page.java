package com.managecatalog.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ManageCatalog_Page {
	WebDriver driver;
	
	//Manage Catalog page
	@FindBy(xpath="//tr[1]/td[4]/span/a/img")
	private WebElement add_food_venue_link_for_detroit_branch;
	
	@FindBy(partialLinkText="Qwinint")
	private WebElement branchname;
	
	@FindBy(xpath="(//div[@class='table-headings'])[1]")
	private WebElement display_branchname_for_add_venue;
	
	@FindBy(xpath="(//div[@class='table-headings'])[2]")
	private WebElement display_branchname_for_add_food;
	
	@FindBy(xpath="//input[@value='add venue']")
	private WebElement add_venue;
	
	@FindBy(xpath="//button[contains(text(),'add food store')]")
	private WebElement add_food_store;
	
	@FindBy(xpath="//select[@name='filter']")
	private WebElement filter_by;
	
	@FindBy(id="tags")
	private WebElement search_branch_name_and_branch_title;
	
	@FindBy(partialLinkText="Clear Filter")
	private WebElement clearfilter;
	
	// Choose your service
	@FindBy(xpath="//tr[3]/td[4]/span/a/img")
	private WebElement add_food_venue_link_for_main_branch;
	
	@FindBy(id="chooseService")
	private WebElement choose_your_service;
	
	@FindBy(id="foodStoreName")
	private WebElement food_store_name;
	
	@FindBy(id="store_description")
	private WebElement store_description;
	
	@FindBy(xpath="//div[13]/ul/li[19]")
	private WebElement food_start_time;
	
	@FindBy(id="food_start_time")
	private WebElement start_time;
	
	@FindBy(xpath="//div[14]/ul/li[39]")
	private WebElement food_end_time;
	
	@FindBy(id="food_end_time")
	private WebElement end_time;
	
	@FindBy(xpath="//label[text()='Yes']")
	private WebElement deliver_yes_radiobutton;
	
	@FindBy(xpath="//label[text()='No']")
	private WebElement deliver_No_radiobutton;
	
	@FindBy(id="miles")
	private WebElement delivery_radius;
	
	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	private WebElement select_cuisine;
	
	@FindBy(xpath= "//label[text()=' American']")
	private WebElement american;
	
	@FindBy(xpath="//button[text()='Continue']")
   private WebElement continue_btn_food;
	
	@FindBy(id="venue_venue_resource_type_id")
	private WebElement venue_resource_type;
	
	@FindBy(id="venue_name")
	private WebElement venue_name;
	
	@FindBy(id="venue_description")
	private WebElement venue_description;
	
	@FindBy(xpath="//input[@class='btn btn-default save-btn']")
	private WebElement continue_button_venue;
	
	@FindBy(xpath="//a[text()='Back']")
	private WebElement back_button;
	
	public ManageCatalog_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Manage Catalog
	public void add_Food_Venue_Link_For_Detroit_Branch(){
		add_food_venue_link_for_detroit_branch.click();
		}
	
	public void branchName(){
		branchname.click();
	}
	
	public void display_Branchname_For_Add_Venue(){
		
		Reporter.log(display_branchname_for_add_venue.getText(),true);
	}
	
	public void display_Branchname_For_Add_Food(){
		
		Reporter.log(display_branchname_for_add_food.getText(),true);
	}

	public void add_Venue(){
		add_venue.click();
	}
	
	public void add_Food_Store(){
		add_food_store.click();
	}
	
	public void search_Branch_Name(String branch_name_or_branch_title){
		Select select=new Select(filter_by);
		select.selectByVisibleText("Branch Name");
		
		search_branch_name_and_branch_title.sendKeys(branch_name_or_branch_title);	
		search_branch_name_and_branch_title.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(branchname.getAttribute("value"), branch_name_or_branch_title);
		Reporter.log("Branch name search"+branchname.getText());
	}
	
	public void clearFilter(){
		clearfilter.click();
	}
	
	// Choose your service 
	public void choose_Your_Service(String item){
		Select select=new Select(choose_your_service);
		select.selectByVisibleText(item);	
	}
	
	public void food_Store_Name(){
		
		food_store_name.sendKeys("Busch's, Rochester Hills");
	}
	
	public void store_Description(){
		
		store_description.sendKeys("Busch's is the hometown local food market that blends the best of today's freshness and style with the traditional values");
	}
	
	public void food_Start_Time(){
		start_time.click();
		food_start_time.click();
	}
	
	public void food_End_Time(){
		end_time.click();
		food_end_time.click();
	}
	
	public void deliver_Yes(){
		if(deliver_yes_radiobutton.isSelected() == true){
			Reporter.log("By default enabled True",true);
		}
		else{
		deliver_yes_radiobutton.click();
		}
	}	
	
	
	public void delivery_Radius(){
		delivery_radius.click();
		delivery_radius.sendKeys("20");
	}
	
	public void select_Cuisine(){
		select_cuisine.click();
		american.click();
	}
	
	public void continue_Button_Food(){
		continue_btn_food.click();
	}
	
	public void venue_Resource_Type(){
		Select select=new Select(venue_resource_type);
		select.selectByVisibleText("Party Hall");
	}
	
	public void venue_Name(){
		venue_name.sendKeys("v2test");
	}
	
	public void venue_Description(){
		venue_description.sendKeys("A function hall, reception hall, or banquet hall is a room or building for the purpose of hosting a party, banquet, wedding or other reception, or other social event. ");
	}
	
	public void continue_Button_Venue(){
		
		continue_button_venue.click();
	}
	
	public void back_Button(){
		
		back_button.click();
	}
	
}
