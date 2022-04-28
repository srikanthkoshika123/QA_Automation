package com.pack.loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.testCases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C27647 extends TC_BaseClass {
	WebDriver ldriver;

	public C27647(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-active ant-tabs-tab']//div//i[@aria-label='icon: close']//*[name()='svg']")
	WebElement close;
	@FindBy(xpath = "//span[text()='Setup']")
	WebElement setup;
	@FindBy(xpath = "//span[text()='Property']")
	WebElement property;
	@FindBy(xpath = "//li[text()='General']")
	WebElement general;
	@FindBy(xpath = "//li[text()='Property Budgeting']")
	WebElement propertybudgeting;
	@FindBy(xpath = "//li[text()='Labor/Scheduler']")
	WebElement laborscheduler;
	@FindBy(xpath = "//li[text()='Property Work Rules']")
	WebElement propertyworkrules;

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
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement unifocus = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement setup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);

		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement property = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Property']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", property);

	}

	public void general() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement general = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='General']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", general);

		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement gen = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='General']")));
		String genlabel = gen.getText();
		System.out.println(genlabel);
		Assert.assertEquals("General", genlabel);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement name = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@title='Name']")));
		String namelabel = name.getText();
		System.out.println(namelabel);
		Assert.assertEquals("Name", namelabel);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='General']")).getText());
	}

	public void propertybudgeting() {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement propertybudgeting = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Property Budgeting']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertybudgeting);

		driver.switchTo().frame(frame);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement pc = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Property Configuration']")));
		String propconfig = pc.getText();
		System.out.println(propconfig);
		Assert.assertEquals("Property Configuration", propconfig);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement dp = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='Decimal Precision']")));
		String decpre = dp.getText();
		System.out.println(decpre);
		Assert.assertEquals("Decimal Precision", decpre);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Property Budgeting']")).getText());

	}

	public void laborscheduler() {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement laborscheduler = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Labor/Scheduler']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", laborscheduler);

		driver.switchTo().frame(frame);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement sched = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Scheduling']")));
		String scheduling = sched.getText();
		System.out.println(scheduling);
		Assert.assertEquals("Scheduling", scheduling);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement stan = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='Standards']")));
		String standards = stan.getText();
		System.out.println(standards);
		Assert.assertEquals("Standards", standards);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Labor/Scheduler']")).getText());
	}

	public void propertyworkrules() {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement propertyworkrules = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Property Work Rules']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyworkrules);

		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement pwrl = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Property Work Rules']")));
		String pwrlabel = pwrl.getText();
		System.out.println(pwrlabel);
		Assert.assertEquals("Property Work Rules", pwrlabel);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement rt = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rule Type']")));
		String ruletype = rt.getText();
		System.out.println(ruletype);
		Assert.assertEquals("Rule Type", ruletype);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Property Work Rules']")).getText());
	}
}
