package com.pack.generictest;

import com.pack.employeemaintenancetestcases.TC_BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("deprecation")
public class C27503 extends TC_BaseClass {
	WebDriver ldriver;

	public C27503(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "app-iframe")
	WebElement frame;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/button[1]")
	WebElement unifocus;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-active ant-tabs-tab']//div//i[@aria-label='icon: close']//*[name()='svg']")
	WebElement close;
	@FindBy(xpath = "//span[text()='Labor']")
	WebElement labor;
	@FindBy(xpath = "//li[@title='Actuals']")
	WebElement actuals;
	@FindBy(xpath = "//li[@title='Planning']")
	WebElement planning;
	@FindBy(xpath = "//li[@title='Re-Project Labor']")
	WebElement reProjectLabor;
	@FindBy(xpath = "//li[@title='Scheduling']")
	WebElement scheduling;
	@FindBy(xpath = "//li[@title='Employee Requests']")
	WebElement employeeRequests;
	@FindBy(xpath = "//li[@title='Timeline Scheduling']")
	WebElement timeLineScheduling;

	public void setPartnerCode(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement partnerCode = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@class='x-input-el x-form-field x-input-text']")));
		partnerCode.sendKeys(pc);
	}

	public void clickNext() {
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
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
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
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
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement clickDB = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='ant-btn database-chooser-button singularity-button-no-box-shadow ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickDB);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement DB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + db + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DB);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement doral = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='" + dbName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doral);
		WebDriverWait wait3 = new WebDriverWait(driver, 240);
		WebElement ok = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);
		WebDriverWait wait4 = new WebDriverWait(driver, 240);
		WebElement rms = wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='" + module + "']")));
		rms.click();
	}

	public void clickUnifocus() {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement unifocus = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", unifocus);
		String un = unifocus.getText();
		System.out.println(un);
		Assert.assertEquals("UniFocus", un);
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement labor = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Labor']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", labor);
	}

	public void clickEnterActualEnvironments() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement actual = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Actuals']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actual);
		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement mn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='ant-timeline']/div[1]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		a.moveToElement(mn).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actuals = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actuals);
		Thread.sleep(10000);
		/*driver.switchTo().frame(frame);
		WebElement multipleKBIs = driver.findElement(By.xpath("//button//span[text()='Multiple KBIs/Days']"));
		String multiple = multipleKBIs.getText();
		System.out.println(multiple);
		Assert.assertEquals("Multiple KBIs/Days", multiple);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterActualKBIs() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement actuals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Actuals']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actuals);

		driver.switchTo().frame(frame);
		WebDriverWait wait3 = new WebDriverWait(driver, 240);
		WebElement mn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='ant-timeline']/div[4]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		a.moveToElement(mn).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(10000);
		/*driver.switchTo().frame(frame);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		WebElement actualKBIs = driver.findElement(By.xpath("//h4[normalize-space()='Actuals Week']"));
		String multiple = actualKBIs.getText();
		System.out.println(multiple);
		Assert.assertEquals("Actuals Week", multiple);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterEmployeeProductivity() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement actuals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Actuals']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actuals);

		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement mn = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='ant-timeline']/div[5]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) mn).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(mn).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(10000);
	/*	driver.switchTo().frame(frame);

		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Job']"));
		String multiple = job.getText();
		System.out.println(multiple);
		Assert.assertEquals("Job", multiple);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterActualHours() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement actuals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Actuals']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actuals);

		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement mn = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='ant-timeline']/div[8]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) mn).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(mn).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}

		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
	/*	driver.switchTo().frame(frame);
		
		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Actuals Period']"));
		String multiple = job.getText();
		System.out.println(multiple);
		Assert.assertEquals("Actuals Period", multiple);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickPlanning() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement planning = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Planning']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", planning);

		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement quickView = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Quick View']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickView);
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement listView = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='List View']")));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", listView);

	}

	public boolean retryingFindClick() throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait3 = new WebDriverWait(driver, 180);
				WebElement EnterScheduledHours = wait3.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@class='ant-timeline']/div[13]/div/div[2]/div/i")));
				Actions a = new Actions(driver);
				Coordinates cor = ((Locatable) EnterScheduledHours).getCoordinates();
				cor.inViewPort();
				Thread.sleep(1000);
				a.moveToElement(EnterScheduledHours).build().perform();
				Thread.sleep(3000);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void clickForecastEnvironments() throws InterruptedException {
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,180);
		WebElement mn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='In Progress'])[1]")));
		Coordinates cor = ((Locatable) mn).getCoordinates();
		cor.inViewPort();
		a.moveToElement(mn).click().build().perform();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, 240);
		WebElement update = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Update'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",update);
		/*
		WebDriverWait wait1 = new WebDriverWait(driver,120);
		WebElement industries = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li")));
		Actions an = new Actions(driver);
		an.moveToElement(industries).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = industries.findElements(By.tagName("li"));
		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}*/
		//div[4]/div/div/ul[@role='menu']
	
		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(2000);
       /* driver.switchTo().frame(frame);
        
		WebElement multipleKBIs = driver.findElement(By.xpath("//button//span[text()='Multiple KBIs/Days']"));
		String multiple = multipleKBIs.getText();
		System.out.println(multiple);
		Assert.assertEquals("Multiple KBIs/Days", multiple);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterPreWork() throws InterruptedException {
		clickPlanning();
		WebDriverWait wait2 = new WebDriverWait(driver, 180);
		WebElement EnterPreWork = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div/ul[@class='ant-timeline']/div[2]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		a.moveToElement(EnterPreWork).click().build().perform();

		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebDriverWait wait21 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait21.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(2000);
        /*driver.switchTo().frame(frame);
        
		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Planning Period']"));
		String planningPeriod = job.getText();
		System.out.println(planningPeriod);
		Assert.assertEquals("Planning Period", planningPeriod);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterInputKBIForecast() throws InterruptedException {
		clickPlanning();
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement EnterInputKBIForecast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div/ul[@class='ant-timeline']/div[4]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) EnterInputKBIForecast).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(EnterInputKBIForecast).click().build().perform();
		driver.switchTo().activeElement();

		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}

		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(10000);
		/*driver.switchTo().frame(frame);
		
		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Planning Period']"));
		String planningPeriod = job.getText();
		System.out.println(planningPeriod);
		Assert.assertEquals("Planning Period", planningPeriod);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickViewEditRoomsForecast() throws InterruptedException {
		clickPlanning();
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement EditRevenueCenterForecast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[2]/div/div//ul[@class='ant-timeline']/div[6]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) EditRevenueCenterForecast).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(EditRevenueCenterForecast).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}

		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(10000);
		/*driver.switchTo().frame(frame);
		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Planning Period']"));
		String planningPeriod = job.getText();
		System.out.println(planningPeriod);
		Assert.assertEquals("Planning Period", planningPeriod);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickManageSchedules() throws InterruptedException {
		clickPlanning();
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement ManageSchedules = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[2]/div/div//ul[@class='ant-timeline']/div[12]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) ManageSchedules).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(ManageSchedules).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}

		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(10000);
		/*driver.switchTo().frame(frame);
		
		WebDriverWait wait3 = new WebDriverWait(driver, 120);
		WebElement s = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Select']")));
		String Select =s.getText();
		System.out.println(Select);
		Assert.assertEquals("Select", Select);
		*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEnterScheduledHours() throws InterruptedException {
		clickPlanning();
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement EnterScheduledHours = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[2]/div/div//ul[@class='ant-timeline']/div[13]/div/div[2]/div/i")));
		Actions a = new Actions(driver);
		Coordinates cor = ((Locatable) EnterScheduledHours).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		a.moveToElement(EnterScheduledHours).click().build().perform();
		driver.switchTo().activeElement();
		List<WebElement> start = driver.findElements(By.xpath(
				"//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li"));

		for (int i = 0; i <= start.size() - 1; i++) {
			if (start.get(i).getText().contains("Start")) {
				Thread.sleep(4000);
				start.get(i).click();
				break;
			} else if (start.get(i).getText().contains("Update")) {
				start.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebDriverWait wait2 = new WebDriverWait(driver, 240);
		WebElement actualsclose = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div/div/section/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/div/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actualsclose);
		Thread.sleep(2000);
		/*driver.switchTo().frame(frame);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement job = driver.findElement(By.xpath("//h4[normalize-space()='Scheduled Period']"));
		String scheduledPeriod = job.getText();
		System.out.println(scheduledPeriod);
		Assert.assertEquals("Scheduled Period", scheduledPeriod);*/
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickReProjectLabor() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement reProjectLabor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Re-Project Labor']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", reProjectLabor);
		driver.switchTo().frame(frame);

		driver.switchTo().activeElement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ProjectedHours = driver.findElement(By.xpath("//button/span[text()='Generate Projected Hours']"));
		String scheduledPeriod = ProjectedHours.getText();
		System.out.println(scheduledPeriod);
		Assert.assertEquals("Generate Projected Hours", scheduledPeriod);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickScheduling() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement scheduling = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", scheduling);
		driver.switchTo().frame(frame);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement employeeSchedules = driver.findElement(By.xpath("//h1[@title='Employee Schedules']"));
		String scheduledPeriod = employeeSchedules.getText();
		System.out.println(scheduledPeriod);
		Assert.assertEquals("Employee Schedules", scheduledPeriod);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickEmployeeRequests() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement employeeRequests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Employee Requests']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeRequests);
		driver.switchTo().frame(frame);
		WebDriverWait kbi = new WebDriverWait(driver, 180);
		WebElement addRequest = kbi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[text()=' Add Request']")));
		String scheduledPeriod = addRequest.getText();
		System.out.println(scheduledPeriod);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickShiftRequests() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement employeeRequests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Employee Requests']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeRequests);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 180);
		WebElement addRequest = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Shift Requests']")));
		Thread.sleep(6000);
		addRequest.click();
		WebDriverWait kbi = new WebDriverWait(driver, 180);
		WebElement shifts = kbi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Shift Start (Soonest First)']")));
		String shift = shifts.getText();
		System.out.println(shift);
		Assert.assertEquals("Shift Start (Soonest First)", shift);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickCallIns() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement employeeRequests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Employee Requests']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeRequests);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement callIns = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Call Ins']")));
		Thread.sleep(4000);
		callIns.click();
		driver.switchTo().activeElement();
		WebDriverWait kbi = new WebDriverWait(driver, 180);
		WebElement filter = kbi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Call In Date (Oldest First)']")));
		String shift = filter.getText();
		System.out.println(shift);
		Assert.assertEquals("Call In Date (Oldest First)", shift);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickAvailabilityRequests() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement employeeRequests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Employee Requests']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeRequests);
		driver.switchTo().frame(frame);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		WebElement avalability = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Availability']")));
		Thread.sleep(4000);
		avalability.click();
		driver.switchTo().activeElement();
		WebDriverWait kbi = new WebDriverWait(driver, 180);
		WebElement EnteredonDate = kbi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Entered on Date (Oldest First)']")));
		String shift = EnteredonDate.getText();
		System.out.println(shift);
		Assert.assertEquals("Entered on Date (Oldest First)", shift);
		driver.switchTo().defaultContent();
		close.click();
	}

	public void clickTimeLineScheduling() throws InterruptedException {
		clickUnifocus();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement timeLineScheduling = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Timeline Scheduling']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", timeLineScheduling);
		driver.switchTo().frame(frame);
		driver.switchTo().activeElement();
		WebDriverWait kbi = new WebDriverWait(driver, 180);
		WebElement addShift = kbi.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='title-1086-textEl']")));
		String shift = addShift.getText();
		System.out.println(shift);
		Assert.assertEquals("Select Jobs and Dates", shift);
		driver.switchTo().defaultContent();
		close.click();
	}
}