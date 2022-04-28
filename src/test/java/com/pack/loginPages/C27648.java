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
public class C27648 extends TC_BaseClass{
	WebDriver ldriver;

	public C27648(WebDriver rdriver) {
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
	@FindBy(xpath = "//span[text()='Employee']")
	WebElement employee;
	@FindBy(xpath = "//li[text()='Certifications']")
	WebElement certifications;
	@FindBy(xpath = "//li[text()='Employee Classes']")
	WebElement ec;
	@FindBy(xpath = "//li[text()='Employee Field Overrides']")
	WebElement efo;
	@FindBy(xpath = "//li[text()='Employee Sets']")
	WebElement es;
	@FindBy(xpath = "//li[text()='Employee User Maps']")
	WebElement eum;
	@FindBy(xpath = "//li[text()='Employee Work Classes']")
	WebElement ewc;
	@FindBy(xpath = "//li[text()='Local Taxes']")
	WebElement lt;
	@FindBy(xpath = "//li[text()='Salary Distributions']")
	WebElement sd;
	@FindBy(xpath = "//li[text()='Schedule Groups']")
	WebElement sg;
	@FindBy(xpath = "//li[text()='States']")
	WebElement states;
	@FindBy(xpath = "//li[text()='Status Change Reasons']")
	WebElement scr;
	@FindBy(xpath = "//li[text()='Tax Types']")
	WebElement tt;
	@FindBy(xpath = "//li[text()='Time Off Types']")
	WebElement tot;
	
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
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement setup = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Setup']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement employee = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Employee']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employee);
	}
	public void Certifications() {
		certifications.click();
        driver.switchTo().frame(frame);
		
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait1= new WebDriverWait(driver, 120);
		WebElement cname= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Certification Name']")));
	    String certiname = cname.getText();
	    System.out.println(certiname);
		Assert.assertEquals("Certification Name",certiname);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Certifications']")).getText());
	}
	public void EmployeeClasses() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeClasses = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Employee Classes']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeClasses);
		driver.switchTo().frame(frame);
		
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uf-tri-area-inner-left']//button[@type='button']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement name= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String nameEmp = name.getText();
	    System.out.println(nameEmp);
		Assert.assertEquals("Name",nameEmp);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee Classes']")).getText());
	}
	public void EmployeeFieldOverrides() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeFieldOverrides = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Employee Field Overrides']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeFieldOverrides);
		driver.switchTo().frame(frame);
		
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement sf= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Standard Fields']")));
	    String standfields = sf.getText();
	    System.out.println(standfields);
		Assert.assertEquals("Standard Fields",standfields);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement fn= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Field Name']")));
	    String fieldname = fn.getText();
	    System.out.println( fieldname);
		Assert.assertEquals("Field Name", fieldname);
		
		driver.switchTo().defaultContent();
		close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee Field Overrides']")).getText());
	}
	public void EmployeeSets() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeSets = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Employee Sets']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeSets);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'uf-border-panel-left')]//div[contains(@class,'uf-border-panel-top')]//button[1]")));
	    String addbutton = addb.getText();
		Assert.assertEquals(true,addb.isDisplayed());
		System.out.println("add button is displayed");
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement delb= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uf-border-panel-left']//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//button[2]")));
	    String delbutton = delb.getText();
		Assert.assertEquals(true,delb.isDisplayed());
		System.out.println("delete button is displayed");
		
		WebDriverWait wait3= new WebDriverWait(driver, 120);
		WebElement es= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Employee Sets']")));
	    String empsets = es.getText();
	    System.out.println( empsets);
		Assert.assertEquals("Employee Sets", empsets);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee Sets']")).getText());
	}
	public void employeeUserMaps() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeUserMaps = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Employee User Maps']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeUserMaps);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement m= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mapped']")));
	    String mapped = m.getText();
	    System.out.println(mapped);
		Assert.assertEquals("Mapped",mapped);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement s= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Select']")));
	    String select = s.getText();
	    System.out.println( select);
		Assert.assertEquals("Select", select);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee User Maps']")).getText());
	}
	public void employeeWorkClasses() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeWorkClasses = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Employee Work Classes']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeWorkClasses);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name", name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Employee Work Classes']")).getText());
	}
	public void localTaxes() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement localTaxes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Local Taxes']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", localTaxes);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name", name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Local Taxes']")).getText());
	}
	public void salaryDistributions() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement salaryDistributions = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Salary Distributions']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salaryDistributions);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uf-tri-area-inner-left']//button[1]")));
	    String addbutton = addb.getText();
		Assert.assertEquals(true,addb.isDisplayed());
		System.out.println("add button is displayed");
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement d= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
	    String details = d.getText();
	    System.out.println(details);
		Assert.assertEquals("Details",details);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Salary Distributions']")).getText());
	}
	public void ScheduleGroups() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement employeeClasses = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Schedule Groups']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeClasses);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name",name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Schedule Groups']")).getText());
	}
	public void states() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement states = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='States']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", states);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name", name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='States']")).getText());
	}
	public void statusChangeReasons() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement statusChangeReasons = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Status Change Reasons']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusChangeReasons);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name", name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Status Change Reasons']")).getText());
	}
	public void taxTypes() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement taxTypes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Tax Types']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", taxTypes);
		driver.switchTo().frame(frame);
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Row']")));
	    String addbutton = addb.getText();
	    System.out.println(addbutton);
		Assert.assertEquals("Add Row",addbutton);
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement n= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
	    String name = n.getText();
	    System.out.println( name);
		Assert.assertEquals("Name", name);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Tax Types']")).getText());		
	}
	public void timeOffTypes() {
		clickUnifocus();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement timeOffTypes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Time Off Types']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", timeOffTypes);
		driver.switchTo().frame(frame);
		
		WebDriverWait wait= new WebDriverWait(driver, 120);
		WebElement addb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uf-border-panel-left']//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//button[1]")));
	    String addbutton = addb.getText();
		Assert.assertEquals(true,addb.isDisplayed());
		System.out.println("add button is displayed");
		
		WebDriverWait wait2= new WebDriverWait(driver, 120);
		WebElement d= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Details']")));
	    String details = d.getText();
	    System.out.println(details);
		Assert.assertEquals("Details", details);
		
		driver.switchTo().defaultContent();
        close.click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Time Off Types']")).getText());
		
	}	
}

