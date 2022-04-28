package com.pack.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.pack.loginPages.EmployeeMaintenance;
import com.pack.loginPages.C27428;

import recordingTests.ScreenRecorderUtil;

public class TC_EmployeeMaintenace extends TC_BaseClass{
	 @Test
		public void employeeMaintenance() throws  Exception {
		 //ScreenRecorderUtil.startRecord("HomePage");
		 EmployeeMaintenance employeemaintenance=new EmployeeMaintenance(driver);
		 employeemaintenance.clickUnifocus();
		 employeemaintenance.getselect_List();
		 //employeemaintenance.selectScheduling();
		 

}
}
