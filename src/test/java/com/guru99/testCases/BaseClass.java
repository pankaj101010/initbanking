package com.guru99.testCases;
//User ID :	mngr201583

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Password :	mAvApah

import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.guru99.utility.ReadConfig;
import com.mongodb.ReadConcern;

public class BaseClass {
	ReadConfig read = new ReadConfig();
	public String BaseUrl = read.getApplicationUrl();
	public String userName = read.getUserName();
	public String password = read.getPassword();
	public  WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String brName) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if (brName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromepath());
			driver = new ChromeDriver();
			System.out.println("Chrome lauched successfully");
		} else if (brName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFirepath());
			driver = new FirefoxDriver();
			System.out.println("firefox launched successfully");
		} else {
			System.err.println("Browser name not found");
		}
		driver.get(BaseUrl);;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver) {
		Date date = new Date();
		SimpleDateFormat Format = new SimpleDateFormat("E, dd MMM yyyy, HH_mm_ss");
		String DateFormat = Format.format(date);
		TakesScreenshot shot = (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File target = new File("E:\\copy of workspace\\InitBanking\\ScreenShots"+DateFormat+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
