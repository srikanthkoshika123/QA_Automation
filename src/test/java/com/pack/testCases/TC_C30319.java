package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C30319;
import com.pack.loginPages.EmployeeMaintenance;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C30319 extends TC_BaseClass {
	@Test(dataProvider = "Assignments")
	public void assignments(String eid, String display, String first, String middle, String last, String Email,
			String hire, String sen, String wc, String tip,String empId) throws Exception {
		TestCase_ID="30319";
		ScreenRecorderUtil.startRecord("Assignments");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
		employeemaintenance.clickUnifocus();
		employeemaintenance.getselect_List();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		C30319 assignment = new C30319(driver);
		assignment.switchFrame();
		assignment.addNewemployee(eid, display, first, middle, last, Email, hire, sen);
		assignment.selectWorkClass(wc);
		assignment.selectTipped(tip);
		assignment.selectJob();
		assignment.selectEmployee(empId);
		assignment.selectAddEmployeeAssignment();
		assignment.DeleteFilterBox();
		assignment.selectAutoAssignment1(); 
		assignment.selectAutoAssignment2();
		assignment.clickOkButton();
		assignment.selectAutoAssignment3();
		assignment. selectRankDropDown();
		//assignment.selectAutoAssignment();
		assignment.clickAssignment3();
		assignment.removeAssignment();
		assignment.clickUnifocus();
		assignment.retryingFindClick();
		assignment.selectFilterJobButton();
		assignment.selectAutoAssignmnt1();
		assignment.selectAutoAssignmnt2();
		assignment.selectAutoAssignmnt3();
		}

	@DataProvider(name = "Assignments")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/Assignments.xlsx";

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
