package com.guru99.utility;

import org.testng.annotations.DataProvider;

public class DataProviderData {
 @DataProvider(name="xlFileReading")
 public Object[][] fileReader(){
	 XssfReading config = new XssfReading("E:\\copy of workspace\\InitBanking\\src\\test\\java\\com\\guru99\\TestData\\UserNamePass.xlsx","Sheet1");
	 //return xl.fetchAllCellvalue();
	// return Object[][] = xl.getSheetDAta(sheetNumber, row, coloumn);
	

		int rows = config.rowCount();
     int coloumn = config.coloumnCount();
		Object[][] credentials = new Object[rows][coloumn];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < credentials[i].length; j++) {
				credentials[i][j] = config.getSheetDAta(0, i, j);
			}
		}
		return credentials;
 }
}
