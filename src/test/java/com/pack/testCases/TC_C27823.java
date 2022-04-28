package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C27823;
import com.pack.loginPages.EmployeeMaintenance;
import com.pack.utils.XLUtils;
import com.pack.loginPages.C27428;

import recordingTests.ScreenRecorderUtil;

public class TC_C27823 extends TC_BaseClass {
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginPage")
	public void employeeFieldOverrides(String url, String partnerCode, String loginas, String Password, String dbModel,
			String db, String dbName, String module) throws Exception {
		TestCase_ID="27823";
		ScreenRecorderUtil.startRecord("EmployeeFieldOverrides");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27823 efo = new C27823(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		efo.setPartnerCode(partnerCode);
		efo.clickNext();
		logger.info("enter user name");
		efo.setUserName(loginas);
		logger.info("password entered");
		efo.setPassWord(Password);
		Thread.sleep(4000);
		efo.clickSignIn(dbModel);
		logger.info("signin clicked");
		efo.selectDataBase(db, dbName, module);
		efo.clickEmployeeFieldOverrides();
		efo.switchToFrame();
		efo.checkEmailAdderss();
		efo.checkTipped();
		efo.checkHoursAvaliable();
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