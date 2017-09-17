package com.automationtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.basepage.BasePage;
import com.automationtesting.repo.Locator;
import com.aventstack.extentreports.ExtentTest;

public class ProductDisplayPage extends BasePage {

	@FindBy(how = How.XPATH, using = Locator.ADDTO_BASKET_BUTTON)
	WebElement addToBasketButton;

	@FindBy(how = How.XPATH, using = Locator.SUCCESS_MESSAGE_LABEL)
	WebElement successMessageLabel;

	@FindBy(how = How.XPATH, using = Locator.VIEW_BASKET_BUTTON)
	WebElement viewBasketButton;

	public ProductDisplayPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public BasketPage navigateToBasketPage() {
		addToBasketButton.click();
		logIntoReport("Clicked on add to basket button");
		viewBasketButton.click();
		logIntoReport("Clicked on view basket button");
		BasketPage basketPage = new BasketPage(driver, test);
		PageFactory.initElements(driver, basketPage);
		return basketPage;
	}

}
