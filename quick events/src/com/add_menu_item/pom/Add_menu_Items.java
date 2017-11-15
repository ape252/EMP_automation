package com.add_menu_item.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Add_menu_Items {
	WebDriver driver;
	//Add Menu Items
	@FindBy(xpath="//a[text()='Add menu item']")
	private WebElement add_menu_item;
	
	@FindBy(id="variant_food_main_category_id")
	private WebElement select_food_main_category;
	
	@FindBy(id="variant_cuisine")
	private WebElement cuisines_served;
	
	@FindBy(id="dishName")
	private WebElement dishname_food;
	
	@FindBy(xpath="(//select[@class='form-control col-sm-4'])[1]")
	private WebElement size_food;
	
	@FindBy(xpath="(//select[@class='form-control col-sm-4'])[2]")
	private WebElement dietary_option_food;
	
	@FindBy(id="unitPrice")
	private WebElement price_food;
	
	@FindBy(id="serveUpto")
	private WebElement serveupto_food;
	
	@FindBy(id="description")
	private WebElement description_food;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement add_food;
	
	@FindBy(xpath="//button[text()='Save and continue']")
	private WebElement save_and_continue_for_food;
	
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement reset_food;
	
	@FindBy(xpath="//div[@id='flash_notice']")
	public WebElement flash_notice;
	
	//Add toppings/ Addons
	
	@FindBy(xpath="//a[text()='Add toppings/ Addons']")
	private WebElement add_toppings;
	
	@FindBy(id="extra_item_extra_item_type_id")
	private WebElement choose_type;
	
	@FindBy(id="dishName")
	private WebElement dishname_toppings;
	
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	private WebElement addon_toppings_price;
	
	@FindBy(xpath="(//select[@class='form-control col-sm-4'])[2]")
	private WebElement addon_toppings_size;
	
	@FindBy(xpath="(//select[@class='form-control col-sm-4'])[3]")
	private WebElement dietary_option_toppings;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement add_addon_toppings;
	
	@FindBy(xpath="//button[text()='Save and continue']")
	private WebElement save_and_continue_addon_toppings;
	
	public Add_menu_Items(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods for Add Menu Items
	
	public void add_Menu_Item(){
		add_menu_item.click();
	}
	
	public void select_Food_Main_Category(){
		Select select=new Select(select_food_main_category);
		select.selectByVisibleText("Pizza");
	}
	
	public void cuisines_Served(){
		
		Select select=new Select(cuisines_served);
		List<WebElement> options = select.getOptions();
		for(int i=0;i<options.size();i++){
			String value = options.get(i).getText();
			Reporter.log(value,true);
		}	
	}
	
	public void dishName_Food(){
		dishname_food.sendKeys("Paneer Delight");
	}
	
	public void food_Size(){
		Select select=new Select(size_food);
		select.selectByVisibleText("Medium");
	}
	
	public void food_Dietary_Option(){
		
	Select select=new Select(dietary_option_food);
	select.selectByVisibleText("Vegetarian");
	}
	
	public void food_Serveupto(){
		serveupto_food.sendKeys("3");
	}
	
	public void food_Price(){
		price_food.sendKeys("8");
	}
	
	public void food_Description(){
		description_food.sendKeys("Onion, Paneer, Tomato, Sweet Corn, Jalapeno ");
	}

	public void add_Food(){
		add_food.click();
	}
	
	public void flash_Message(){
		Reporter.log("menu",true);
		Assert.assertTrue(flash_notice.getText()=="Menu created", "Menu created Successfully");
		Reporter.log("menu created",true);
	}
	
	public void save_And_Continue_For_Food(){
		save_and_continue_for_food.click();
	}
	
	//Methods for Add Toppings
	
	public void Add_Toppings(){
		add_toppings.click();
	}
	
	public void choose_Types(){
		Select select=new Select(choose_type);
		select.selectByVisibleText("Toppings");
	}
	
	public void dish_Name_Toppings(){
		dishname_toppings.sendKeys("Green Olives");
	}
	
	public void addon_Toppings_Price(){
		addon_toppings_price.sendKeys("2");
	}
	
	public void addon_Toppings_Size(){
		Select select=new Select(addon_toppings_size);
		select.selectByVisibleText("Medium");
	}
	
	public void dietary_Option_Toppings(){
		Select select=new Select(dietary_option_toppings);
		select.selectByVisibleText("Glutan Free");
	}
	
	public void add_Addon_Toppings(){
		add_addon_toppings.click();
	}
	
	public void save_And_Continue_For_Toppings(){
		save_and_continue_addon_toppings.click();
	}
}
