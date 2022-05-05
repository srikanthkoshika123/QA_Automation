package com.pack.employeemaintenance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.employeemaintenancetestcases.TC_BaseClass;

public class EmployeeMaintenance extends TC_BaseClass {
	WebDriver ldriver;

	public EmployeeMaintenance(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//span[contains(text(),'Administration')]")
	WebElement adminstration;
	@FindBy(xpath = "//li[@title='Employee Maintenance']")
	WebElement employeeMaintenance;
	@FindBy(xpath = "//span[text()='Labor']")
	WebElement labor;
	@FindBy(xpath = "//li[@title='Scheduling']")
	WebElement scheduling;

	public void clickUnifocus() {
		unifocus.click();
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement adminstration = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Administration')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", adminstration);
		String sc = adminstration.getText();
		System.out.println(sc);
		Assert.assertEquals("Administration", sc);
	}

	public WebElement getselect_List() {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeMaintenance = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Employee Maintenance']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeMaintenance);
		return employeeMaintenance;
	}

}
