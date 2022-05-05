package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.EmployeeMaintenance;
import com.pack.employeemaintenance.C28156;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C28156 extends TC_BaseClass {
	@Test(dataProvider = "StatusData")
	public void updateExistingEmployee(String url, String partnerCode, String loginas, String Password, String dbModel,
			String db, String dbName, String module, String empId, String address, String city, String state,
			String zipCode, String displayName, String effectiveDate) throws Exception {
		TestCase_ID="28156";
		ScreenRecorderUtil.startRecord("UpdateExistingEmployee");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C28156 updateEmp = new C28156(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		updateEmp.setPartnerCode(partnerCode);
		updateEmp.clickNext();
		logger.info("enter user name");
		updateEmp.setUserName(loginas);
		logger.info("password entered");
		updateEmp.setPassWord(Password);
		Thread.sleep(4000);
		updateEmp.clickSignIn(dbModel);
		logger.info("signin clicked");
		updateEmp.selectDataBase(db, dbName, module);
		EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
		employeemaintenance.clickUnifocus();
		employeemaintenance.getselect_List();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		C28156 updateEmp1 = new C28156(driver);
		updateEmp1.switchFrame();
		updateEmp1.UpdateEmployee(empId, address, city);
		updateEmp1.SelectZipCode(state, zipCode, displayName);
		updateEmp1.clickStatus(effectiveDate);
		updateEmp1.deleteStatus();

	}

	@DataProvider(name = "StatusData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/StatusEmployee.xlsx";

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
