package com.dashboard_framework.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dashboard_framework.pom.Dashboard_Page;
import com.framework.genericsUtils.BaseTest;
import com.framework.genericsUtils.CommonFunctionalities;
import com.framework.genericsUtils.Excell;
import com.login_framework.pom.LoginPage;

@Listeners(com.framework.genericsUtils.TestngListener.class)
public class Test_Dashbord_page extends BaseTest{
	
	@Test
	public void dashboard() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
			String filepath="./exelfiles/Qucikevent_credentials.xls";
		    String un = Excell.getCellValue(filepath, "login_credentials", 1, 0);
		    String pwd = Excell.getCellValue(filepath, "login_credentials", 1, 1);
		    LoginPage log=new LoginPage(driver);
			log.signup_login_page();
			log.un_pwd_remember_me(un,pwd);	
			
			Dashboard_Page dash=new Dashboard_Page(driver);
			
			//My orders 
			dash.select_branch_name_services("Qwinint", "Food");
			Thread.sleep(20000);
			dash.verify_New_Orders();
			Thread.sleep(2000);
			dash.verify_fullfilled();
			Thread.sleep(2000);
			dash.verify_cancel_orders();
			Thread.sleep(2000);
			dash.verify_Upcoming_Orders();
			Thread.sleep(2000);
			
			//My Tasks
			CommonFunctionalities common=new CommonFunctionalities(driver);
			common.notification_MyTask();
			common.dashBoard();
				
			//Messages
			common.notification_Message();
			common.dashBoard();
			
			//Manage Catalog
			common.myAccount();
			common.manage_catalog();
			common.dashBoard();
			
			//Manage Branch
			common.myAccount();
			common.manage_Branch();
			common.dashBoard();
			
			//Manage User
			common.myAccount();
			common.manage_user();
			common.dashBoard();
			
			//Order Calander
			common.myAccount();
			common.manage_Calendar();
			common.dashBoard();
			
			//Logout
			common.myAccount();
			common.logoutlink();
	}
}
