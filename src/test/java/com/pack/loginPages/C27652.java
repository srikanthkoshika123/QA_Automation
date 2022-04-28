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
public class C27652 extends TC_BaseClass {
	WebDriver ldriver;

	public C27652(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-active ant-tabs-tab']//div//i[@aria-label='icon: close']")
	WebElement close;

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
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement unifocus = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement setup = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);

		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement Corporate = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Corporate']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Corporate);
	}

	public void masterkbicode() {
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement mkc = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Master KBI Code']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mkc);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addbutton = addb.getText();
		System.out.println(addbutton);
		Assert.assertEquals("Add Row", addbutton);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement masterKBICode = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Master KBI Code']")));
		String masterkbicode = masterKBICode.getText();
		System.out.println(masterkbicode);
		Assert.assertEquals("Master KBI Code", masterkbicode);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement c = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code']")));
		String code = c.getText();
		System.out.println(code);
		Assert.assertEquals("Code", code);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Master KBI Code']")).getText());
	}

	public void masterlaborstructure() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement mls = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Master Labor Structure']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mls);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//button[@class='ant-btn ant-dropdown-trigger']")));
		String addbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add button is dispalyed");

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement masterLaborStructure = wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Master Labor Structure']")));
		String masterlabstru = masterLaborStructure.getText();
		System.out.println(masterlabstru);
		Assert.assertEquals("Master Labor Structure", masterlabstru);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement ddj = wait10.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Division / Department / Job']")));
		String divdepjob = ddj.getText();
		System.out.println(divdepjob);
		Assert.assertEquals("Division / Department / Job", divdepjob);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Master Labor Structure']")).getText());

	}

	public void brand() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement Brand = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Brand']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Brand);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement bl = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Brand']")));
		String brandlabel = bl.getText();
		System.out.println(brandlabel);
		Assert.assertEquals("Brand", brandlabel);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Brand']")).getText());
	}

	public void portfolio() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement Portfolio = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Portfolio']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Portfolio);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement pl = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Portfolio']")));
		String Portfoliolabel = pl.getText();
		System.out.println(Portfoliolabel);
		Assert.assertEquals("Portfolio", Portfoliolabel);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Portfolio']")).getText());
	}

	public void region() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement Region = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Region']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Region);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement rl = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Region']")));
		String Regionlabel = rl.getText();
		System.out.println(Regionlabel);
		Assert.assertEquals("Region", Regionlabel);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Region']")).getText());
	}

}
