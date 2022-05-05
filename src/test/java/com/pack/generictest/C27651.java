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
public class C27651 extends TC_BaseClass {
	WebDriver ldriver;

	public C27651(WebDriver rdriver) {
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
	public void clickUnifocus() {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement unifocus = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);

		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement setup = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement ta = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SETUP$Menu']/li[14]/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ta);
	}

	public void BlackoutDates() {
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement bd = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Blackout Dates']")));
		bd.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement ycbutton = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div/div/div/button")));
		String yearcopybutton = ycbutton.getText();
		Assert.assertEquals(true, ycbutton.isDisplayed());
		System.out.println("year copy button is dispalyed");

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement dl = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
		String details = dl.getText();
		System.out.println(details);
		Assert.assertEquals("Details", details);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Blackout Dates']")).getText());
	}

	public void EarningCategories() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement ec = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Earning Categories']")));
		ec.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Earning Categories']")).getText());
	}

	public void EmployeeEventDocumentTemplates() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement eedt = wait7.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[text()='Employee Event Document Templates']")));
		eedt.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div/div/div/button[1]")));
		String addbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add button is dispalyed");

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement dl = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
		String details = dl.getText();
		System.out.println(details);
		Assert.assertEquals("Details", details);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee Event Document Templates']")).getText());
	}

	public void Holidays() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement h = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Holidays']")));
		h.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Holidays']")).getText());
	}

	public void HolidayTypes() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement ht = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Holiday Types']")));
		ht.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Holiday Types']")).getText());
	}

	public void JobCategories() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement jc = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Job Categories']")));
		jc.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Job Categories']")).getText());
	}

	public void PayGroups() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement pg = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SETUP_TA$Menu\"]/li[7]")));
		pg.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		WebDriverWait wait11 = new WebDriverWait(driver, 120);
		WebElement wdst = wait11
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Work Day Start Time']")));
		String workdaystarttime = wdst.getText();
		System.out.println(workdaystarttime);
		Assert.assertEquals("Work Day Start Time", workdaystarttime);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Pay Groups']")).getText());
	}

	public void PayRateReasons() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement prr = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pay Rate Reasons']")));
		prr.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addrow = addb.getText();
		System.out.println(addrow);
		Assert.assertEquals("Add Row", addrow);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement n = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Pay Rate Reasons']")).getText());
	}

	public void PunchToEarningMapping() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement ptem = wait7.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Punch To Earning Mapping']")));
		ptem.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement pt = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Punch Type']")));
		String punchtype = pt.getText();
		System.out.println(punchtype);
		Assert.assertEquals("Punch Type", punchtype);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement et = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Earning Type']")));
		String earningtype = et.getText();
		System.out.println(earningtype);
		Assert.assertEquals("Earning Type", earningtype);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement td = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/form/div[2]/div[2]/div/span/div/div/span")));
		String tipsdropdown = td.getText();
		Assert.assertEquals(true, td.isDisplayed());
		System.out.println("tips dropdown is dispalyed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Punch To Earning Mapping']")).getText());
	}

	public void TACodes() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement tacodes = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='T&A Codes']")));
		tacodes.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement pc = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Pay Code']")));
		String paycode = pc.getText();
		System.out.println(paycode);
		Assert.assertEquals("Pay Code", paycode);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement tkc = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='TK Code']")));
		String tkcode = tkc.getText();
		System.out.println(tkcode);
		Assert.assertEquals("TK Code", tkcode);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement f = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id='root']/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/div[1]/button")));
		String filter = f.getText();
		Assert.assertEquals(true, f.isDisplayed());
		System.out.println("filter dropdown is dispalyed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='T&A Codes']")).getText());
	}

	public void TimeClocks() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement tc = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Time Clocks']")));
		tc.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div/div/div/button[1]")));
		String addbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add button is dispalyed");

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement cn = wait10
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Clock Name']")));
		String clockname = cn.getText();
		System.out.println(clockname);
		Assert.assertEquals("Clock Name", clockname);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement dl = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Details']")));
		String details = dl.getText();
		System.out.println(details);
		Assert.assertEquals("Details", details);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Time Clocks']")).getText());
	}
}
