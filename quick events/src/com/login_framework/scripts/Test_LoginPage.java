package com.login_framework.scripts;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.genericsUtils.BaseTest;
import com.framework.genericsUtils.Excell;
import com.login_framework.pom.LoginPage;

@Listeners(com.framework.genericsUtils.TestngListener.class)
public class Test_LoginPage extends BaseTest {
	
	@Test(priority=1)
	public void header_footer_method(){
	LoginPage log1=new LoginPage(driver);
	log1.signup_login_page();
	log1.header();
	log1.footer();
	log1.body();	
	log1.links();
	}
	
	@Test(priority=2)
	public void enter_username(){
		LoginPage log2=new LoginPage(driver);
		log2.signup_login_page();
		log2.enter_un("kumaramit");
		log2.error_messages_password();
	}
	
	@Test(priority=3)
	public void enter_passowrd(){
		LoginPage log=new LoginPage(driver);
		log.signup_login_page();
		log.enter_pwd("@Sumit19");
		log.error_messages_usename();
	}
	
	@Test(priority=4)
	public void enter_username_password(){
		LoginPage log=new LoginPage(driver);
		log.signup_login_page();
		log.enter_un_pwd(" ", " ");
		log.error_message_user_password();
	}
	
	@Test(priority=5)
	public void login_method(){
		LoginPage log=new LoginPage(driver);
		log.signup_login_page();
		 //LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		//login.enter_un_pwd("dhanya","Qwinix123");
		 log.enter_un_pwd("kumaramit","@Sumit19");	
		 log.success_message();
	}
	
	@Test(priority=6)
	public void login_remember_me_method(){
		LoginPage log=new LoginPage(driver);
		log.signup_login_page();
		log.un_pwd_remember_me("kumaramit","@Sumit19");	
		log.success_message();
	}

	
	@Test(priority=7)
	public void excellLogin() throws EncryptedDocumentException, InvalidFormatException, IOException{
			String filepath="./exelfiles/Qucikevent_credentials.xls";
		    String un = Excell.getCellValue(filepath, "login_credentials", 2, 0);
		    String pwd = Excell.getCellValue(filepath, "login_credentials", 2, 1);
		    LoginPage log=new LoginPage(driver);
			log.signup_login_page();
			log.un_pwd_remember_me(un,pwd);	
			log.success_message();
	}
}
