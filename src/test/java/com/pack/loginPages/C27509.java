package com.pack.loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.testCases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C27509 extends TC_BaseClass {
	WebDriver ldriver;

	public C27509(WebDriver rdriver) {
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
	@FindBy(xpath = "//li[@title='Earning Types']")
	WebElement earningtypes;
	@FindBy(xpath = "//li[@title='Flow Patterns']")
	WebElement flowpatterns;
	@FindBy(xpath = "//li[@title='Flow Plans']")
	WebElement flowplans;
	@FindBy(xpath = "//li[@title='Forecast Structure']")
	WebElement forecastst;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/*[name()='svg'][1]")
	WebElement market;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/span[1]/*[name()='svg'][1]")
	WebElement revenue;
	@FindBy(xpath = "//li[@title='Interfaces']")
	WebElement interfaces;
	@FindBy(xpath = "//li[@title='Labor Standards']")
	WebElement labourstandards;
	@FindBy(xpath = "//li[@title='Labor Structure']")
	WebElement labourstructure;
	@FindBy(xpath = "//li[@title='Mobile Configuration']")
	WebElement mobileconfig;
	@FindBy(xpath = "//li[@title='Work Rules']")
	WebElement workrules;

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
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement setup = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);
	}

	public void earningtypes() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement earningTypes = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Earning Types']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", earningTypes);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement details = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='Details']")));
		String de = details.getText();
		System.out.println(de);
		Assert.assertEquals("Details", de);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement type = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Type:']")));
		String td = type.getText();
		System.out.println(td);
		Assert.assertEquals("Type:", td);
		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Earning Types']")).getText());
	}

	public void flowpatterns() {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement flowpatterns = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Flow Patterns']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", flowpatterns);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement flowpattern = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Flow Pattern']")));
		String button = flowpattern.getText();
		System.out.println(button);
		Assert.assertEquals("Flow Pattern", button);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement per = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details - Percentage']")));
		String dp = per.getText();
		System.out.println(dp);
		Assert.assertEquals("Details - Percentage", dp);
		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Flow Patterns']")).getText());

	}

	public void flowplans() {
		clickUnifocus();

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement fp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Flow Plans']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fp);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement flowpattern = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Flow Plan']")));
		String button = flowpattern.getText();
		System.out.println(button);
		Assert.assertEquals("Flow Plan", button);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement per = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@role='columnheader'][normalize-space()='Flow Plan']")));
		String dp = per.getText();
		System.out.println(dp);
		Assert.assertEquals("Flow Plan", dp);
		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Flow Plans']")).getText());
	}

	public void forecaststructure() {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement foreCast = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Forecast Structure']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foreCast);
		
		driver.switchTo().frame(frame);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement k = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='KBIs']")));
		String kbis = k.getText();
		System.out.println(kbis);
		Assert.assertEquals("KBIs", kbis);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement add = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-btn-group']//button[1]")));
		String button = add.getText();
		Assert.assertEquals(true, add.isDisplayed());
		System.out.println("add button is displayed");

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement n = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);
	}

	public void market() throws InterruptedException {
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement market = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[1]/div/ul/li[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", market);
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement mg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Market Groups']")));
		String margr = mg.getText();
		System.out.println(margr);
		Assert.assertEquals("Market Groups", margr);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement add1 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-dropdown-trigger']")));
		String button1 = add1.getText();
		Assert.assertEquals(true, add1.isDisplayed());
		System.out.println("add1 dropdown is displayed");
	}

	public void revenue() {
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement revenue = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[1]/div/ul/li[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", revenue);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement re = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Revenue Centers']")));
		String revenueCenters = re.getText();
		System.out.println(revenueCenters);
		Assert.assertEquals("Revenue Centers", revenueCenters);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement adddrop = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-dropdown-trigger']")));
		String button2 = adddrop.getText();
		Assert.assertEquals(true, adddrop.isDisplayed());
		System.out.println("add1 dropdown is displayed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Forecast Structure']")).getText());
	}

	public void interfaces() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement interfaces = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@title='Interfaces']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", interfaces);

		driver.switchTo().frame(frame);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement infbu = wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addinterafce = infbu.getText();
		Assert.assertEquals(true, infbu.isDisplayed());
		System.out.println("addinterface is displayed");

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement in = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Interface Name']")));
		String interfacebar = in.getText();
		Assert.assertEquals(true, in.isDisplayed());
		System.out.println("interfacebar is displayed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Interfaces']")).getText());
	}

	public void labourstandarads() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement labourStandards = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@title='Labor Standards']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labourStandards);

		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement sl = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='Select Levels']")));
		String selectlevels = sl.getText();
		Assert.assertEquals(true, sl.isDisplayed());
		System.out.println("selectlevels is displayed");

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement ls1 = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Labor Structure']")));
		String labstr = ls1.getText();
		System.out.println(labstr);
		Assert.assertEquals("Labor Structure", labstr);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement ss = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Standard Set:']")));
		String sset = ss.getText();
		System.out.println(sset);
		Assert.assertEquals("Standard Set:", sset);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Labor Standards']")).getText());
	}

	public void labourstructure() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement labourStructure = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@title='Labor Structure']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labourStructure);

		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement add = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-dropdown-trigger']")));
		String adddropdown = add.getText();
		Assert.assertEquals(true, add.isDisplayed());
		System.out.println("adddropdown is displayed");

		/*
		 * WebDriverWait wait1 = new WebDriverWait(driver, 120); WebElement
		 * propertyDefault = wait1
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//span[text()='Property Default']"))); String property =
		 * propertyDefault.getText(); System.out.println(property);
		 * Assert.assertEquals("Property Default", property);
		 */

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Labor Structure']")).getText());

	}

	public void mobileconfig() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement mobileConfig = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@title='Mobile Configuration']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mobileConfig);

		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement sr = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Scheduling and Requests']")));
		String scheduling = sr.getText();
		System.out.println(scheduling);
		Assert.assertEquals("Scheduling and Requests", scheduling);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement reg = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Registration']")));
		String registr = reg.getText();
		System.out.println(registr);
		Assert.assertEquals("Registration", registr);

		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement i = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Invitation Expiration (days):']")));
		String invitation = i.getText();
		System.out.println(invitation);
		Assert.assertEquals("Invitation Expiration (days):", invitation);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Mobile Configuration']")).getText());

	}

	public void workrules() {
		clickUnifocus();
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement workRules = wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@title='Work Rules']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", workRules);

		driver.switchTo().frame(frame);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement td = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Type:']")));
		String type = td.getText();
		System.out.println(type);
		Assert.assertEquals("Type:", type);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement addrule = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Rule Item']")));
		String arbutton = addrule.getText();
		System.out.println(arbutton);
		Assert.assertEquals("Add Rule Item", arbutton);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Work Rules']")).getText());
	}
}
