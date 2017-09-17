package com.automationtesting.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.basepage.BasePage;
import com.automationtesting.repo.Locator;
import com.aventstack.extentreports.ExtentTest;

public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = Locator.SEARCH_TEXTBOX)
	public WebElement searchTextbox;

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public SearchResultsPage searchBook() {

		searchTextbox.sendKeys("selenium");
		logIntoReport("Searching a book title called selenium");
		searchTextbox.sendKeys(Keys.ENTER);
		logIntoReport("Simulated enter key on keyboard");
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver, test);
		PageFactory.initElements(driver, searchResultsPage);
		return searchResultsPage;
	}

}
