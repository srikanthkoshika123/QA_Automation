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

public class C30319 extends TC_BaseClass {
	WebDriver ldriver;

	public C30319(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//body//div//div[@class='ant-modal-body']//div//div//div//div[1]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement Empid;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[2]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement DisplayName;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[3]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement FirstName;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[4]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement middleName;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[5]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement lastName;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[6]//div[1]//div[2]//div[1]//span[1]//input[1]")
	WebElement Email;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[7]//div[1]//div[2]//div[1]//span//span//input[1]")
	WebElement hireDate;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[8]//div[1]//div[2]//div[1]//span//span//input[1]")
	WebElement seniority;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//div//div[9]//div[1]//div[2]//div[1]//span[1]//div//div//div")
	WebElement workClass;
	@FindBy(xpath = "//div[@class='ant-modal-body']//div//div//form[@class='ant-form ant-form-horizontal']//div//div[@id='TIPPED']")
	WebElement tipped;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary']")
	WebElement next;
	@FindBy(xpath = "//div[@row-index='0']/div[@aria-colindex='1']")
	WebElement empName;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//span[text()='Labor']")
	WebElement labor;
	@FindBy(xpath = "//li[@title='Scheduling']")
	WebElement scheduling;

	public void switchFrame() throws InterruptedException {
		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement addnew = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addnew);
	}

	public void addNewemployee(String id, String dname, String fname, String mname, String lname, String email,
			String jdate, String sdate) throws InterruptedException {
		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement Empid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//body//div//div[@class='ant-modal-body']//div//div//div//div[1]//div[1]//div[2]//div[1]//span[1]//input[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Empid);
		Empid.sendKeys(id);
		Assert.assertEquals(true, Empid.isEnabled());
		System.out.println(Empid.isEnabled());
		DisplayName.sendKeys(dname);
		Assert.assertEquals(true, DisplayName.isEnabled());
		System.out.println(DisplayName.isEnabled());
		FirstName.sendKeys(fname);
		middleName.sendKeys(mname);
		lastName.sendKeys(lname);
		Email.sendKeys(email);
		hireDate.sendKeys(jdate);
		seniority.sendKeys(sdate);
	}

	public void selectWorkClass(String option) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement workClass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='ant-modal-body']//div//div//div//div[9]//div[1]//div[2]//div[1]//span[1]//div//div//div")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", workClass);

		List<WebElement> allOptions = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(option)) {
				Thread.sleep(3000);
				allOptions.get(i).click();
				break;

			}
		}

	}

	public void selectTipped(String tip) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement tipped = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='ant-modal-body']//div//div//form[@class='ant-form ant-form-horizontal']//div//div[@id='TIPPED']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tipped);
		List<WebElement> Options = driver.findElements(By.xpath(
				"//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li"));

		for (WebElement item : Options) {
			if (item.getText().equalsIgnoreCase(tip)) {
				Thread.sleep(400);
				item.click();
				break;
			}
		}
		next.click();
	}

	public void selectJob() throws InterruptedException {
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
		WebElement autoDiv = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//label[@class='uf-tree-selector-tree-item-single-select-cell-renderer__selection ant-radio-wrapper']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoDiv);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement save = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);

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
		WebElement assignments = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Assignments']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", assignments);

	}

	public void selectAddEmployeeAssignment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement addAssignments = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='Add Employee Assignment']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addAssignments);
		WebDriverWait wait1 = new WebDriverWait(driver, 180);
		WebElement filter = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Filter by name']")));
		filter.sendKeys("Auto Assignment1");

	}

	public void DeleteFilterBox() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait1 = new WebDriverWait(driver, 80);
		WebElement filter = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Filter by name']")));
		filter.sendKeys(Keys.CONTROL + "a");
		filter.sendKeys(Keys.DELETE);

	}

	public boolean selectAutoAssignment1() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebElement Searchjob = driver.findElement(
						By.xpath("//div[text()='Auto Div1 / Auto Department1 / Auto Job1 / Auto Assignment1']"));
				Thread.sleep(6000);
				Searchjob.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public boolean selectAutoAssignment2() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				Thread.sleep(6000);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				WebElement assignment2 = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[text()='Auto Div1 / Auto Department1 / Auto Job1 / Auto Assignment2']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", assignment2);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickOkButton() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement addAssignments = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='Add Employee Assignment']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addAssignments);
	}

	public boolean selectAutoAssignment3() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				Thread.sleep(4000);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				WebElement assignment3 = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[text()='Auto Div1 / Auto Department1 / Auto Job1 / Auto Assignment3']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", assignment3);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void selectRankDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement rank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='AddAssignmentModal-module___Select___2N6Q6 ant-select ant-select-enabled']//div[@class='ant-select-selection__rendered']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", rank);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement selectRank = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='2']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectRank);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement ok = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

	}

	/*
	 * public boolean selectAutoAssignment() throws InterruptedException { boolean
	 * result = false; int attempts = 0; while (attempts < 2) { try { Actions
	 * builder = new Actions(driver); WebDriverWait wait = new WebDriverWait(driver,
	 * 40); WebElement assignment2 =driver.findElement(By.
	 * xpath("//div[@row-index='1']//span[@class='ag-icon ag-icon-grip']"));
	 * WebElement assignment3 =driver.findElement(By.
	 * xpath("//div[@row-index='2']//span[@class='ag-icon ag-icon-grip']")); Action
	 * dragAndDrop = builder.clickAndHold(assignment3) .moveToElement(assignment2)
	 * .release(assignment2) .build(); dragAndDrop.perform(); result = true; break;
	 * } catch (StaleElementReferenceException e) { } attempts++; } return result; }
	 */
	public boolean clickAssignment3() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				Thread.sleep(4000);
				WebDriverWait wait = new WebDriverWait(driver, 40);
				WebElement assignment3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//div[@row-index='2']//div[@class='input-cell-content'][contains(text(),'Auto Div1\\Auto Department1\\Auto Job1\\Auto Assignment3')]")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", assignment3);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void removeAssignment() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement remove = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(text(),'Remove Selected Assignment')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", remove);
        Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement activeCheckBox = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@row-index='1']//label[contains(@class,'input-boolean-renderer  ant-checkbox-wrapper ant-checkbox-wrapper-checked')]//span[contains(@class,'ant-checkbox-inner')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", activeCheckBox);

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
		Thread.sleep(4000);
		labor.click();
		Thread.sleep(4000);
		scheduling.click();
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
				driver.switchTo().activeElement();
				WebElement das = driver.findElement(By.xpath("//li[text()='Filter by Job']"));
				Thread.sleep(4000);
				das.click();
				WebDriverWait wait1 = new WebDriverWait(driver, 40);
				WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//button[@class='ant-btn ant-btn-icon-only']/i[@aria-label='icon: minus-square-o']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public void selectFilterJobButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement searchEmp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Find By Name')]")));
		Thread.sleep(8000);
		// searchEmp.click();
		searchEmp.clear();
		searchEmp.sendKeys("Auto Assignment");
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.executeScript(
				"document.querySelector('div[style=\"height: 85%; width: 100%; display: flex; flex-direction: column; overflow: auto; margin-top: 8px;\"]').scrollTop=1200");
	}
	public void selectAutoAssignmnt1() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement autoAssinment1 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//ul[@role='tree']/li[20]/ul/li/ul/li/ul/li[1]/span[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoAssinment1);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

		Thread.sleep(8000);
	}
	public void selectAutoAssignmnt2() throws InterruptedException {
		clickUnifocus();
		retryingFindClick();
		selectFilterJobButton();
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement autoAssinment2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//ul[@role='tree']/li[20]/ul/li/ul/li/ul/li[2]/span[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoAssinment2);
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		Thread.sleep(8000);
		
	}
	public void selectAutoAssignmnt3() throws InterruptedException {
		clickUnifocus();
		retryingFindClick();
		selectFilterJobButton();
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement autoAssinment3 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//ul[@role='tree']/li[20]/ul/li/ul/li/ul/li[3]/span[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoAssinment3);
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		Thread.sleep(8000);
		
	}
}
