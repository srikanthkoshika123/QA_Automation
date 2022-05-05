package com.pack.generictestcases;

import com.pack.generictest.C27650;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27650 extends TC_BaseClass {
	@Test(dataProvider="loginPage")
	public void setup5(String url, String partnerCode, String loginas, String Password,String dbModel,String db,String dbName,String module) throws Exception {
		TestCase_ID="27650";
		ScreenRecorderUtil.startRecord("C27650");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27650 setUp5 = new C27650(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setUp5.setPartnerCode(partnerCode);
		setUp5.clickNext();
		logger.info("enter user name");
		setUp5.setUserName(loginas);
		logger.info("password entered");
		setUp5.setPassWord(Password);
		Thread.sleep(4000);
		setUp5.clickSignIn(dbModel);
		logger.info("signin clicked");
		setUp5.selectDataBase(db,dbName,module);
		setUp5.clickUnifocus();
		setUp5.actualkbimapping();
		setUp5.calendarplans();
		setUp5.dayoffrotationplans();
		setUp5.laborenvironments();
		setUp5.forecastkbimapping();
		setUp5.globalenvironments();
		setUp5.operatingcodes();
		setUp5.rotationplans();
		setUp5.seasons();
		setUp5.shiftcategories();
		setUp5.shiftdefinitions();
		setUp5.standardsets();
		setUp5.units();

	}
	@DataProvider(name = "loginPage")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/pack/testData/AutoLoginInfoCase.xlsx";

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
