package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C27428;
import com.pack.loginPages.C27648;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C27648 extends TC_BaseClass {
	@Test(dataProvider = "loginPage")

	public void setup3(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27648";
		ScreenRecorderUtil.startRecord("setup3");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27648 setup3 = new C27648(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setup3.setPartnerCode(partnerCode);
		setup3.clickNext();
		logger.info("enter user name");
		setup3.setUserName(loginas);
		logger.info("password entered");
		setup3.setPassWord(Password);
		Thread.sleep(4000);
		setup3.clickSignIn(dbModel);
		logger.info("signin clicked");
		setup3.selectDataBase(db, dbName, module);
		setup3.clickUnifocus();
		setup3.Certifications();
		setup3.EmployeeClasses();
		setup3.EmployeeFieldOverrides();
		setup3.EmployeeSets();
		setup3.employeeUserMaps();
		setup3.employeeWorkClasses();
		setup3.localTaxes();
		setup3.salaryDistributions();
		setup3.ScheduleGroups();
		setup3.states();
		setup3.statusChangeReasons();
		setup3.taxTypes();
		setup3.timeOffTypes();
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
