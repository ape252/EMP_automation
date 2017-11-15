package com.login_framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(xpath="//li/a[text()='LOGIN']")
	private WebElement login;
	
	@FindBy(className="sign-up-login sp-login-head")
	private WebElement text_Service_Provider_Login;
	
	@FindBy(xpath="(//img)[2]")
	private WebElement headerImage;
	
	@FindBy(xpath="(//img)[3]")
	private WebElement bogyImage;
	
	@FindBy(xpath="(//img)[3]")
	private WebElement footerImage;
	
	@FindBy(xpath="//li/a[text()='SIGN UP']")
	private WebElement signUp_link;
	
	@FindBy(xpath="//li/a[text()='SIGN UP']")
	private WebElement login_link;
	
	@FindBy(id="spinputEmail3")
	private WebElement userName_text;
	
	@FindBy(id="spinputPassword3")
	private WebElement password_text;
	
	@FindBy(xpath="//div/a[text()='Forgot your password?']")
	private WebElement forgotPassword_link;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberme;
	
	@FindBy(id="button1")
	private WebElement submit;
	
	@FindBy(id="spinputEmail3-error")
	private WebElement enter_email_id;
	
	@FindBy(id="spinputPassword3-error")
	private WebElement enter_password;
	
	@FindBy(id="flash_notice")
	private WebElement success_message;
	
	public LoginPage(WebDriver driver) {     
		this.driver = driver; 
		//super();
		PageFactory.initElements(driver, this);
		}
	
	public void header(){
		//Assert.assertEquals(headerImage.isDisplayed(), true); 
		if(headerImage.isDisplayed()== true){
			Reporter.log("Header Logo is Pesent",true);
		}
		else{
			Reporter.log("Header Logo is not present",true);
		}
	}
	
	public void footer(){
		if(footerImage.isDisplayed() == true){
			Reporter.log("footer Logo is Pesent",true);
		}
		else{
			Reporter.log("footer Logo is not present",true);
		}
	}
	
	public void body(){
		if(bogyImage.isDisplayed() == true){
			Reporter.log("Body Logo is Pesent",true);
		}
		else{
			Reporter.log("Body Logo is not present",true);
		}
	}
	
	public void links(){
		if(login_link.isEnabled()){
			Reporter.log("login link Enable",true);
		}
		if(signUp_link.isEnabled()){
			Reporter.log("signUp link Enable",true);
		}
		if(forgotPassword_link.isEnabled()){
			Reporter.log("forgotPassword link Enable",true);
		}
		else{
			Reporter.log("disable");
		}
	}
	public void signup_login_page(){
		login.click();
	}
	
	public void enter_un(String un){
		userName_text.sendKeys(un);
		submit.click();
	}
	
	public void enter_pwd(String pwd){
		password_text.sendKeys(pwd);
		submit.click();
	}
	
	public void enter_un_pwd(String un,String pwd){
		userName_text.sendKeys(un);
		password_text.sendKeys(pwd);
		submit.click();
	}
	
	public void un_pwd_remember_me(String un,String pwd){
		userName_text.sendKeys(un);
		password_text.sendKeys(pwd);
		if(rememberme.isSelected()){
			Reporter.log("Selected",true);
		}
		else{
			rememberme.click();
		}
		submit.click();
	}
	public void error_messages_password(){
		Assert.assertEquals(enter_password.getText(),"Please enter Password");
		Reporter.log("Please enter Password",true);
	}
	
	public void error_messages_usename(){
		Assert.assertEquals(enter_email_id.getText(), "Please enter Email/User ID");
		Reporter.log("Please enter Email/User ID",true);
	}

	public void error_message_user_password(){
		Assert.assertTrue(enter_password.getText().contains("Please enter Password") && enter_email_id.getText().contains("Please enter Email/User ID"));
		Reporter.log("Please enter Email/User ID and Please enter Password",true);
	}
	
	public void success_message(){
		Assert.assertEquals(success_message.getText(), "Signed in successfully.");
		Reporter.log("Signed in successfully.",true);
	}

	public void read_Excell_File(){
		userName_text.sendKeys();
		password_text.sendKeys();
		submit.click();
	}
}
