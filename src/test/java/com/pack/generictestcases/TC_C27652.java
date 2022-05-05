package com.pack.generictestcases;

import com.pack.generictest.C27652;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27652 extends TC_BaseClass {
	@Test(dataProvider="loginPage")

	public void setup7(String url, String partnerCode, String loginas, String Password,String dbModel,String db,String dbName,String module) throws Exception {
		TestCase_ID="27652";
		ScreenRecorderUtil.startRecord("setup7");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27652 setUp7 = new C27652(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		setUp7.setPartnerCode(partnerCode);
		setUp7.clickNext();
		logger.info("enter user name");
		setUp7.setUserName(loginas);
		logger.info("password entered");
		setUp7.setPassWord(Password);
		Thread.sleep(4000);
		setUp7.clickSignIn(dbModel);
		logger.info("signin clicked");
		setUp7.selectDataBase(db,dbName,module);
		setUp7.clickUnifocus();
		setUp7.masterkbicode();
		setUp7.masterlaborstructure();
		setUp7.brand();
		setUp7.portfolio();
		setUp7.region();

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