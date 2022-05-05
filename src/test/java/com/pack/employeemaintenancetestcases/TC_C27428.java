package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.C27428;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

@SuppressWarnings("deprecation")
public class TC_C27428 extends TC_BaseClass {
	@Test(dataProvider="loginPage")
	public void loginTest(String url, String partnerCode, String loginas, String Password,String dbModel,String db,String dbName,String module)
			throws Exception {
		TestCase_ID="27428";
		ScreenRecorderUtil.startRecord("loginPage");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27428 lp = new C27428(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lp.setPartnerCode(partnerCode);
		lp.clickNext();
		logger.info("enter user name");
		lp.setUserName(loginas);
		logger.info("password entered");
		lp.setPassWord(Password);
		Thread.sleep(4000);
		lp.clickSignIn(dbModel);
		logger.info("signin clicked");
		lp.selectDataBase(db,dbName,module);

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