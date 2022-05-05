package com.pack.employeemaintenancetestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.employeemaintenance.EmployeeMaintenance;
import com.pack.employeemaintenance.C32852;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_C32852 extends TC_BaseClass {
    @Test(dataProvider = "EmployeeAvailability")
    public void updateSchedulingTab(String url, String partnerCode, String loginas, String Password, String dbModel,
                                    String db, String dbName, String module, String empId, String starttime, String endtime, String day1, String day2, String emptycellDay, String starttime1, String endtime1, String rightDay, String editStart, String editEnd, String day3, String starttime2, String endtime2, String filterJob,String date, String empName, String empId1, String starttime3, String endtime3, String day5, String day6, String day7, String day8, String editDay, String starttime4, String endtime4, String deleteDay1, String deleteDay2) throws Exception {
        TestCase_ID = "32852";
        ScreenRecorderUtil.startRecord("EmployeeAvailability");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        C32852 availability = new C32852(driver);
        availability.setPartnerCode(partnerCode);
        availability.clickNext();
        logger.info("enter user name");
        availability.setUserName(loginas);
        logger.info("password entered");
        availability.setPassWord(Password);
        Thread.sleep(4000);
        availability.clickSignIn(dbModel);
        logger.info("signin clicked");
        availability.selectDataBase(db, dbName, module);
        EmployeeMaintenance employeemaintenance = new EmployeeMaintenance(driver);
        employeemaintenance.clickUnifocus();
        employeemaintenance.getselect_List();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        availability.switchFrame();
        availability.selectEmployee(empId);
        availability.selectEmployeeType();
        availability.selectShiftTime(starttime, endtime);
        availability.selectCheckBoxs(day1, day2);
        availability.doubleClick(emptycellDay);
        availability.clickEmptyCell(starttime1, endtime1);
        availability.rightClick(rightDay);
        availability.clickAddShift(editStart, editEnd);
        availability.doubleClick1(day3);
        availability.clickEmptyCell1(starttime2, endtime2);
        availability.clickUnifocus();
        availability.retryingFindClick();
        availability.selectDateRange(filterJob,date,empName);
        EmployeeMaintenance employeemaintenance1 = new EmployeeMaintenance(driver);
        employeemaintenance1.clickUnifocus();
        employeemaintenance1.getselect_List();
        availability.selectEmployee1(empId1);
        availability.selectCheckBoxs1(starttime3, endtime3, day5, day6, day7, day8);
        availability.clickDayShift(editDay);
        availability.clickEdit(starttime4, endtime4);
        availability.clickShiftDay(deleteDay1);
        availability.clickDeleteSelectedShifts();
        availability.clickDeleteShift(deleteDay2);
        availability.clickDelete();
        availability.clickDeleteAllShifts();
        availability.clickRefreshButton();
    }

    @DataProvider(name = "EmployeeAvailability")
    String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/pack/testData/EmployeeAvailability.xlsx";

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