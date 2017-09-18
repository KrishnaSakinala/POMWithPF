package com.automationtesting.basetest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automationtesting.util.ExcelApiTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public FileInputStream fis = null;
	public Properties prop = null;

	public ExcelApiTest xls = null;

	@BeforeSuite
	public void init() throws Exception {

		xls = new ExcelApiTest(
				System.getProperty("user.dir") + "/src/main/java/com/automationtesting/repo/TestData.xlsx");

		fis = new FileInputStream(
				"/Users/krishnasakinala/hubiC/workspace/POMWPF_Framework/src/com/automationtesting/repo/config.properties");
		prop = new Properties();
		prop.load(fis);

		if (extent == null) {
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/test-output/AutomationTestingSiteReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			extent.setSystemInfo("OS", "Mac Sierra");
			extent.setSystemInfo("Host Name", "Krishna");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Krishna Sakinala");

			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
			htmlReporter.config().setReportName("My Own Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
		}

		if (driver == null) {

			if (prop.get("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/KRISHNA VOLUME/drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (prop.get("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "/KRISHNA VOLUME/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			driver.get(prop.getProperty("siteUrl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public void logIntoReport(String logInfo) {
		test.info(MarkupHelper.createLabel(logInfo, ExtentColor.BLUE));
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.skip(MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}
