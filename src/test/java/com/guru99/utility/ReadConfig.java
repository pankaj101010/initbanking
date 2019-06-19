package com.guru99.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
   
	Properties prop;
	public ReadConfig() {
		try {
			FileInputStream file = new FileInputStream("./Configurations/Config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	public String getUserName() {
		String name = prop.getProperty("username");
		return name;
	}
	public String getPassword() {
		String pass = prop.getProperty("password");
		return pass;
	}
	 
	public String getChromepath() {
		String chrome = prop.getProperty("chromepath");
		return chrome;
	}
	public String getFirepath() {
		String chrome = prop.getProperty("firefoxpath");
		return chrome;
	}
}
