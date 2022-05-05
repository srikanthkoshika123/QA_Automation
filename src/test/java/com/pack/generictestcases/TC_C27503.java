package com.pack.generictestcases;

import com.pack.generictest.C27503;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27503 extends TC_BaseClass {
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginPage")
	public void labor(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27503";
		ScreenRecorderUtil.startRecord("Labor");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27503 labor = new C27503(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		labor.setPartnerCode(partnerCode);
		labor.clickNext();
		logger.info("enter user name");
		labor.setUserName(loginas);
		logger.info("password entered");
		labor.setPassWord(Password);
		Thread.sleep(4000);
		labor.clickSignIn(dbModel);
		logger.info("signin clicked");
		labor.selectDataBase(db, dbName, module);
		labor.clickUnifocus();
    	labor.clickEnterActualEnvironments();
    	labor.clickEnterActualKBIs();
    	labor.clickEnterEmployeeProductivity();
    	labor.clickEnterActualHours();
    	labor.clickPlanning();
    	labor.retryingFindClick();
    	labor.clickForecastEnvironments();
    	labor.clickEnterPreWork();
    	labor.clickEnterInputKBIForecast();
    	labor.clickViewEditRoomsForecast();
    	labor.clickManageSchedules();
    	labor.clickEnterScheduledHours();
    	labor.clickReProjectLabor();
    	labor.clickScheduling();
    	labor.clickEmployeeRequests();
    	labor.clickShiftRequests();
    	labor.clickCallIns();
    	labor.clickAvailabilityRequests();
    	labor.clickTimeLineScheduling();

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
