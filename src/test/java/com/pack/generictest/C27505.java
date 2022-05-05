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
public class C27505 extends TC_BaseClass {
	WebDriver ldriver;

	public C27505(WebDriver rdriver) {
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
		WebElement rms = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + dbModel + "']")));
		rms.click();

	}

	public void selectDataBase(String db, String dbName, String module) {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + db + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement doral = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + dbName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
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
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement financial = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Financial']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", financial);
		WebDriverWait wait11 = new WebDriverWait(driver, 120);
		WebElement budgeting = wait11
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Budgeting']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgeting);
		driver.switchTo().frame(frame);
	}

	public void ClickKbiProjections() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 180);
		WebElement occupency = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@title=' Details']")));
		String un = occupency.getText();
		System.out.println(un);

		WebDriverWait wait22 = new WebDriverWait(driver, 180);
		WebElement expand = wait22
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-layout-sider-trigger']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expand);

		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement kbiprojections = wait21
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/section/aside/div[1]/ul/li[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", kbiprojections);

		WebDriverWait wait11 = new WebDriverWait(driver, 40);
		WebElement kbi = wait11
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='KBI Projections']")));
		String KBIProjections = kbi.getText();
		System.out.println(KBIProjections);
		Assert.assertEquals("KBI Projections", KBIProjections);
		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement segment = wait13.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Market Segment Types']")));
		String marketsegmenttype = segment.getText();
		System.out.println(marketsegmenttype);
		Assert.assertEquals("Market Segment Types", marketsegmenttype);
		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement v = wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View']")));
		String View = v.getText();
		System.out.println(View);
		Assert.assertEquals("View", View);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement t = wait19.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Total']")));
		String Total = t.getText();
		System.out.println(Total);
		Assert.assertEquals("Total", Total);
	}

	public void ClickAdjustHoursAndRtes() throws InterruptedException {
		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement AdjustHoursAndRtes = wait21.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[text()='Adjust Hours and Rates'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AdjustHoursAndRtes);

		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement ahr = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Adjust Hours and Rates']")));
		String AdjustHoursandRates = ahr.getText();
		System.out.println(AdjustHoursandRates);
		Assert.assertEquals("Adjust Hours and Rates", AdjustHoursandRates);
		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement segment = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Edit Job Selection']")));
		String EditJobSelection = segment.getText();
		System.out.println(EditJobSelection);
		Assert.assertEquals("Edit Job Selection", EditJobSelection);
		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement v = wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View']")));
		String View = v.getText();
		System.out.println(View);
		Assert.assertEquals("View", View);
	/*	WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement t = wait19.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Total']")));
		String Total = t.getText();
		System.out.println(Total);
		Assert.assertEquals("Total", Total);*/
	}

	public void ClickBudgetTree() throws InterruptedException {

		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement BudgetTree = wait21
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Budget Tree'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", BudgetTree);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement bt = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Budget Tree']")));
		String BudgetTree1 = bt.getText();
		System.out.println(BudgetTree1);
		Assert.assertEquals("Budget Tree", BudgetTree1);
		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement p = wait14
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Period']")));
		String Period = p.getText();
		System.out.println(Period);
		Assert.assertEquals("Period", Period);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement t = wait19
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Line Info']")));
		String LineInfo = t.getText();
		System.out.println(LineInfo);
		Assert.assertEquals("Line Info", LineInfo);
		Thread.sleep(2000);
	}

	public void ClickBudgetConfiguration() throws InterruptedException {

		WebDriverWait wait15 = new WebDriverWait(driver, 120);
		WebElement BudgetConfiguration = wait15.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Configuration']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", BudgetConfiguration);

		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement chart = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Charts']")));
		String charts = chart.getText();
		System.out.println(charts);
		Assert.assertEquals("Charts", charts);
		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement bs = wait14
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Structure']")));
		String budgetstructure = bs.getText();
		System.out.println(budgetstructure);
		Assert.assertEquals("Budget Structure", budgetstructure);
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement fe = wait19.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Full Time Equivalent']")));
		String fulltimeequivalent = fe.getText();
		System.out.println(fulltimeequivalent);
		Assert.assertEquals("Full Time Equivalent", fulltimeequivalent);
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement chart1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Charts']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chart1);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement header3 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Configure charts per Top Level Line']")));
		String ccptll1 = header3.getText();
		System.out.println(ccptll1);
		Assert.assertEquals("Configure charts per Top Level Line", ccptll1);
		WebDriverWait wait2 = new WebDriverWait(driver, 120);
		WebElement fl = wait2
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Filter Lines']")));
		String filterline = fl.getText();
		Assert.assertEquals(true, fl.isDisplayed());
		System.out.println("filter lines button is displayed");
		Thread.sleep(2000);

		WebDriverWait wait22 = new WebDriverWait(driver, 120);
		WebElement bs1 = wait22
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Structure']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bs1);
		WebDriverWait wait20 = new WebDriverWait(driver, 120);
		WebElement bst = wait20
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Budget Structure']")));
		String BudgetStructure = bst.getText();
		System.out.println(BudgetStructure);
		Assert.assertEquals("Budget Structure", BudgetStructure);
		WebDriverWait wait11 = new WebDriverWait(driver, 120);
		WebElement bl = wait11
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Line']")));
		String BudgetLine = bl.getText();
		System.out.println(BudgetLine);
		Assert.assertEquals("Budget Line", BudgetLine);
		Thread.sleep(2000);

		WebDriverWait wait21 = new WebDriverWait(driver, 120);
		WebElement fe1 = wait21.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Full Time Equivalent']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fe1);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		WebElement apl = wait51
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Period Length']")));
		String AddPeriodLength = apl.getText();
		System.out.println(AddPeriodLength);
		Assert.assertEquals("Add Period Length", AddPeriodLength);
		WebDriverWait wait53 = new WebDriverWait(driver, 120);
		WebElement sc = wait53
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save Changes']")));
		String SaveChanges = sc.getText();
		System.out.println(SaveChanges);
		Assert.assertEquals("Save Changes", SaveChanges);
	}

	public void ClickBudgetUtilities() {
		WebDriverWait wait19 = new WebDriverWait(driver, 120);
		WebElement bu = wait19
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Budget Utilities']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bu);

		WebDriverWait wait13 = new WebDriverWait(driver, 120);
		WebElement cd = wait13
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Copy Dataset']")));
		String copydataset = cd.getText();
		System.out.println(copydataset);
		Assert.assertEquals("Copy Dataset", copydataset);

		WebDriverWait wait14 = new WebDriverWait(driver, 120);
		WebElement ed = wait14
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Export Dataset']")));
		String ExportDataset = ed.getText();
		System.out.println(ExportDataset);
		Assert.assertEquals("Export Dataset", ExportDataset);

		WebDriverWait wait15 = new WebDriverWait(driver, 120);
		WebElement ibl = wait15
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Budget Lines']")));
		String ImportBudgetLines = ibl.getText();
		System.out.println(ImportBudgetLines);
		Assert.assertEquals("Import Budget Lines", ImportBudgetLines);

		WebDriverWait wait16 = new WebDriverWait(driver, 120);
		WebElement cleard = wait16
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clear Dataset']")));
		String ClearDataset = cleard.getText();
		System.out.println(ClearDataset);
		Assert.assertEquals("Clear Dataset", ClearDataset);

		WebDriverWait wait20 = new WebDriverWait(driver, 120);
		WebElement rcs = wait20.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rebuild Cost Structures']")));
		String RebuildCostStructures = rcs.getText();
		System.out.println(RebuildCostStructures);
		Assert.assertEquals("Rebuild Cost Structures", RebuildCostStructures);

		driver.switchTo().defaultContent();

	}
}
