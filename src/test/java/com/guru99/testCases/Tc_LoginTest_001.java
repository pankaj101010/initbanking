package com.guru99.testCases;

import org.testng.annotations.Test;

import com.guru99.PageObjects.LoginPage;

import junit.framework.Assert;

public class Tc_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() {
		logger.info("Url opened");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("login test failed");
			captureScreenShot(driver);
		}

	}
}
