package com.add_menu_item.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.add_menu_item.pom.Add_menu_Items;
import com.framework.genericsUtils.BaseTest;
import com.framework.genericsUtils.CommonFunctionalities;
import com.framework.genericsUtils.Excell;
import com.login_framework.pom.LoginPage;
import com.managecatalog.pom.ManageCatalog_Page;

public class Test_Add_Menu_Items extends BaseTest {

	@Test
	public void add_Menu_Items() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		String filepath="./exelfiles/Qucikevent_credentials.xls";
	    String un = Excell.getCellValue(filepath, "login_credentials", 2, 0);
	    String pwd = Excell.getCellValue(filepath, "login_credentials", 2, 1);
	    LoginPage log=new LoginPage(driver);
		log.signup_login_page();
		log.un_pwd_remember_me(un,pwd);	
		
		// Choose Food Store Name
		CommonFunctionalities common=new CommonFunctionalities(driver);
		common.myAccount();
		common.manage_catalog();
		ManageCatalog_Page manage=new ManageCatalog_Page(driver);
		manage.add_Food_Venue_Link_For_Detroit_Branch();
		manage.choose_Your_Service("Food");
		manage.food_Store_Name();
		manage.store_Description();
		manage.food_Start_Time();
		manage.food_End_Time();
		manage.deliver_Yes();
		manage.select_Cuisine();
		manage.delivery_Radius();
		manage.continue_Button_Food();
		
		
		Add_menu_Items add_menu=new Add_menu_Items(driver);
		
		//Add Menu Items
		add_menu.add_Menu_Item();
		add_menu.select_Food_Main_Category();
		add_menu.cuisines_Served();
		Thread.sleep(1000);
		add_menu.dishName_Food();
		Thread.sleep(1000);
		add_menu.food_Size();
		Thread.sleep(1000);
		add_menu.food_Dietary_Option();
		Thread.sleep(1000);
		add_menu.food_Price();
		Thread.sleep(1000);
		add_menu.food_Serveupto();
		Thread.sleep(1000);
		add_menu.food_Description();
		Thread.sleep(1000);
		add_menu.save_And_Continue_For_Food();;
		
		//Add Topings
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Menu Item Successfully Added to your Catalog']"))));
		//Thread.sleep(3000);
		add_menu.Add_Toppings();
		add_menu.choose_Types();
		Thread.sleep(1000);
		add_menu.dish_Name_Toppings();
		Thread.sleep(1000);
		add_menu.addon_Toppings_Price();
		Thread.sleep(1000);
		add_menu.addon_Toppings_Size();
		Thread.sleep(1000);
		add_menu.dietary_Option_Toppings();
		Thread.sleep(1000);
		add_menu.save_And_Continue_For_Toppings();
		
	}
	
}
