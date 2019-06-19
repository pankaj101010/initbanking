package com.guru99.testCases;

import org.testng.annotations.Test;

import com.guru99.PageObjects.LoginPage;
import com.guru99.utility.DataProviderData;

import junit.framework.Assert;

public class Tc_LoginTestUsingxl extends BaseClass {
	@Test(dataProvider = "xlFileReading", dataProviderClass = DataProviderData.class)
	public void tc_01(String uname, String pass) {
		LoginPage page = new LoginPage(driver);
		page.setUserName(uname);
		page.setPassword(pass);
		page.clickSubmit();
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			page.logOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e) {
			return false;
		}

	}
}
