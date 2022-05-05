package com.pack.employeemaintenancetestcases;

import org.testng.annotations.Test;

import com.pack.employeemaintenance.EmployeeMaintenance;

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
