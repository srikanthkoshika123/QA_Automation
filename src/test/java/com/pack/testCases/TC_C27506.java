package com.pack.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.loginPages.C27428;
import com.pack.loginPages.C27506;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;
@SuppressWarnings("deprecation")
public class TC_C27506 extends TC_BaseClass{
	
	@Test(dataProvider="loginPage")

	public void admin(String url, String partnerCode, String loginas, String Password,String dbModel,String db,String dbName,String module) throws Exception
	{
		TestCase_ID="27506";
		ScreenRecorderUtil.startRecord("admin");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C27506 adminstration=new C27506(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		adminstration.setPartnerCode(partnerCode);
		adminstration.clickNext();
		logger.info("enter user name");
		adminstration.setUserName(loginas);
		logger.info("password entered");
		adminstration.setPassWord(Password);
		Thread.sleep(4000);
		adminstration.clickSignIn(dbModel);
		logger.info("signin clicked");
		adminstration.selectDataBase(db,dbName,module);
		adminstration.clickUnifocus();
		adminstration.audit();
		adminstration.employeeMaintenance();
		adminstration.EditPayRates();
		adminstration.manageEmployeeBadges();
		adminstration.useradminstration();
		adminstration.manageGroup(); 
		adminstration.taskschedulersetup();
		adminstration.taskschedulerlog();
		adminstration.myProcesses();
		
	}
	@DataProvider(name = "loginPage")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/pack/testData/Reporter.xlsx";

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
