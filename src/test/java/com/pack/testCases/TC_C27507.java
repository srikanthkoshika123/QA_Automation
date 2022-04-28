package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C27507;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C27507 extends TC_BaseClass{
	@SuppressWarnings("deprecation")
	@Test(dataProvider="loginPage")
	public void Reporter(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27507";
		ScreenRecorderUtil.startRecord("reporter");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27507 reports = new C27507(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		reports.setPartnerCode(partnerCode);
		reports.clickNext();
		logger.info("enter user name");
		reports.setUserName(loginas);
		logger.info("password entered");
		reports.setPassWord(Password);
		Thread.sleep(4000);
		reports.clickSignIn(dbModel);
		logger.info("signin clicked");
		reports.selectDataBase(db, dbName, module);
		reports.clickUnifocus();
		reports.selectFilter();
		reports.selectDataBase1();
		reports.searchOption();
		
}
	@DataProvider(name = "loginPage")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/Reporter.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String empdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}
		return empdata;

	}
}