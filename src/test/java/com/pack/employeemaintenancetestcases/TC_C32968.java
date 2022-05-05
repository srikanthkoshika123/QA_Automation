package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pack.employeemaintenance.C32968;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C32968 extends TC_BaseClass {
	@Test(dataProvider = "CertificationSetUp")
	public void Updatecertification(String url, String partnerCode, String loginas, String Password, String dbModel,
									String db, String dbName, String module,String certfi1, String cert2, String div1, String dep1, String autoJob1, String job,
			String autoJob2, String jobCode, String autojob2, String cert, String autoJob, String job1, String autoJob3,
			String jobCode1, String autojob3, String cert1) throws Exception {
		TestCase_ID="32968";
		ScreenRecorderUtil.startRecord("C32968");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		C32968 certification = new C32968(driver);
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
		certification.clickUnifocus();
		certification.clickAddRowButton();
		certification.clickAutocert1(certfi1);
		certification.clickAddRowButton1();
		certification.clickAutocert2(cert2);
		certification.clickLaborStructure();
		certification.selectPropertyDefault();
		certification.ExpandAutoJob(div1, dep1);
		certification.doubleClickAutoJob1(autoJob1);
		certification.clickAddJob();
		certification.doubleClickJob(job);
		certification.changeNameJob(autoJob2);
		certification.doubleClickJobCode(jobCode);
		certification.EditJobCode(autojob2);
		certification.doubleClickCertifiction(cert);
		certification.selectCheckBox();
		certification.doubleClickAutoJob(autoJob);
		certification.clickAddJob1();
		certification.doubleClickJob1(job1);
		certification.changeNameJob1(autoJob3);
		certification.doubleClickJobCode1(jobCode1);
		certification.EditJobCode1(autojob3);
		certification.doubleClickCertifiction1(cert1);
		certification.selectCheckBox1();
	}

	@DataProvider(name = "CertificationSetUp")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/Certifications.xlsx";

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
