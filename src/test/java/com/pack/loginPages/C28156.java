package com.pack.loginPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.testCases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C28156 extends TC_BaseClass {
	WebDriver ldriver;

	public C28156(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//div[@row-index='0']/div[@aria-colindex='1']")
	WebElement empName;
	@FindBy(xpath = "//form[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[text()='Additional Fields']")
	WebElement additionalFields;
	@FindBy(xpath = "//div[7]/div[2]/div[1]/div[2]/div[1]/span[1]/input[1]")
	WebElement adderss;
	@FindBy(xpath = "//div[@id='STATE']")
	WebElement state;
	@FindBy(xpath = "//form[2]/div/div[2]/div/div[7]/div[6]/div/div[2]/div/span[1]/input[1]")
	WebElement zipCode;
	@FindBy(xpath = "//form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/input[1]")
	WebElement displayName;
	@FindBy(xpath = "//input[contains(@placeholder,'Name or EmpID')]")
	WebElement searchEmployee;
	@FindBy(xpath = "//div[@class='EmployeeSidebar-module___employeeSidebarTableCell___hpZDq']")
	WebElement updatedEmp;
	@FindBy(xpath = "//span[normalize-space()='Status']")
	WebElement status;
	@FindBy(xpath = "//button[@class='ant-btn EmployeeStatusTimeline-module___EmploymentStatusTimelineAddStatusButton___2yfRd']")
	WebElement addButton;
	@FindBy(xpath = "//span[normalize-space()='Terminated']")
	WebElement terminated;
	@FindBy(xpath = "//div[contains(@class,'ant-col ant-form-item-control-wrapper')]/div/span/span/input")
	WebElement effectiveDate;
	@FindBy(xpath = "//button[contains(@class,'ant-btn ant-btn-primary')]")
	WebElement addStatus;
	@FindBy(xpath = "//button[@class='ant-btn EmployeeSidebar-module___filterButton___2_Aus ant-btn-primary ant-btn-circle ant-btn-icon-only']")
	WebElement expandFilter;
	@FindBy(xpath = "//div[@class='EmployeeSidebar-module___filterSelect___1xYYQ ant-select ant-select-enabled']//div[@class='ant-select-selection__rendered']")
	WebElement employeeSet;
	@FindBy(xpath = "//li[normalize-space()='Inactive']")
	WebElement inactive;
	@FindBy(xpath = "//button[@class='ant-btn EmployeeStatusTimeline-module___EmploymentStatusTimelineDeleteStatusButton___3Adkn ant-btn-primary ant-btn-sm']")
	WebElement deleteEmp;
	@FindBy(xpath = "//button[contains(@class,'ant-btn ant-btn-primary ant-btn-sm')]")
	WebElement delete;
	@FindBy(xpath = "//li[normalize-space()='Active']")
	WebElement active;

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

	public void switchFrame() throws InterruptedException {
		driver.switchTo().frame(frame);
	}

	public void UpdateEmployee(String empId, String Address, String City) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement searchEmp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Name or EmpID')]")));
		Thread.sleep(8000);
		searchEmp.click();
		searchEmp.clear();
		searchEmp.sendKeys(empId);
		Thread.sleep(8000);
		empName.click();
		Thread.sleep(6000);
		additionalFields.click();
		adderss.sendKeys(Address);
		WebElement city = driver.findElement(By
				.xpath("//form[2]//div[1]//div[2]//div[1]//div[7]//div[4]//div[1]//div[2]//div[1]//span[1]//input[1]"));
		city.sendKeys(City);
	}

	public void SelectZipCode(String State, String Zipcode, String dName) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement state = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='STATE']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", state);

		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(State)) {
				Thread.sleep(3000);
				allOptions.get(i).click();
				break;

			}
		}
		zipCode.sendKeys(Zipcode);
		displayName.sendKeys(Keys.CONTROL + "a");
		displayName.sendKeys(Keys.DELETE);
		displayName.sendKeys(dName);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement updatedEmp = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='EmployeeSidebar-module___employeeSidebarTableCell___hpZDq']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", updatedEmp);
	}

	public void clickStatus(String effectivedate) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement status = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Status']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", status);

		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement addButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn EmployeeStatusTimeline-module___EmploymentStatusTimelineAddStatusButton___2yfRd']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
		Thread.sleep(3000);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement terminated = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Terminated']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", terminated);
		Thread.sleep(4000);
		effectiveDate.sendKeys(Keys.CONTROL + "a");
		effectiveDate.sendKeys(Keys.DELETE);
		effectiveDate.sendKeys(effectivedate);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement addStatus = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		Thread.sleep(4000);
		addStatus.click();
		WebDriverWait wait4 = new WebDriverWait(driver, 40);
		WebElement expandFilter = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn EmployeeSidebar-module___filterButton___2_Aus ant-btn-primary ant-btn-circle ant-btn-icon-only']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expandFilter);
		Thread.sleep(4000);
		WebDriverWait wait5 = new WebDriverWait(driver, 40);
		WebElement employeeSet = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='EmployeeSidebar-module___filterSelect___1xYYQ ant-select ant-select-enabled']//div[@class='ant-select-selection__rendered']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeSet);
        
		WebDriverWait wait6 = new WebDriverWait(driver, 40);
		WebElement inactive = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//li[normalize-space()='Inactive']")));
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inactive);
	}

	public void deleteStatus() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 80);
		WebElement Status = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Status']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Status);

		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement deleteEmp = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn EmployeeStatusTimeline-module___EmploymentStatusTimelineDeleteStatusButton___3Adkn ant-btn-primary ant-btn-sm']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteEmp);

		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement delete = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary ant-btn-sm')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);

		WebDriverWait wait4 = new WebDriverWait(driver, 40);
		WebElement employeeSet = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='EmployeeSidebar-module___filterSelect___1xYYQ ant-select ant-select-enabled']//div[@class='ant-select-selection__rendered']")));
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeSet);

		WebDriverWait wait5 = new WebDriverWait(driver, 40);
		WebElement active = wait5
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Active']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", active);

		WebDriverWait wait6 = new WebDriverWait(driver, 40);
		WebElement Statu = wait6
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Status']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Statu);
		Thread.sleep(6000);
	}
}
