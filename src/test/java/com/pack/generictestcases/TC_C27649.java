package com.pack.generictestcases;

import com.pack.generictest.C27649;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27649 extends TC_BaseClass {
	@Test(dataProvider = "loginPage")

	public void setup4(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27649";
		ScreenRecorderUtil.startRecord("C27649");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27649 setUp4 = new C27649(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setUp4.setPartnerCode(partnerCode);
		setUp4.clickNext();
		logger.info("enter user name");
		setUp4.setUserName(loginas);
		logger.info("password entered");
		setUp4.setPassWord(Password);
		Thread.sleep(4000);
		setUp4.clickSignIn(dbModel);
		logger.info("signin clicked");
		setUp4.selectDataBase(db, dbName, module);
		setUp4.clickUnifocus();
		setUp4.accounts();
		setUp4.budgetDatasets();
		setUp4.financialPeriods();
		setUp4.kbiSets();
		setUp4.payRollMap();
		setUp4.systemDefinedDatasets();
		setUp4.userDefinedDatasets();
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
