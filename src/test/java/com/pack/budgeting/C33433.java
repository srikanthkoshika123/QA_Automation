package com.pack.budgeting;

import java.util.List;

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
public class C33433 extends TC_BaseClass {
	WebDriver ldriver;

	public C33433(WebDriver rdriver) {
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
	public void clickUnifocus() {
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

	public void budgeting() {
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

	public void BudgetConfiguration() {
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

		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement header1 = wait19
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Budget Configuration']")));
		String budgetconfig = header1.getText();
		System.out.println(budgetconfig);
		Assert.assertEquals("Budget Configuration", budgetconfig);

		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement alert = wait14.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Configure charts per Top Level Line']")));
		String ccptll = alert.getText();
		System.out.println(ccptll);
		Assert.assertEquals("Configure charts per Top Level Line", ccptll);

		WebDriverWait wait15 = new WebDriverWait(driver, 120);
		WebElement header3 = wait15.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Configure charts per Top Level Line']")));
		String ccptll1 = header3.getText();
		System.out.println(ccptll1);
		Assert.assertEquals("Configure charts per Top Level Line", ccptll1);

		// printing table elements

		WebElement table = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/section/main/div/section/div/div/div/section/div/div[4]/div/div/div/div/div/div/div/table/tbody"));
		List<WebElement> e = table.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[2]"));
		int itemCount = e.size();

		for (int i = 0; i < itemCount; i++) {
			System.out.println(e.get(i).getText());
		}
	}

	public void DefaultChartSetup() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement plusbutton = wait21.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='ant-table-row-expand-icon ant-table-row-collapsed'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusbutton);

		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement cc1 = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Chart 1 Config']")));
		String chart1config = cc1.getText();
		System.out.println(chart1config);
		Assert.assertEquals("Chart 1 Config", chart1config);

		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement cc2 = wait14
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Chart 2 Config']")));
		String chart2config = cc2.getText();
		System.out.println(chart2config);
		Assert.assertEquals("Chart 2 Config", chart2config);

		WebDriverWait wait15 = new WebDriverWait(driver, 120);
		WebElement cc3 = wait15
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Chart 3 Config']")));
		String chart3config = cc3.getText();
		System.out.println(chart3config);
		Assert.assertEquals("Chart 3 Config", chart3config);

		WebDriverWait wait8 = new WebDriverWait(driver, 120);
		WebElement cn = wait8
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Chart Name'])[1]")));
		String chartname = cn.getText();
		System.out.println(chartname);
		Assert.assertEquals("Chart Name", chartname);

		WebDriverWait wait9 = new WebDriverWait(driver, 120);
		WebElement kbif = wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='KBI or Formula'])[1]")));
		String kbiformula = kbif.getText();
		System.out.println(kbiformula);
		Assert.assertEquals("KBI or Formula", kbiformula);

		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		WebElement kbif1 = wait10.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='KBI or Formula'])[1]")));
		String kbiorformula = kbif1.getText();
		System.out.println(kbiorformula);
		Assert.assertEquals("KBI or Formula", kbiorformula);

		WebDriverWait wait20 = new WebDriverWait(driver, 120);
		WebElement cdt = wait20.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Chart Display Type'])[1]")));
		String ChartDisplayType = cdt.getText();
		System.out.println(ChartDisplayType);
		Assert.assertEquals("Chart Display Type", ChartDisplayType);

		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement avg = wait22
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Average'])[1]")));
		String average = avg.getText();
		System.out.println(average);
		Assert.assertEquals("Average", average);
		WebDriverWait wait23 = new WebDriverWait(driver, 120);
		WebElement s = wait23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Spa']")));
		String spa = s.getText();
		System.out.println(spa);
		Assert.assertEquals("Spa", spa);
		WebDriverWait wait29 = new WebDriverWait(driver, 120);
		WebElement rbl = wait29
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Report Builder Lines']")));
		String reportlines = rbl.getText();
		System.out.println(reportlines);
		Assert.assertEquals("Report Builder Lines", reportlines);

	}

	public void AddAndEditFormula() throws InterruptedException {
		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement dropdown = wait21.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selection__rendered'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement ckbi = wait22
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Choose KBI']")));
		String choosekbi = ckbi.getText();
		System.out.println(choosekbi);
		Assert.assertEquals("Choose KBI", choosekbi);
		WebDriverWait wait29 = new WebDriverWait(driver, 120);
		WebElement aef = wait29
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Add/Edit Formulas']")));
		String addoredit = aef.getText();
		System.out.println(addoredit);
		Assert.assertEquals("Add/Edit Formulas", addoredit);
		WebDriverWait wait30 = new WebDriverWait(driver, 120);
		WebElement addoredit1 = wait30
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Add/Edit Formulas']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addoredit1);

		Thread.sleep(2000);
		WebDriverWait wait23 = new WebDriverWait(driver, 120);
		WebElement addnew = wait23
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add New']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addnew);
		Thread.sleep(5000);
		WebDriverWait wait12 = new WebDriverWait(driver, 40);
		WebElement formulaName = wait12.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ant-input formula-name-input']")));
		formulaName.sendKeys("test KBI formula1");
		Thread.sleep(3000);
		WebDriverWait wait24 = new WebDriverWait(driver, 120);
		WebElement addlines = wait24
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Line(s)']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addlines);

		WebDriverWait wait25 = new WebDriverWait(driver, 120);
		WebElement search = wait25.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		search.sendKeys("cont");
		Thread.sleep(3000);
		WebDriverWait wait26 = new WebDriverWait(driver, 120);
		WebElement contractrooms = wait26.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='ant-checkbox-wrapper'])[5]")));
		contractrooms.click();
		driver.switchTo().activeElement();
		search.clear();
		search.sendKeys("occu");
		WebDriverWait wait27 = new WebDriverWait(driver, 120);
		WebElement tor = wait27.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='ant-checkbox-wrapper'])[4]")));
		tor.click();
		driver.switchTo().activeElement();
		search.clear();
		search.sendKeys("group r");
		WebDriverWait wait31 = new WebDriverWait(driver, 120);
		WebElement gr = wait31.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='ant-checkbox-wrapper'])[3]")));
		gr.click();
		driver.switchTo().activeElement();
		search.clear();
		search.sendKeys("ttl s");
		WebDriverWait wait32 = new WebDriverWait(driver, 120);
		WebElement tsr = wait32.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='ant-checkbox-wrapper'])[2]")));
		tsr.click();
		search.clear();
		search.sendKeys("total o");
		WebDriverWait wait33 = new WebDriverWait(driver, 120);
		WebElement tors = wait33.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='ant-checkbox-wrapper'])[2]")));
		tors.click();
		
		WebDriverWait wait28 = new WebDriverWait(driver, 120);
		WebElement selectbutton = wait28
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Select'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton);
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		WebElement selectbutton1 = wait35
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Select'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton1);
		
		WebDriverWait wait36 = new WebDriverWait(driver, 120);
		WebElement savebutton = wait36
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebutton);

	}

	public void ChooseKBI() throws InterruptedException {
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
				.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selection__rendered'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		Thread.sleep(3000);
		WebDriverWait wait23 = new WebDriverWait(driver, 120);
		WebElement choosekbi = wait23
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Choose KBI']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", choosekbi);
		WebDriverWait wait25 = new WebDriverWait(driver, 120);
		WebElement search = wait25.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		search.sendKeys("total o");
		Thread.sleep(1000);
		WebDriverWait wait27 = new WebDriverWait(driver, 120);
		WebElement tor = wait27
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Total Occupied Rooms']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tor);

		WebDriverWait wait28 = new WebDriverWait(driver, 120);
		WebElement selectbutton = wait28
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectbutton);
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement savebutton = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebutton);
	}

	public void Delete() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement dropdown = wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/section/section/section/main/div/section/div/div/div/section/div/div[4]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div[3]/div[1]/div[2]/section[1]/div/div[3]/div/div[3]/div[2]/div/span/div/div/div/div[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		WebDriverWait wait30 = new WebDriverWait(driver, 120);
		WebElement addoredit1 = wait30
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Add/Edit Formulas']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addoredit1);
		WebDriverWait wait28 = new WebDriverWait(driver, 120);
		WebElement deletebutton = wait28.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='ant-btn delete ant-btn-icon-only']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletebutton);
		Thread.sleep(5000);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement confirm = wait19
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Confirm Delete?']")));
		String deleteconfirm = confirm.getText();
		System.out.println(deleteconfirm);
		Assert.assertEquals("Confirm Delete?", deleteconfirm);

		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement ok = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='OK']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

	}


}
