package com.managecatalog.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.framework.genericsUtils.BaseTest;
import com.framework.genericsUtils.CommonFunctionalities;
import com.framework.genericsUtils.Excell;
import com.login_framework.pom.LoginPage;
import com.managecatalog.pom.ManageCatalog_Page;

public class Test_ManageCatalog_Page extends BaseTest{

		@Test
		public void add_food_venue() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
			String filepath="./exelfiles/Qucikevent_credentials.xls";
		    String un = Excell.getCellValue(filepath, "login_credentials", 1, 0);
		    String pwd = Excell.getCellValue(filepath, "login_credentials", 1, 1);
		    LoginPage log=new LoginPage(driver);
			log.signup_login_page();
			log.un_pwd_remember_me(un,pwd);	
			
			CommonFunctionalities common=new CommonFunctionalities(driver);
			common.myAccount();
			common.manage_catalog();
			ManageCatalog_Page manage=new ManageCatalog_Page(driver);
			//manage.add_Food_Venue_Link_For_Detroit_Branch();
			manage.branchName();
			manage.display_Branchname_For_Add_Venue();
			manage.display_Branchname_For_Add_Food();
			
			manage.add_Venue();
			common.myAccount();
			common.manage_catalog();
			
			manage.branchName();
			manage.add_Food_Store();
			common.myAccount();
			common.manage_catalog();
			
			manage.search_Branch_Name("Qwinint");
			
			Thread.sleep(9000);
			//manage.clearFilter();
		}
	
}
