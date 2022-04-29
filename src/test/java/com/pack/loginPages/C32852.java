package com.pack.loginPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.testCases.TC_BaseClass;

@SuppressWarnings("deprecation")
public class C32852 extends TC_BaseClass {
	WebDriver ldriver;

	public C32852(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//div[@row-index='0']/div[@aria-colindex='1']")
	WebElement empName;
	@FindBy(xpath = "//section[1]/div/div[1]/div/div/button[1]")
	WebElement addShift;
	@FindBy(xpath = "//div[contains(@class,'ant-col ant-col-9')]//div[1]//div[2]//div[1]//span[1]//span[1]//input[1]")
	WebElement startTime;
	@FindBy(xpath = "//div[contains(@class,'ant-col ant-col-9')]//div[2]//div[2]//div[1]//span[1]//span[1]//input[1]")
	WebElement endTime;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//span[text()='Labor']")
	WebElement labor;
	@FindBy(xpath = "//li[@title='Scheduling']")
	WebElement scheduling;

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
		WebElement scheduling = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduling);

	}

	public void selectEmployeeType() throws InterruptedException {
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement addShift = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//section[1]/div[1]/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addShift);

	}

	public void selectShiftTime(String starttime, String endtime) throws InterruptedException {
		Thread.sleep(4000);
		startTime.sendKeys(starttime);
		endTime.sendKeys(endtime);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement preferredOff = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='type']/label[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", preferredOff);
	}

	public void selectCheckBoxs(String day1, String day2) throws InterruptedException {

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size = checkBoxes.size();
		for (int i = 0; i < size; i++) {

			String value = checkBoxes.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day1)) {

				checkBoxes.get(i).click();

				break;

			}
		}

		List<WebElement> checkBoxes1 = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size1 = checkBoxes.size();
		for (int i = 0; i < size1; i++) {

			String value = checkBoxes1.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day2)) {

				checkBoxes1.get(i).click();

				break;

			}

		}
		WebDriverWait wait5 = new WebDriverWait(driver, 40);
		WebElement clickAdd = wait5
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickAdd);

	}

	public boolean doubleClick(String day3) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day3 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickEmptyCell(String starttime, String endtime) throws InterruptedException {

		startTime.sendKeys(starttime);
		endTime.sendKeys(endtime);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement preferredOff = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='type']/label[1]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", preferredOff);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickAdd = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickAdd);
	}

	public boolean rightClick(String day4) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day4 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).contextClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	public void clickAddShift(String editStart, String editEnd) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement addShift = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Add Availability']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addShift);

		startTime.sendKeys(Keys.CONTROL + "a");
		startTime.sendKeys(Keys.DELETE);
		startTime.sendKeys(editStart);

		endTime.sendKeys(Keys.CONTROL + "a");
		endTime.sendKeys(Keys.DELETE);
		endTime.sendKeys(editEnd);

		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement preferredOff = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='type']/label[2]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", preferredOff);
		Thread.sleep(4000);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickAdd = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickAdd);
	}

	public boolean doubleClick1(String day3) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day3 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).doubleClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickEmptyCell1(String starttime, String endtime) throws InterruptedException {

		startTime.sendKeys(starttime);
		endTime.sendKeys(endtime);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement AvailableToWork = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='type']/label[3]/span[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AvailableToWork);

		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickAdd = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickAdd);

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
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement labor = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//span[text()='Labor']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labor);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement scheduling = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//li[@title='Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduling);
	}

	public boolean retryingFindClick() throws InterruptedException {
		driver.switchTo().frame(frame);
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
				das.click();
				Thread.sleep(4000);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}

	public void selectDateRange(String filterJob,String date, String dynamicName) throws InterruptedException {
		 Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-btn-icon-only']/i[@aria-label='icon: minus-square-o']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='ant-btn ant-btn-icon-only']/i[@aria-label='icon: arrows-alt']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
        Thread.sleep(2000);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(filterJob)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
		
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement element4 = wait3.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);
		WebDriverWait wait6 = new WebDriverWait(driver, 40);
		WebElement date1 = wait6.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='unifocus-selectdropdown ant-select ant-select-enabled']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", date1);
		WebDriverWait wait7 = new WebDriverWait(driver, 40);
		WebElement dateRange = wait7
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='"+date+"']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateRange);
		WebDriverWait wait5 = new WebDriverWait(driver, 40);
		WebElement element5 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='uf-employee-label-container line-clamp'][normalize-space()='" + dynamicName + "']")));
		Coordinates cor1 = ((Locatable) element5).getCoordinates();
		cor1.inViewPort();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);
		String name = element5.getText();
		System.out.println(name);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		WebElement close = driver.findElement(
				By.xpath("//div[@class='ant-tabs-nav-container']//div[2]//div[1]//i[@aria-label='icon: close']"));
		close.click();
	}

	public void selectEmployee1(String empId) throws InterruptedException {
		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement searchEmp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Name or EmpID')]")));
		Thread.sleep(8000);
		// searchEmp.click();
		searchEmp.clear();
		searchEmp.sendKeys(empId);
		Thread.sleep(6000);
		empName.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement scheduling = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduling);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement addShift = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//section[1]/div[1]/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addShift);

	}

	public void selectCheckBoxs1(String starttime, String endtime, String day5, String day6, String day7, String day8)
			throws InterruptedException {

		startTime.sendKeys(starttime);
		endTime.sendKeys(endtime);
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size = checkBoxes.size();
		for (int i = 0; i < size; i++) {

			String value = checkBoxes.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day5)) {

				checkBoxes.get(i).click();
				Thread.sleep(4000);
				break;

			}
		}

		List<WebElement> checkBoxes2 = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size2 = checkBoxes2.size();
		for (int i = 0; i < size2; i++) {

			String value = checkBoxes2.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day6)) {

				checkBoxes2.get(i).click();
				Thread.sleep(4000);
				break;

			}

		}
		List<WebElement> checkBoxes3 = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size3 = checkBoxes3.size();
		for (int i = 0; i < size3; i++) {

			String value = checkBoxes3.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day7)) {

				checkBoxes3.get(i).click();
				Thread.sleep(4000);
				break;

			}

		}
		List<WebElement> checkBoxes4 = driver.findElements(By.xpath("//div[@id='days']/label/span/input"));
		int size4 = checkBoxes4.size();
		for (int i = 0; i < size4; i++) {

			String value = checkBoxes4.get(i).getAttribute("value");

			if (value.equalsIgnoreCase(day8)) {

				checkBoxes4.get(i).click();
				Thread.sleep(4000);
				break;

			}

		}

		WebElement overRide = driver.findElement(By.xpath("//input[@id='override']"));
		Thread.sleep(6000);
		overRide.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement clickAdd = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		Thread.sleep(4000);
		clickAdd.click();
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement ok = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-modal-body']//button[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

	}

	public boolean clickDayShift(String day9) throws InterruptedException {

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day9 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickEdit(String starttime, String endtime) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement editShift = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//section[@class='unifocus-section invisible']//section[1]//div[1]//div[1]//div[1]//div[1]//button[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editShift);

		startTime.sendKeys(Keys.CONTROL + "a");
		startTime.sendKeys(Keys.DELETE);
		startTime.sendKeys(starttime);
		Thread.sleep(4000);
		endTime.sendKeys(Keys.CONTROL + "a");
		endTime.sendKeys(Keys.DELETE);
		endTime.sendKeys(endtime);
		Thread.sleep(4000);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement save = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);

	}

	public boolean clickShiftDay(String day10) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day10 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).click().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickDeleteSelectedShifts() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement delete = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//section[@class='unifocus-section invisible']//section[1]//div[1]//div[1]//div[1]//div[1]//button[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);

		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement DeleteShift = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space()='Delete Selected Availability']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DeleteShift);

		WebDriverWait wait4 = new WebDriverWait(driver, 40);
		WebElement clickOk = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOk);
	}

	public boolean clickDeleteShift(String day11) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.switchTo().activeElement();
				Actions action = new Actions(driver);
				WebElement doubleClick = driver.findElement(By.xpath(
						"//section[1]//div//div[3]//div//div//div//div//div[2]//div[1]//div[3]//div[2]//div/div//div[@role='row'][@row-index='0'][@aria-rowindex='2']//div[@col-id='"
								+ day11 + "']"));
				Thread.sleep(2000);
				action.moveToElement(doubleClick).contextClick().build().perform();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickDelete() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement Delete = wait1.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Delete Availability']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Delete);
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement ok = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
	}

	public void clickDeleteAllShifts() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		WebElement delete = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//section[@class='unifocus-section invisible']//section[1]//div[1]//div[1]//div[1]//div[1]//button[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);

		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement DeleteShift = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space()='Delete All Availability']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DeleteShift);

		WebDriverWait wait4 = new WebDriverWait(driver, 40);
		WebElement clickOk = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOk);

	}

	public void clickRefreshButton() throws InterruptedException {
		clickUnifocus();
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement refresh = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn action-button ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", refresh);
		Thread.sleep(4000);

	}
}
