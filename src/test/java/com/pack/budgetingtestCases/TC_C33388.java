package com.pack.budgetingtestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.budgeting.C33388;
import com.pack.loginPages.C27428;
import com.pack.testCases.TC_BaseClass;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C33388 extends TC_BaseClass {
	@Test(dataProvider="loginPage")

	public void financial(String url, String partnerCode, String loginas, String Password,String dbModel,String db,String dbName,String module) throws Exception {
		ScreenRecorderUtil.startRecord("financial");
		TestCase_ID="33388";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		C33388 financial = new C33388(driver);
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
		financial.selectDataBase(db,dbName,module);
		financial.clickUnifocus();
		financial.budgeting();
		financial.periodDropDown();
		financial.referenceViewDropdown();
		financial.addConfigure();
		financial.Delete();
		financial.retryingFindClick();
		financial.AddNew();
		financial.selectReferenceDataSet();
		financial.DeletingAddNew();
		financial.ExpandingSideMenu();
		financial.BudgetConfiguration();
		financial.BudgetUtilities();

	}
	@DataProvider(name = "loginPage")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/pack/testData/BudgetingLoginInfo.xlsx";

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
