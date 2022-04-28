package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C27428;
import com.pack.loginPages.C27509;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C27509 extends TC_BaseClass {
	@Test(dataProvider = "loginPage")

	public void setup(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27509";
		ScreenRecorderUtil.startRecord("setup");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27509 setup = new C27509(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setup.setPartnerCode(partnerCode);
		setup.clickNext();
		logger.info("enter user name");
		setup.setUserName(loginas);
		logger.info("password entered");
		setup.setPassWord(Password);
		Thread.sleep(4000);
		setup.clickSignIn(dbModel);
		logger.info("signin clicked");
		setup.selectDataBase(db, dbName, module);
		setup.clickUnifocus();
		setup.earningtypes();
		setup.flowpatterns();
		setup.flowplans();
		setup.forecaststructure();
		setup.market();
		setup.revenue();
		setup.interfaces();
		setup.labourstandarads();
		setup.labourstructure();
		setup.mobileconfig();
		setup.workrules();

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
