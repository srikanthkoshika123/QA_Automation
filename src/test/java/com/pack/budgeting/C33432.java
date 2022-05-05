package com.pack.budgeting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.employeemaintenancetestcases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C33432 extends TC_BaseClass {

	WebDriver ldriver;

	public C33432(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-active ant-tabs-tab']//div//i[@aria-label='icon: close']")
	WebElement close;
	@FindBy(xpath = "//span[text()='Financial']")
	WebElement financial;
	@FindBy(xpath = "//li[text()='Budgeting']")
	WebElement budgeting;

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
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[text()='"+db+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);*/
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

	public void clickUnifocus() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement unifocus = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement financial = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Financial']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", financial);
	}

	public void budgeting() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement budgeting = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Budgeting']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgeting);

		driver.switchTo().frame(frame);
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement wd = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@title='Working Dataset']")));
		String workingdataset = wd.getText();
		System.out.println(workingdataset);
		Assert.assertEquals("Working Dataset", workingdataset);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement perioddd = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@title='Period']")));
		String total = perioddd.getText();
		System.out.println(total);
		Assert.assertEquals("Period", total);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement refviewdd = wait10
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@title='Reference View']")));
		String refviewdropdown = refviewdd.getText();
		System.out.println(refviewdropdown);
		Assert.assertEquals("Reference View", refviewdropdown);

		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement o = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Occupancy']")));
		String occupancy = o.getText();
		System.out.println(occupancy);
		Assert.assertEquals("Occupancy", occupancy);

		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement adr = wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ADR']")));
		String ADR = adr.getText();
		System.out.println(ADR);
		Assert.assertEquals("ADR", ADR);

		WebDriverWait wait15 = new WebDriverWait(driver, 120);
		WebElement r = wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='REVPAR']")));
		String revpar = r.getText();
		System.out.println(revpar);
		Assert.assertEquals("REVPAR", revpar);

		// widget 2

		WebDriverWait wait16 = new WebDriverWait(driver, 120);
		WebElement tor = wait16
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Occupied Rooms']")));
		String totaloccromms = tor.getText();
		System.out.println(totaloccromms);
		Assert.assertEquals("Total Occupied Rooms", totaloccromms);

		WebDriverWait wait17 = new WebDriverWait(driver, 120);
		WebElement ar = wait17
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Available Rooms']")));
		String availablerooms = ar.getText();
		System.out.println(availablerooms);
		Assert.assertEquals("Available Rooms", availablerooms);

		WebDriverWait wait18 = new WebDriverWait(driver, 120);
		WebElement toor = wait18.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Total Occupied Rooms (Trend Line)']")));
		String totaloccurooms = toor.getText();
		System.out.println(totaloccurooms);
		Assert.assertEquals("Total Occupied Rooms (Trend Line)", totaloccurooms);

		WebDriverWait wait30 = new WebDriverWait(driver, 120);
		WebElement avr = wait30.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Available Rooms (Trend Line)']")));
		String availrooms = avr.getText();
		System.out.println(availrooms);
		Assert.assertEquals("Available Rooms (Trend Line)", availrooms);

		// widget 3

		WebDriverWait wait20 = new WebDriverWait(driver, 120);
		WebElement pqi = wait20.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Potential Quality Issue']")));
		String potentialqualityissue = pqi.getText();
		System.out.println(potentialqualityissue);
		Assert.assertEquals("Potential Quality Issue", potentialqualityissue);

		WebDriverWait wait301 = new WebDriverWait(driver, 120);
		WebElement mg = wait301
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Meeting Goals']")));
		String meetinggoals1 = mg.getText();
		System.out.println(meetinggoals1);
		Assert.assertEquals("Meeting Goals", meetinggoals1);

		WebDriverWait wait551 = new WebDriverWait(driver, 120);
		WebElement nmg = wait551
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Not meeting goals']")));
		String notmeetinggoals = nmg.getText();
		System.out.println(notmeetinggoals);
		Assert.assertEquals("Not meeting goals", notmeetinggoals);

		// widget 4
	}

	public void DefaultChartSetup() throws InterruptedException {
		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement expand = wait22
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-layout-sider-trigger']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expand);

		WebDriverWait wait23 = new WebDriverWait(driver, 120);
		WebElement budgetConfiguration = wait23.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Configuration']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgetConfiguration);

		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement charts = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Charts']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", charts);

		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement plusbutton = wait21.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='ant-table-row-expand-icon ant-table-row-collapsed'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusbutton);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement dropdown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selection-selected-value'])[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		Thread.sleep(5000);
		WebDriverWait wait30 = new WebDriverWait(driver, 120);
		WebElement addoredit = wait30.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Add/Edit Formulas'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addoredit);

		Thread.sleep(2000);
		WebDriverWait wait33 = new WebDriverWait(driver, 120);
		WebElement addnew = wait33
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add New']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addnew);

		WebDriverWait wait12 = new WebDriverWait(driver, 40);
		WebElement formulaName = wait12.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ant-input formula-name-input']")));
		formulaName.sendKeys("test budgetline formula");
		Thread.sleep(3000);
		WebDriverWait wait24 = new WebDriverWait(driver, 120);
		WebElement addlines = wait24
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Line(s)']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addlines);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement search = wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		search.sendKeys("room r");
		WebDriverWait wait26 = new WebDriverWait(driver, 120);
		WebElement roomrevenue = wait26.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ant-tree-checkbox-inner'])[2]")));
		roomrevenue.click();
		search.clear();
		search.sendKeys("retail r");
		WebDriverWait wait25 = new WebDriverWait(driver, 120);
		WebElement retailrevenue = wait25.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/ul[1]/li[4]/ul[1]/li[1]/span[2]/span[1]")));
		retailrevenue.click();

		search.clear();
		search.sendKeys("total");
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement totalfoodrevenue = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[2]/ul/li[5]/span[2]/span")));
		totalfoodrevenue.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement totalbeerrevenue = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[2]/ul/li[6]/span[2]/span")));
		totalbeerrevenue.click();
		WebDriverWait wait93 = new WebDriverWait(driver, 120);
		WebElement totalwinerevenue = wait93
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[2]/ul/li[7]/span[2]/span")));
		totalwinerevenue.click();

		WebDriverWait wait28 = new WebDriverWait(driver, 120);
		WebElement selectbutton = wait28
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Select'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton);

		WebDriverWait wait36 = new WebDriverWait(driver, 120);
		WebElement subtractbutton = wait36
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='−'])[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", subtractbutton);
		Thread.sleep(1000);
		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement multiplybutton = wait9
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='×'])[4]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", multiplybutton);
		Thread.sleep(1000);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement selectbutton1 = wait19
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton1);

		WebDriverWait wait39 = new WebDriverWait(driver, 120);
		WebElement savebutton = wait39
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebutton);

	}

	public void Choosebudgetline() throws InterruptedException {
		WebDriverWait wait36 = new WebDriverWait(driver, 120);
		WebElement dashboard = wait36
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Dashboard']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboard);
		Thread.sleep(3000);
		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement charts = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Charts']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", charts);
		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement plusbutton = wait21.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='ant-table-row-expand-icon ant-table-row-collapsed'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusbutton);

		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement dropdown = wait22.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selection-selected-value'])[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		Thread.sleep(3000);
		WebDriverWait wait23 = new WebDriverWait(driver, 120);
		WebElement choosebudgetline = wait23
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Choose Budget Line']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", choosebudgetline);
		/*
		 * Thread.sleep(12000); WebDriverWait wait28 = new WebDriverWait(driver, 120);
		 * WebElement expandplus =
		 * wait28.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html[1]/body[1]/div[11]/div[1]/div[2]/div[1]/div[2]/div[2]/section[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]/i[1]/*[name()='svg'][1]"
		 * ))); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();",expandplus);
		 * Thread.sleep(12000);
		 */
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		search.sendKeys("transient");
		Thread.sleep(2000);
		WebDriverWait wait39 = new WebDriverWait(driver, 120);
		WebElement expandplus1 = wait39.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='path' and contains(@d,'M328 544h1')]")));
		expandplus1.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement transientrevenue = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Transient Revenue']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", transientrevenue);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement selectbutton = wait8
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton);
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement savebutton = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebutton);

	}

	public void Delete() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement dropdown = wait22.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selection-selected-value'])[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		WebDriverWait wait30 = new WebDriverWait(driver, 120);
		WebElement addoredit1 = wait30.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Add/Edit Formulas'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addoredit1);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement dropdown1 = wait2.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='ant-select-selection__rendered'])[7]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown1);
		
		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement selectingformula = wait8.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='test budgetline formula'])[2]")));
		Coordinates cor = ((Locatable) selectingformula).getCoordinates();
		cor.inViewPort();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectingformula);

		WebDriverWait wait28 = new WebDriverWait(driver, 120);
		WebElement deletebutton = wait28.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='ant-btn delete ant-btn-icon-only']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletebutton);
		Thread.sleep(2000);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement confirm = wait19
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Confirm Delete?']")));
		String deleteconfirm = confirm.getText();
		System.out.println(deleteconfirm);
		Assert.assertEquals("Confirm Delete?", deleteconfirm);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement delete = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);
		WebDriverWait wait4 = new WebDriverWait(driver, 120);
		WebElement cancel = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn']//span[text()='Cancel']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancel);

	}

}
