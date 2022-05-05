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
public class C27649 extends TC_BaseClass {
	WebDriver ldriver;

	public C27649(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-active ant-tabs-tab']//div//i[@aria-label='icon: close']")
	WebElement close;
	@FindBy(xpath = "//span[text()='Setup']")
	WebElement setup;
	@FindBy(xpath = "//*[@id='SETUP$Menu']/li[12]/div")
	WebElement financial;
	@FindBy(xpath = "//li[text()='Accounts']")
	WebElement accounts;
	@FindBy(xpath = "//li[text()='Budget Datasets']")
	WebElement budgetDatasets;
	@FindBy(xpath = "//li[text()='Financial Periods']")
	WebElement financialPeriods;
	@FindBy(xpath = "//li[text()='KBI Sets']")
	WebElement kbiSets;
	@FindBy(xpath = "//li[@title='Payroll JE Map']")
	WebElement payrollJEMap;
	@FindBy(xpath = "//li[text()='System Defined Datasets']")
	WebElement systemDefinedDatasets;
	@FindBy(xpath = "//li[text()='User Defined Datasets']")
	WebElement userDefinedDatasets;

	public void setPartnerCode(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement partnerCode = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@class='x-input-el x-form-field x-input-text']")));
		partnerCode.sendKeys(pc);
	}

	public void clickNext() {
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
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
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
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
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[text()='"+db+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement doral = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space()='"+dbName+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement ok = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait4 = new WebDriverWait(driver, 120);
		WebElement rms = wait4
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='"+module+"']")));
		rms.click();
	}
	public void clickUnifocus() {
		unifocus.click();
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement setup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement financial = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SETUP$Menu']/li[12]/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", financial);
	}

	public void accounts() {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement accounts = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Accounts']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", accounts);

		driver.switchTo().frame(frame);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement addButton = wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String button = addButton.getText();
		System.out.println(button);
		Assert.assertEquals("Add Row", button);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement code = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code']")));
		String value = code.getText();
		System.out.println(value);
		Assert.assertEquals("Code", value);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Accounts']")).getText());
	}

	public void budgetDatasets() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement budgetDatasets = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Budget Datasets']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgetDatasets);
		driver.switchTo().frame(frame);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement y = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Year']")));
		String year = y.getText();
		System.out.println(year);
		Assert.assertEquals("Year", year);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement l = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Locked']")));
		String locked = l.getText();
		System.out.println(locked);
		Assert.assertEquals("Locked", locked);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Budget Datasets']")).getText());
	}

	public void financialPeriods() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement financialPeriods = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Financial Periods']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", financialPeriods);
		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement y = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Years']")));
		String years = y.getText();
		System.out.println(years);
		Assert.assertEquals("Years", years);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement p = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Period']")));
		String period = p.getText();
		System.out.println(period);
		Assert.assertEquals("Period", period);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Financial Periods']")).getText());
	}

	public void kbiSets() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement kbiSets = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='KBI Sets']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", kbiSets);
		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement ks = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='KBI Sets']")));
		String kbisets = ks.getText();
		System.out.println(kbisets);
		Assert.assertEquals("KBI Sets", kbisets);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement kbis = wait10
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='KBI Set']")));
		String kbisidebar = kbis.getText();
		System.out.println(kbisidebar);
		Assert.assertEquals("KBI Set", kbisidebar);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement kbiaddb = wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn addKBISetButton']")));
		String addkbibutton = kbiaddb.getText();
		Assert.assertEquals(true, kbiaddb.isDisplayed());
		System.out.println("kbi add button is displayed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='KBI Sets']")).getText());
	}

	public void payRollMap() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement payrollJEMap = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Payroll JE Map']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", payrollJEMap);
		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement addb = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'uf-border-panel-middle')]//div[@class='uf-border-panel-top']//button[1]//*[name()='svg']")));
		String addbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add button is displayed");

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement kbis = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='columnheader']")));
		String kbiSideBar = kbis.getText();
		System.out.println(kbiSideBar);
		Assert.assertEquals("Payroll JE Map", kbiSideBar);

		WebDriverWait wait11 = new WebDriverWait(driver, 120);
		WebElement details = wait11
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
		String value = details.getText();
		System.out.println(value);
		Assert.assertEquals("Details", value);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Payroll JE Map']")).getText());
	}

	public void systemDefinedDatasets() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement systemDefinedDatasets = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='System Defined Datasets']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", systemDefinedDatasets);
		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement l = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Line']")));
		String line = l.getText();
		System.out.println(line);
		Assert.assertEquals("Line", line);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement tn = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Type Name']")));
		String typename = tn.getText();
		System.out.println(typename);
		Assert.assertEquals("Type Name", typename);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='System Defined Datasets']")).getText());
	}

	public void userDefinedDatasets() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement userDefinedDatasets = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='User Defined Datasets']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", userDefinedDatasets);
		driver.switchTo().frame(frame);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement l = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Line']")));
		String line = l.getText();
		System.out.println(line);
		Assert.assertEquals("Line", line);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement tn = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Type Name']")));
		String typename = tn.getText();
		System.out.println(typename);
		Assert.assertEquals("Type Name", typename);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='User Defined Datasets']")).getText());
	}

}
