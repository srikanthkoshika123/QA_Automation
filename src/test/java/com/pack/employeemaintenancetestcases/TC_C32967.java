package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.C32967;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C32967 extends TC_BaseClass {
    @Test(dataProvider = "LaborStructure")
    public void updateLaborStructure_Assignments(String url, String partnerCode, String loginas, String Password, String dbModel,
                                                 String db, String dbName, String module, String divisionName, String divisionCode, String expandDivision, String departmentName, String departmentCode, String expandDepartment, String jobName, String jobCode, String expandJob, String assignment1Name, String assignment1Code, String assignment2Name, String assignment2Code, String assignment3Name, String assignment3Code) throws Exception {
        TestCase_ID = "32967";
        ScreenRecorderUtil.startRecord("LaborStructure_Assignment");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        C32967 assignments = new C32967(driver);
        assignments.setPartnerCode(partnerCode);
        assignments.clickNext();
        logger.info("enter user name");
        assignments.setUserName(loginas);
        logger.info("password entered");
        assignments.setPassWord(Password);
        Thread.sleep(4000);
        assignments.clickSignIn(dbModel);
        logger.info("signin clicked");
        assignments.selectDataBase(db, dbName, module);
        assignments.clickUnifocus();
        assignments.switchFrame();
        assignments.selectPropertyDefault();
        assignments.clickAdd();
        assignments.doubleClick();
        assignments.changeNameDivision(divisionName);
        assignments.doubleClickCode();
        assignments.EditCode(divisionCode);
        assignments.clickAddDepatment(expandDivision);
        assignments.doubleClickDepatment();
        assignments.changeNameDepartment(departmentName);
        assignments.doubleClickDepartmentCode();
        assignments.EditDepartmentCode(departmentCode);
        assignments.clickAddJob(expandDepartment);
        assignments.doubleClickJob();
        assignments.changeNameJob(jobName);
        assignments.doubleClickJobCode();
        assignments.EditJobCode(jobCode);
        assignments.clickAddAssignment();
        assignments.expandJob(expandJob);
        assignments.doubleClickAssignment();
        assignments.changeNameAssignment(assignment1Name);
        assignments.doubleClickAssignmentCode();
        assignments.EditAssignmentCode(assignment1Code);
        assignments.doubleClickAutoJob1();
        assignments.clickExpandAutoJob1();
        assignments.doubleClickAssignment2();
        assignments.changeNameAssignment2(assignment2Name);
        assignments.doubleClickAssignment2Code();
        assignments.EditAssignmentCode2(assignment2Code);
        assignments.changeNameAssignment3(assignment3Name);
        assignments.doubleClickAssignmentCode3();
        assignments.EditAssignmentCode3(assignment3Code);
    }

    @DataProvider(name = "LaborStructure")
    String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/LaborStructure_Assignments.xlsx";

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
