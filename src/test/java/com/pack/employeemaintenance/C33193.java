package com.pack.employeemaintenance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.employeemaintenancetestcases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C33193 extends TC_BaseClass {
	WebDriver ldriver;

	public C33193(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@row-index='0']/div[@aria-colindex='1']")
	WebElement empName;
	@FindBy(xpath = "//div[contains(@class,'ant-row')]//div[1]//div[1]//div[1]//div[2]//div[1]//span[1]//span[1]//input[1]")
	WebElement startTime;
	@FindBy(xpath = "//div[contains(@class,'ant-row')]//div[2]//div[1]//div[1]//div[2]//div[1]//span[1]//span[1]//input[1]")
	WebElement endTime;

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
	public void switchFrame() throws InterruptedException {
		driver.switchTo().frame(frame);
	}

	public void selectEmployee(String empId) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement searchEmp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Name or EmpID')]")));
		Thread.sleep(8000);
		// searchEmp.click();
		searchEmp.clear();
		searchEmp.sendKeys(empId);
		Thread.sleep(6000);
		empName.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement job = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Jobs']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", job);
	}

	public void addJob() {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement addJob = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add Job']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addJob);
	}

	public void selectAutoJob2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement searchJob = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		Thread.sleep(6000);
		searchJob.clear();
		searchJob.sendKeys("Auto Div1");
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement selectjob = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Expand All']//button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectjob);
		Thread.sleep(6000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement autoJob2 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@row-index='3']/div/span/span[4]/div/div/label")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoJob2);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement save = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);

	}

	public boolean selectAutoJob3() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				addJob();
				WebDriverWait wait = new WebDriverWait(driver, 180);
				WebElement searchJob = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
				Thread.sleep(6000);
				searchJob.clear();
				searchJob.sendKeys("Auto Div1");
				WebDriverWait wait2 = new WebDriverWait(driver, 40);
				WebElement selectjob = wait2
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Expand All']//button")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectjob);
				Thread.sleep(6000);
				WebDriverWait wait1 = new WebDriverWait(driver, 40);
				WebElement autoJob3 = wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@row-index='4']/div/span/span[4]/div/div/label")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoJob3);
				WebDriverWait wait3 = new WebDriverWait(driver, 40);
				WebElement save = wait3.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void selectCertifications() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement job = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[9]//span[normalize-space()='Certifications']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", job);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement addNewCertification = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add New Certification']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewCertification);
	}

	public void clickDropDown(String autoCert1) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement certDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//form[@class='ant-form ant-form-horizontal AddEditCertificationModal-module___AddEditCertificationModalForm___yuZDO']/div[1]/div[2]/div/div/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", certDropDown);
		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(autoCert1)) {
				Thread.sleep(2000);
				allOptions.get(i).click();
				break;

			}
		}
	}

	public void selectIssueDate(String issuedate,String startdate) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement issueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'ant-modal-body')]//div[2]//div[2]//div[1]//div[1]//div[1]//span[1]//span[1]//input[1]")));
		issueDate.sendKeys(Keys.CONTROL + "a");
		issueDate.sendKeys(Keys.DELETE);
		issueDate.sendKeys(issuedate);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement startDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'ant-modal-body')]//div[3]//div[2]//div[1]//div[1]//div[1]//span[1]//span[1]//input[1]")));
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		startDate.sendKeys(startdate);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement expireDate = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'ant-modal-body')]//div[4]//div[2]//div[1]//div[1]//div[1]//span[1]//span[1]//input[1]")));
		expireDate.sendKeys(Keys.CONTROL + "a");
		expireDate.sendKeys(Keys.DELETE);
		expireDate.sendKeys("4/7/2022");
		Thread.sleep(4000);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement add = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);

	}

	public void clickAutocert1Ellipsis(String expirationdate) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement autocert1Ellipsis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='CertificationTab-module___CertificationCards___3QbNa']//div[1]//div[1]//div[1]//div[2]//button[1]")));
		Thread.sleep(4000);
		autocert1Ellipsis.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement expirationDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[4]/div[2]/div/div/div/span/span/input")));
		expirationDate.sendKeys(Keys.CONTROL + "a");
		expirationDate.sendKeys(Keys.DELETE);
		expirationDate.sendKeys(expirationdate);

		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement expirationDate1 = wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[3]/div[2]/div/div/div/span/span/input")));
		expirationDate1.sendKeys(Keys.CONTROL + "a");
		expirationDate1.sendKeys(Keys.DELETE);
		expirationDate1.sendKeys("2/7/2022");
	
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement update = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", update);

	}

	public void clickAutocert2(String autoCert2) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement addNewCertification = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add New Certification']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewCertification);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement certDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//form[@class='ant-form ant-form-horizontal AddEditCertificationModal-module___AddEditCertificationModalForm___yuZDO']/div[1]/div[2]/div/div/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", certDropDown);
		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			Thread.sleep(2000);
			if (allOptions.get(i).getText().contains(autoCert2)) {
				Thread.sleep(2000);
				allOptions.get(i).click();
				break;

			}
		}
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement add = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
	}

	public void clickAutocert2Ellipsis() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement autocert1Ellipsis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='ant-card CertificationCard-module___CertificationCard___XGy62 CertificationCard-module___CertificationCardExpired___1sCBN ant-card-bordered']//button[@type='button']")));
		Thread.sleep(4000);
		autocert1Ellipsis.click();

		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement delete = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[contains(@class,'ant-btn AddEditCertificationModal-module___deleteButton___1dwlN ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement clickOk = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-modal-body']//button[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOk);
		Thread.sleep(4000);
	}
	public void addAutocert2(String autoCert2) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement addNewCertification = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add New Certification']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewCertification);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement certDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//form[@class='ant-form ant-form-horizontal AddEditCertificationModal-module___AddEditCertificationModalForm___yuZDO']/div[1]/div[2]/div/div/div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", certDropDown);
		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			Thread.sleep(2000);
			if (allOptions.get(i).getText().contains(autoCert2)) {
				Thread.sleep(2000);
				allOptions.get(i).click();
				break;

			}
		}
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement add = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
	}

	public void clickUnifocus() throws InterruptedException {

		driver.switchTo().defaultContent();
		WebElement close = driver.findElement(
				By.xpath("//div[@class='ant-tabs-nav-container']//div[2]//div[1]//i[@aria-label='icon: close']"));
		close.click();
		driver.switchTo().defaultContent();
		unifocus.click();
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement labor = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Labor']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labor);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement scheduling = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduling);
		driver.switchTo().frame(frame);
		
	}

	public boolean retryingFindClick() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {

				WebDriverWait wait = new WebDriverWait(driver, 120);
				WebElement ele = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector("div > div >button.ant-dropdown-trigger:nth-child(2)")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				Actions action = new Actions(driver);
				action.moveToElement(ele).build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void selectFilterJobButton() throws InterruptedException {
		try {
			driver.switchTo().activeElement();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement das = driver.findElement(By.xpath("//li[text()='Filter by Job']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", das);
		} catch (Exception e) {
		}
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-btn-icon-only']/i[@aria-label='icon: minus-square-o']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement searchEmp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Find By Name')]")));
		Thread.sleep(8000);
		// searchEmp.click();
		searchEmp.clear();
		searchEmp.sendKeys("Auto Job1");
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.executeScript(
				"document.querySelector('div[style=\"height: 85%; width: 100%; display: flex; flex-direction: column; overflow: auto; margin-top: 8px;\"]').scrollTop=1200");
	}

	public void selectAutoAssignmnt1(String dates) throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement autoJob1 = wait2.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[@role='tree']/li[20]/ul/li/ul/li/ul/li[1]/span[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoJob1);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		Thread.sleep(4000);
		WebDriverWait wait6 = new WebDriverWait(driver, 40);
		WebElement date = wait6.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='unifocus-selectdropdown ant-select ant-select-enabled']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", date);
		WebDriverWait wait7 = new WebDriverWait(driver, 40);
		WebElement dateRange = wait7
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='"+dates+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateRange);
	}

	public boolean doubleClickEmptyCell(String doubleclick) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				Thread.sleep(3000);
				Actions action = new Actions(driver);
				WebElement code=driver.findElement(By.xpath(
						"//*[@id=\"root\"]/div/section/section/main/div/div/section/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div["+doubleclick+"]/div/div/div[2]"));
				action.moveToElement(code).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void selectStartTime(String starttime,String endtime,String JobName) throws InterruptedException {
		startTime.sendKeys(starttime);
		endTime.sendKeys(endtime);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement dropDown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='job']//div[@class='ant-select-selection__rendered']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropDown);
		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(JobName)) {
				Thread.sleep(2000);
				allOptions.get(i).click();
				break;

			}
		}
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement save = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn ShiftDetailsFooterSection-module___SaveButton___16cbP ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement ok = wait2.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		Thread.sleep(4000);
	}

}
