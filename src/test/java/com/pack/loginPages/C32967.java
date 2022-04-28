package com.pack.loginPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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

import com.pack.testCases.TC_BaseClass;

public class C32967 extends TC_BaseClass {
	WebDriver ldriver;

	public C32967(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;

	public void clickUnifocus() {
		unifocus.click();
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement setup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Setup')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setup);

		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement laborStructure = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Labor Structure']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", laborStructure);
	}

	public void switchFrame() throws InterruptedException {
		driver.switchTo().frame(frame);
	}

	public boolean selectPropertyDefault() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 120);
				WebElement propertyDefault = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[@aria-colindex='1']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyDefault);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public void clickAdd() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-dropdown-trigger']//span[contains(text(),'Add')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.switchTo().activeElement();
		WebElement addDivision = driver.findElement(By.xpath("//li[contains(text(),'Add Division')]"));
		addDivision.click();
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.executeScript("document.querySelector('div[ref=\"eBodyViewport\"]').scrollTop=600");

	}

	public boolean doubleClick() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver
						.findElement(By.xpath("//div[@row-index='23']//span[text()='Division 1']"));
				action.moveToElement(doubleClick).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void changeNameDivision(String divisionName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editName = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Division 1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editName);
		editName.sendKeys(Keys.CONTROL + "a");
		editName.sendKeys(Keys.DELETE);
		editName.sendKeys(divisionName);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickCode() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='23']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick().build().perform();
				Thread.sleep(4000);
				code.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditCode(String divisionCode) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Division 1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(divisionCode);
		editCode.sendKeys(Keys.ENTER);
	}

	public void clickAddDepatment(String expandDivision) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-dropdown-trigger']//span[contains(text(),'Add')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.switchTo().activeElement();
		WebElement addDivision = driver.findElement(By.xpath("//li[normalize-space()='Add Department']"));
		addDivision.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement expanddivision = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@row-index='" + expandDivision + "']//span[@class='ag-icon ag-icon-contracted']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expanddivision);

	}

	public boolean doubleClickDepatment() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {

				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement date = new WebDriverWait(driver, 20).until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@row-index='24']//span[text()='Department1']")));
				new Actions(driver).moveToElement(date).doubleClick().click().click().build().perform();
				new Actions(driver).moveToElement(date).doubleClick().click().click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void changeNameDepartment(String departmentName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editDepartment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Department1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDepartment);
		editDepartment.sendKeys(Keys.CONTROL + "a");
		editDepartment.sendKeys(Keys.DELETE);
		editDepartment.sendKeys(departmentName);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickDepartmentCode() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='24']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditDepartmentCode(String departmentCode) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Department1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(departmentCode);
		editCode.sendKeys(Keys.ENTER);
	}

	public void clickAddJob(String expandDepartment) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-dropdown-trigger']//span[contains(text(),'Add')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.switchTo().activeElement();
		WebElement addJob = driver.findElement(By.xpath("//li[normalize-space()='Add Job']"));
		addJob.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement expandDivision = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@row-index='" + expandDepartment + "']//span[@class='ag-icon ag-icon-contracted']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expandDivision);

	}

	public boolean doubleClickJob() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement date = new WebDriverWait(driver, 20).until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@row-index='25']//span[text()='Job1']")));
				new Actions(driver).moveToElement(date).doubleClick().click().click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void changeNameJob(String JobName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editDepartment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Job1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDepartment);
		editDepartment.sendKeys(Keys.CONTROL + "a");
		editDepartment.sendKeys(Keys.DELETE);
		editDepartment.sendKeys(JobName);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickJobCode() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='25']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditJobCode(String JobCode) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Job1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(JobCode);
		editCode.sendKeys(Keys.ENTER);
	}

	public void clickAddAssignment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-dropdown-trigger']//span[contains(text(),'Add')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.switchTo().activeElement();
		WebElement addJob = driver.findElement(By.xpath("//li[normalize-space()='Add Assignment']"));
		Thread.sleep(4000);
		addJob.click();

	}

	public void expandJob(String expandJob) {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement expandAssignment = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@row-index='" + expandJob + "']//span[@class='ag-icon ag-icon-contracted']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expandAssignment);

	}

	public boolean doubleClickAssignment() throws InterruptedException {

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {

				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement department = driver
						.findElement(By.xpath("//div[@row-index='26']//span[text()='Assignment1']"));
				action.moveToElement(department).doubleClick().click().click().build().perform();
				action.moveToElement(department).doubleClick().click().click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void changeNameAssignment(String assignment1Name) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editDepartment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDepartment);
		editDepartment.sendKeys(Keys.CONTROL + "a");
		editDepartment.sendKeys(Keys.DELETE);
		editDepartment.sendKeys(assignment1Name);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickAssignmentCode() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='26']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick().build().perform();
				Thread.sleep(4000);
				code.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditAssignmentCode(String assignment1Code) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(assignment1Code);
		editCode.sendKeys(Keys.ENTER);
	}

	public boolean doubleClickAutoJob1() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement department = driver
						.findElement(By.xpath("//div[@row-index='25']//span[text()='Auto Job1']"));
				action.moveToElement(department).click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickExpandAutoJob1() throws InterruptedException {
		clickAddAssignment();

	}

	public boolean doubleClickAssignment2() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {

				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement department = driver
						.findElement(By.xpath("//div[@row-index='26']//span[text()='Assignment1']"));
				action.moveToElement(department).doubleClick().click().click().build().perform();
				action.moveToElement(department).doubleClick().click().click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void changeNameAssignment2(String assignment2Name) throws InterruptedException {
		// doubleClickAssignment();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editDepartment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDepartment);
		editDepartment.sendKeys(Keys.CONTROL + "a");
		editDepartment.sendKeys(Keys.DELETE);
		editDepartment.sendKeys(assignment2Name);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickAssignment2Code() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='27']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditAssignmentCode2(String assignment2Code) throws InterruptedException {
		// doubleClickAssignmentCode();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(assignment2Code);
		editCode.sendKeys(Keys.ENTER);
	}

	public void changeNameAssignment3(String assignment3Name) throws InterruptedException {
		doubleClickAutoJob1();
		clickAddAssignment();
		doubleClickAssignment();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editDepartment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDepartment);
		editDepartment.sendKeys(Keys.CONTROL + "a");
		editDepartment.sendKeys(Keys.DELETE);
		editDepartment.sendKeys(assignment3Name);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement ok = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public boolean doubleClickAssignmentCode3() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement code = driver.findElement(By.xpath("//div[@row-index='28']//div[@aria-colindex='2']"));
				action.moveToElement(code).doubleClick(code).click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void EditAssignmentCode3(String assignment3Code) throws InterruptedException {
		// doubleClickAssignmentCode();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Assignment1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editCode);
		editCode.sendKeys(Keys.CONTROL + "a");
		editCode.sendKeys(Keys.DELETE);
		editCode.sendKeys(assignment3Code);
		editCode.sendKeys(Keys.ENTER);
	}

}
