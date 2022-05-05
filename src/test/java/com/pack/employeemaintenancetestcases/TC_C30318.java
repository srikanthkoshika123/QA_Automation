package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.EmployeeMaintenance;
import com.pack.employeemaintenance.C30318;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C30318 extends TC_BaseClass {
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "RegularShedule")
	public void updateSchedulingTab(String url, String partnerCode, String loginas, String Password, String dbModel,
			String db, String dbName, String module, String empId, String starttime, String endtime, String day1,
			String day2, String emptycellDay, String starttime1, String endtime1, String rightDay, String editStart,
			String editEnd, String starttime2, String endtime2, String Wday1, String Wday2, String Wday3, String Wday4,
			String editDay, String starttime3, String endtime3, String deleteDay1, String deleteDay2, String starttime4,
			String endtime4, String pDay, String employeeType) throws Exception {
		TestCase_ID="30318";
		ScreenRecorderUtil.startRecord("UpdateSchedulingTab");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		C30318 scheduling = new C30318(driver);
		scheduling.setPartnerCode(partnerCode);
		scheduling.clickNext();
		logger.info("enter user name");
		scheduling.setUserName(loginas);
		logger.info("password entered");
		scheduling.setPassWord(Password);
		Thread.sleep(4000);
		scheduling.clickSignIn(dbModel);
		logger.info("signin clicked");
		scheduling.selectDataBase(db, dbName, module);
		EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
		employeemaintenance.clickUnifocus();
		employeemaintenance.getselect_List();
		scheduling.switchFrame();
		scheduling.selectEmployee(empId);
		scheduling.selectEmployeeType();
		scheduling.selectShiftTime(starttime, endtime);
		scheduling.selectCheckBoxs(day1, day2);
		scheduling.doubleClick(emptycellDay);
		scheduling.clickEmptyCell(starttime1, endtime1);
		scheduling.rightClick(rightDay);
		scheduling.clickAddShift(editStart, editEnd);
		scheduling.selectCheckBoxes(starttime2, endtime2, Wday1, Wday2, Wday3, Wday4);
		scheduling.clickDayShift(editDay);
		scheduling.clickEdit(starttime3, endtime3);
		scheduling.clickShiftDay(deleteDay1);
		scheduling.clickDeleteSelectedShifts();
		scheduling.clickDeleteShift(deleteDay2);
		scheduling.clickDelete();
		scheduling.clickDeleteAllShifts();
		scheduling.selectPermanent(starttime4, endtime4, pDay);
		scheduling.selectVariableType(employeeType);
		scheduling.EmployeeType();

	}

	@DataProvider(name = "RegularShedule")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/RegularSchedules.xlsx";

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
