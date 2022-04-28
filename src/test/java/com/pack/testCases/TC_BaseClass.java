package com.pack.testCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import com.pack.loginPages.C27428;
import com.pack.loginPages.TestRailManager;
import com.pack.utils.ReadConfig;
import com.pack.utils.XLUtils;

import recordingTests.ScreenRecorderUtil;

public class TC_BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String url = readconfig.getApplicationUrl();
	public String partnerCode = readconfig.getPartnerCode();
	public String loginas = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	protected String TestCase_ID;
	public static Logger logger;

	@SuppressWarnings("deprecation")
	@Parameters("browser")

    @BeforeMethod
	public void setup(String browser) throws Exception {
		logger = logger.getLogger("unifocusScheduler");
		PropertyConfigurator.configure("log.properties.txt");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		if(result.getStatus()==ITestResult.SUCCESS) {
			TestRailManager.addResultForTestCase(TestCase_ID, TestRailManager.TEST_CASE_PASSED_STATUS, "");	
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
		ScreenRecorderUtil.stopRecord();
		TestRailManager.addResultForTestCase(TestCase_ID, TestRailManager.TEST_CASE_FAILED_STATUS, "");	
		}
		driver.quit();
	}
	
}
