package com.pack.generictest;

import com.pack.employeemaintenancetestcases.TC_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings("deprecation")
public class C27507 extends TC_BaseClass {
	WebDriver ldriver;

	public C27507(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;

	public void setPartnerCode(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
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
		WebDriverWait wait = new WebDriverWait(driver, 180);
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
		WebElement rms = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + dbModel + "']")));
		rms.click();

	}

	public void selectDataBase(String db, String dbName, String module) {
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + db + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement doral = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + dbName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 240);
		WebElement ok = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait4 = new WebDriverWait(driver, 120);
		WebElement rms = wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + module + "']")));
		rms.click();
	}

	public void clickUnifocus() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement unifocus = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);

		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement reports = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Reports']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", reports);
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement reporter = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Reporter']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", reporter);
		driver.switchTo().frame(frame);
	}

	public void selectFilter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement filterBy = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Filter By Tags:']")));
		String filter = filterBy.getText();
		System.out.println(filter);
		Assert.assertEquals("Filter By Tags:", filter);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement otherReports = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Other Reports']")));
		String reports = otherReports.getText();
		System.out.println(reports);
		Assert.assertEquals("Other Reports", reports);
	}

	public void selectDataBase1() throws InterruptedException {
		driver.switchTo().defaultContent();
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='QA Mint Master']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement doral = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Annapolis']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 240);
		WebElement ok = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait4 = new WebDriverWait(driver, 120);
		WebElement rms = wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[normalize-space()='RMS Modern React Reporter']")));
		rms.click();
	}

	public void searchOption() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement filterBy = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Filter By ']")));
		String filter = filterBy.getText();
		System.out.println(filter);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement search = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		String reports = search.getText();
		System.out.println(reports);
	}

}
