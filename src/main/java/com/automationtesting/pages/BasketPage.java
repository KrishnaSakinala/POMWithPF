package com.automationtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.basepage.BasePage;
import com.automationtesting.repo.Locator;
import com.aventstack.extentreports.ExtentTest;

public class BasketPage extends BasePage {

	@FindBy(how = How.XPATH, using = Locator.COUPON_SUCCESS_MESSAGE_LABEL)
	WebElement couponSuccessMessageLabel;

	@FindBy(how = How.XPATH, using = Locator.COUPON_CODE_TEXTBOX)
	WebElement couponCodeTextBox;

	@FindBy(how = How.XPATH, using = Locator.APPLY_COUPON_BUTTON)
	WebElement applyCouponButton;

	@FindBy(how = How.XPATH, using = Locator.PROCEEDTO_CHECKOUT_BUTTON)
	WebElement proceedToCheckoutButton;

	public BasketPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public CheckOutPage proceedToCheckout() throws InterruptedException {
		couponCodeTextBox.sendKeys("krishnasakinala");
		applyCouponButton.click();
		// verify successfully applied or not?
		Thread.sleep(5000);
		// waitUntilElementClickable(proceedToCheckoutButton);
		proceedToCheckoutButton.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver, test);
		PageFactory.initElements(driver, checkOutPage);
		return checkOutPage;
	}

}
