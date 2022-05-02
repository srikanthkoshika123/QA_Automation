package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.pack.loginPages.C32968;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pack.loginPages.C33193;
import com.pack.loginPages.EmployeeMaintenance;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

@SuppressWarnings("deprecation")
public class TC_C33193 extends TC_BaseClass {

	@Test(dataProvider = "Certifications")

	public void certifications(String url, String partnerCode, String loginas, String Password, String dbModel,
							   String db, String dbName, String module,String empId, String autoCert1, String issuedate, String startdate,
			String expirationdate, String autoCert2, String autoCert3, String dates, String doubleclick,
			String starttime, String endtime, String jobName) throws Exception {
		TestCase_ID="33193";
		ScreenRecorderUtil.startRecord("C33193");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		C33193 certification = new C33193(driver);
		certification.setPartnerCode(partnerCode);
		certification.clickNext();
		logger.info("enter user name");
		certification.setUserName(loginas);
		logger.info("password entered");
		certification.setPassWord(Password);
		Thread.sleep(4000);
		certification.clickSignIn(dbModel);
		logger.info("signin clicked");
		certification.selectDataBase(db, dbName, module);
		EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
		employeemaintenance.clickUnifocus();
		employeemaintenance.getselect_List();
		certification.switchFrame();
		certification.selectEmployee(empId);
		certification.addJob();
		certification.selectAutoJob2();
		certification.selectAutoJob3();
		certification.selectCertifications();
		certification.clickDropDown(autoCert1);
		certification.selectIssueDate(issuedate, startdate);
		certification.clickAutocert1Ellipsis(expirationdate);
		certification.clickAutocert2(autoCert2);
		certification.clickAutocert2Ellipsis();
		certification.addAutocert2(autoCert3);
		certification.clickUnifocus();
		certification.retryingFindClick();
		certification.selectFilterJobButton();
		certification.selectAutoAssignmnt1(dates);
		certification.doubleClickEmptyCell(doubleclick);
		certification.selectStartTime(starttime, endtime, jobName);

	}

	@DataProvider(name = "Certifications")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/AddCertifications.xlsx";

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