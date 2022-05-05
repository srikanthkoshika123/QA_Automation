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
public class C27650 extends TC_BaseClass {
	WebDriver ldriver;

	public C27650(WebDriver rdriver) {
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
	@FindBy(xpath = "//*[@id='SETUP$Menu']/li[13]/div")
	WebElement labor;

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
		WebElement labor = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SETUP$Menu']/li[13]/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labor);
	}

	public void actualkbimapping() {
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement akm = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Actual KBI Mapping']")));
		akm.click();
		driver.switchTo().frame(frame);

		/*
		 * WebDriverWait wait8= new WebDriverWait(driver, 120); WebElement addb=
		 * wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		 * String addkbutton = addb.getText(); System.out.println(addkbutton);
		 * Assert.assertEquals("",addkbutton);
		 * 
		 * WebDriverWait wait9= new WebDriverWait(driver, 120); WebElement cname=
		 * wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		 * String certiname = cname.getText(); System.out.println(certiname);
		 * Assert.assertEquals("",certiname);
		 */
		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Actual KBI Mapping']")).getText());
	}

	public void calendarplans() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement cp = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Calendar Plans']")));
		cp.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement acb = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Calendar Plan']")));
		String addcalbutt = acb.getText();
		System.out.println(addcalbutt);
		Assert.assertEquals("Calendar Plan", addcalbutt);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Calendar Plans']")).getText());
	}

	public void dayoffrotationplans() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement dorp = wait7.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Day Off Rotation Plans']")));
		dorp.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement sdorp = wait8.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Select Day Off Rotation Plan']")));
		String sdayoffrp = sdorp.getText();
		System.out.println(sdayoffrp);
		Assert.assertEquals("Select Day Off Rotation Plan", sdayoffrp);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement adorp = wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Day Off Rotation Plans']")));
		String adddayoffrp = adorp.getText();
		System.out.println(adddayoffrp);
		Assert.assertEquals("Day Off Rotation Plans", adddayoffrp);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Day Off Rotation Plans']")).getText());
	}

	public void laborenvironments() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement le = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Labor Environments']")));
		le.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement adde = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Environment']")));
		String addenvi = adde.getText();
		System.out.println(addenvi);
		Assert.assertEquals("Add Environment", addenvi);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement n = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Labor Environments']")).getText());
	}

	public void forecastkbimapping() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement fkbim = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Forecast KBI Mapping']")));
		fkbim.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement cmt = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@title='Configured Mapping']")));
		String configmap = cmt.getText();
		System.out.println(configmap);
		Assert.assertEquals("Configured Mapping", configmap);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement k = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='KBI']")));
		String kbi = k.getText();
		System.out.println(kbi);
		Assert.assertEquals("KBI", kbi);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Forecast KBI Mapping']")).getText());
	}

	public void globalenvironments() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement ge = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Global Environments']")));
		ge.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addbutton = addb.getText();
		System.out.println(addbutton);
		Assert.assertEquals("Add Row", addbutton);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement n = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Global Environments']")).getText());
	}

	public void operatingcodes() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement oc = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Operating Codes']")));
		oc.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div/div[2]/button[1]")));
		String addopbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add operating button is displayed");

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement n = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Operating Codes']")).getText());
	}

	public void rotationplans() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement rp = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Rotation Plans']")));
		rp.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div/div/div/button[1]")));
		String addlrpbutton = addb.getText();
		Assert.assertEquals(true, addb.isDisplayed());
		System.out.println("add labor rotation plan button is displayed");

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement d = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
		String details = d.getText();
		System.out.println(details);
		Assert.assertEquals("Details", details);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Rotation Plans']")).getText());
	}

	public void seasons() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement Seasons = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Seasons']")));
		Seasons.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addsb = wait8.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn addSeasonButton']")));
		String addsbutton = addsb.getText();
		Assert.assertEquals(true, addsb.isDisplayed());
		System.out.println("add Seasons button is displayed");

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Seasons']")).getText());
	}

	public void shiftcategories() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement oc = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Shift Categories']")));
		oc.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addbutton = addb.getText();
		System.out.println(addbutton);
		Assert.assertEquals("Add Row", addbutton);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement n = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Shift Categories']")).getText());
	}

	public void shiftdefinitions() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement sd = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Shift Definitions']")));
		sd.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addbutton = addb.getText();
		System.out.println(addbutton);
		Assert.assertEquals("Add Row", addbutton);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement n = wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String name = n.getText();
		System.out.println(name);
		Assert.assertEquals("Name", name);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Shift Definitions']")).getText());
	}

	public void standardsets() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement sd = wait7
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Standard Sets']")));
		sd.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addsbutton = addb.getText();
		System.out.println(addsbutton);
		
		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement ss = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Standard Set']")));
		String standset = ss.getText();
		System.out.println(standset);
		Assert.assertEquals("Standard Set", standset);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Standard Sets']")).getText());
	}

	public void units() {
		clickUnifocus();
		WebDriverWait wait7 = new WebDriverWait(driver, 120);
		WebElement u = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Units']")));
		u.click();
		driver.switchTo().frame(frame);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement addb = wait8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
		String addbutton = addb.getText();
		System.out.println(addbutton);
		Assert.assertEquals("Add Row", addbutton);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement pn = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Plural Name']")));
		String pluname = pn.getText();
		System.out.println(pluname);
		Assert.assertEquals("Plural Name", pluname);

		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Units']")).getText());
	}
}
