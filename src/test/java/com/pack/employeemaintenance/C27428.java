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
@SuppressWarnings("deprecation")
public class C27428 extends TC_BaseClass {
	WebDriver ldriver;

	public C27428(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@class='x-input-el x-form-field x-input-text']")
	WebElement partnerCode;
	@FindBy(xpath = "//span[@class='x-button-label']")
	WebElement next;
	@FindBy(xpath = "//div[@class='x-button x-button-no-icon x-button-primary-wide x-layout-box-item x-stretched']")
	WebElement signin;

	public void setPartnerCode(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement partnerCode = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@class='x-input-el x-form-field x-input-text']")));
		partnerCode.sendKeys(pc);
	}

	public void clickNext() {
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement next = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='x-button-label']")));
		next.click();
	}

	public void setUserName(String uname) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement txtName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Login ID']")));
		txtName.sendKeys(uname);
	}

	public void setPassWord(String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		password.sendKeys(pwd);
		Assert.assertEquals(true, password.isEnabled());
		System.out.println(password.isEnabled());
	}

	public void clickSignIn(String dbModel) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement signin = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='x-button x-button-no-icon x-button-primary-wide x-layout-box-item x-stretched']")));
		signin.click();
		System.out.println("signin clicked");
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement rms = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+dbModel+"']")));
		rms.click();

	}
	public void selectDataBase(String db,String dbName,String module) {
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[text()='"+db+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement doral = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space()='"+dbName+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 240);
		WebElement ok = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait4 = new WebDriverWait(driver, 120);
		WebElement rms = wait4
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+module+"']")));
		rms.click();
	}

}
