package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.C27427;
import com.pack.employeemaintenance.EmployeeMaintenance;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C27427 extends TC_BaseClass {

	@Test(dataProvider = "AddEmpData")
	public void addNewEmployee(String url, String partnerCode, String loginas, String Password, String dbModel,
			String db, String dbName, String module, String eid, String display, String first, String middle,
			String last, String Email, String hire, String sen, String wc, String tip, String job, String jobName,
			String jdate, String jrank, String edate, String payType, String hourly, String wch, String ch,
			String annual, String se, String sar, String piece) throws Exception {
		TestCase_ID="27427";
		ScreenRecorderUtil.startRecord("C27427");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		C27427 emp = new C27427(driver);
		emp.setPartnerCode(partnerCode);
		emp.clickNext();
		logger.info("enter user name");
		emp.setUserName(loginas);
		logger.info("password entered");
		emp.setPassWord(Password);
		Thread.sleep(4000);
		emp.clickSignIn(dbModel);
		logger.info("signin clicked");
		emp.selectDataBase(db, dbName, module);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
		employeemaintenance.clickUnifocus();
		employeemaintenance.getselect_List();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		emp.switchFrame();
		emp.addNewemployee(eid, display, first, middle, last, Email, hire, sen);
		emp.selectWorkClass(wc);
		emp.selectTipped(tip);
		emp.selectJob(job, jobName, jdate, jrank);
		emp.selectEffectiveDate(edate);
		emp.selectpayType(payType, hourly, wch, ch, annual, se, sar, piece);
		emp.selectWorkingHours();
	}

	@DataProvider(name = "AddEmpData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/AddEmployee.xlsx";

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
