package com.pack.generictestcases;

import com.pack.generictest.C27647;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27647 extends TC_BaseClass {
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginPage")

	public void setup2(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27647";
		ScreenRecorderUtil.startRecord("setup2");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27647 setup2 = new C27647(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setup2.setPartnerCode(partnerCode);
		setup2.clickNext();
		logger.info("enter user name");
		setup2.setUserName(loginas);
		logger.info("password entered");
		setup2.setPassWord(Password);
		Thread.sleep(4000);
		setup2.clickSignIn(dbModel);
		logger.info("signin clicked");
		setup2.selectDataBase(db, dbName, module);
		setup2.clickUnifocus();
		setup2.general();
		setup2.laborscheduler();
		setup2.propertyworkrules();

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
