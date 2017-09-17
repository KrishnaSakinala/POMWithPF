package com.automationtesting.basepage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;

	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void verifyText(WebElement locator, String text) {
		Assert.assertEquals(locator.getText(), text);
	}

	public void logIntoReport(String logInfo) {
		test.info(MarkupHelper.createLabel(logInfo, ExtentColor.BLUE));
	}

	public void waitUntilElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String generateFirstName() {
		Random r = new Random();
		int i = r.nextInt(200000);
		return "fName" + i;
	}

	public String generatePhoneNumber() {
		Random r = new Random();
		long number = (long) (r.nextDouble() * 10000000000L);
		return Long.toString(number);
	}

}
