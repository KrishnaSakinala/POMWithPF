package com.automationtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automationtesting.basepage.BasePage;
import com.automationtesting.repo.Locator;
import com.aventstack.extentreports.ExtentTest;

public class CheckOutPage extends BasePage {

	@FindBy(how = How.XPATH, using = Locator.FIRST_NAME_TEXTBOX)
	public WebElement firstNameTextbox;

	@FindBy(how = How.XPATH, using = Locator.LAST_NAME_TEXTBOX)
	public WebElement lastNameTextbox;

	@FindBy(how = How.XPATH, using = Locator.EMAIL_TEXTBOX)
	public WebElement eMailTextbox;

	@FindBy(how = How.XPATH, using = Locator.PHONE_TEXTBOX)
	public WebElement phoneTextbox;

	@FindBy(how = How.XPATH, using = Locator.COUNTRY_DROPDOWN)
	public WebElement countryDropdown;

	@FindBy(how = How.XPATH, using = Locator.ADDRESS_TEXTBOX)
	public WebElement addressTextbox;

	@FindBy(how = How.XPATH, using = Locator.CITY_TEXTBOX)
	public WebElement cityTextbox;

	@FindBy(how = How.XPATH, using = Locator.STATE_DROPDOWN)
	public WebElement stateDropdown;

	@FindBy(how = How.XPATH, using = Locator.STATE_SEARCH_TEXTBOX)
	public WebElement stateSearchTextbox;

	@FindBy(how = How.XPATH, using = Locator.ZIP_CODE_TEXTBOX)
	public WebElement zipcodeTextbox;

	@FindBy(how = How.XPATH, using = Locator.CASH_ON_DELIVERY_RADIOBUTTON)
	public WebElement cashOnDeliveryRadioButton;

	@FindBy(how = How.XPATH, using = Locator.PLACE_ORDER_BUTTON)
	public WebElement placeOrderButton;

	public CheckOutPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void placeOrder() {
		firstNameTextbox.sendKeys(generateFirstName());
		logIntoReport("Entered first name");
		lastNameTextbox.sendKeys("Sakinala");
		eMailTextbox.sendKeys("kkabap@gmail.com");
		phoneTextbox.sendKeys(generatePhoneNumber());
		// country
		// write the code here (home work)
		addressTextbox.sendKeys("Hyderabad");
		cityTextbox.sendKeys("Hyderabad");
		// stateDropdown.click();
		// stateSearchTextbox.sendKeys("Telangana");
		// stateSearchTextbox.sendKeys(Keys.TAB);
		zipcodeTextbox.sendKeys("123456");
		cashOnDeliveryRadioButton.click();
		placeOrderButton.click();
	}

}
