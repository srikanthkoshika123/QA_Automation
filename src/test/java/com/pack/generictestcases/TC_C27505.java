package com.pack.generictestcases;

import com.pack.generictest.C27505;
import com.pack.employeemaintenancetestcases.TC_BaseClass;
import com.pack.utils.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recordingTests.ScreenRecorderUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_C27505 extends TC_BaseClass {

	@SuppressWarnings("deprecation")
	@Test(dataProvider="loginPage")
	public void financial(String url, String partnerCode, String loginas, String Password, String dbModel, String db,
			String dbName, String module) throws Exception {
		TestCase_ID="27505";
		ScreenRecorderUtil.startRecord("financial");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27505 financial = new C27505(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		financial.setPartnerCode(partnerCode);
		financial.clickNext();
		logger.info("enter user name");
		financial.setUserName(loginas);
		logger.info("password entered");
		financial.setPassWord(Password);
		Thread.sleep(4000);
		financial.clickSignIn(dbModel);
		logger.info("signin clicked");
		financial.selectDataBase(db, dbName, module);
		financial.clickUnifocus();
		financial.ClickKbiProjections();
		financial.ClickAdjustHoursAndRtes();
		financial.ClickBudgetTree();
		financial.ClickBudgetConfiguration();
		financial.ClickBudgetUtilities();

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
