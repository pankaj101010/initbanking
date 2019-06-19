package com.guru99.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement txtUserName;
	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	@FindBy(how = How.LINK_TEXT, using = "Log out")
	WebElement logout;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void clickSubmit() {
		btnLogin.click();
	}
	public void logOut() {
		logout.click();
	}
}
