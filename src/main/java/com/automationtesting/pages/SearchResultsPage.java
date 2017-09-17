package com.automationtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.basepage.BasePage;
import com.automationtesting.repo.Locator;
import com.aventstack.extentreports.ExtentTest;

public class SearchResultsPage extends BasePage {

	@FindBy(how = How.XPATH, using = Locator.SEARCHED_BOOK_TITLE)
	public WebElement searchedBookTitle;

	@FindBy(how = How.XPATH, using = Locator.SEARCH_RESULT_BOOKTITLE)
	public WebElement searchResultBookTitle;

	public SearchResultsPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public ProductDisplayPage clickSearchedBook() {
		verifyText(searchResultBookTitle, "Selenium Ruby");
		logIntoReport("VErified book title");
		searchedBookTitle.click();
		logIntoReport("Clicked on Search book title");
		ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver, test);
		PageFactory.initElements(driver, productDisplayPage);
		return productDisplayPage;
	}
}
