package com.automationtesting.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.automationtesting.basetest.BaseTest;
import com.automationtesting.pages.BasketPage;
import com.automationtesting.pages.CheckOutPage;
import com.automationtesting.pages.HomePage;
import com.automationtesting.pages.ProductDisplayPage;
import com.automationtesting.pages.SearchResultsPage;
import com.automationtesting.util.DataUtil;
import com.aventstack.extentreports.Status;

public class PlaceOrderTest extends BaseTest {

	@Test(priority = 2)
	public void placeOrder() throws InterruptedException {
		test = extent.createTest("placeOrder", "Placing an order in Automating Testing Practice Site.");

		if (!DataUtil.isTestExecutable(xls, "placeOrder")) {
			test.log(Status.SKIP, "Skipping the test as RunMode is N");
			throw new SkipException("Skipping the test as RunMode is N");
		}

		HomePage homePage = new HomePage(driver, test);
		PageFactory.initElements(driver, homePage);
		SearchResultsPage searchResultsPage = homePage.searchBook();
		logIntoReport("Searched the desired book");
		ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
		logIntoReport("Clicked on searched book");
		BasketPage basketPage = productDisplayPage.navigateToBasketPage();
		logIntoReport("Navigated to basket page");
		CheckOutPage checkoutPage = basketPage.proceedToCheckout();
		logIntoReport("Navigated to proceed checkout page");
		checkoutPage.placeOrder();
		logIntoReport("Placed the order");
	}

	@Test
	public void carousel() {
		test = extent.createTest("carousel", "Verify only 3 images are in HomePage.");

		verifyTitle("Title");

		if (!DataUtil.isTestExecutable(xls, "carousel")) {
			test.log(Status.SKIP, "Skipping the test as RunMode is N");
			throw new SkipException("Skipping the test as RunMode is N");
		}

		logIntoReport("This is to test carousel functionality");
	}
}
