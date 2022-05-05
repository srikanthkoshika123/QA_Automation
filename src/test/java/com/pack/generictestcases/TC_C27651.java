package com.pack.generictestcases;

import com.pack.generictest.C27651;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27651 extends TC_BaseClass {
	@Test(dataProvider = "loginPage")

	public void setup(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27651";
		ScreenRecorderUtil.startRecord("setup");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27651 setUp6 = new C27651(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setUp6.setPartnerCode(partnerCode);
		setUp6.clickNext();
		logger.info("enter user name");
		setUp6.setUserName(loginas);
		logger.info("password entered");
		setUp6.setPassWord(Password);
		Thread.sleep(4000);
		setUp6.clickSignIn(dbModel);
		logger.info("signin clicked");
		setUp6.selectDataBase(db, dbName, module);
		setUp6.clickUnifocus();
		setUp6.BlackoutDates();
		setUp6.EarningCategories();
		setUp6.EmployeeEventDocumentTemplates();
		setUp6.Holidays();
		setUp6.HolidayTypes();
		setUp6.JobCategories();
		setUp6.PayGroups();
		setUp6.PayRateReasons();
		setUp6.PunchToEarningMapping();
		setUp6.TACodes();
		setUp6.TimeClocks();
	}

	@DataProvider(name = "loginPage")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/AutoLoginInfoCase.xlsx";

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
