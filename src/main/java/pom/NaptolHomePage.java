package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaptolHomePage {

	@FindBy (xpath = "//a[@id='login-panel-link']")private WebElement loginOrRegister;
	@FindBy (xpath = "//a[text()='Track Order']") private WebElement trackOrder;
	@FindBy (xpath = "//div[@onmouseover='javascript:menu.showMainMenu(true)']")private WebElement shoppingCategories;
	@FindBy (xpath = "//input[@id='header_search_text']")private WebElement searchField;
	@FindBy (xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]") private WebElement searchButton;
	@FindBy (xpath = "(//a[@id='cart-panel-link'])[2]")private WebElement cart;
	

	public NaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginOrRegister() {
		loginOrRegister.click();
	}
	
	public void clickOnTrackOrder() {
		trackOrder.click();
	}
	
	public void moveFocusOnShoppingCategory(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(shoppingCategories);
	}
	
	public void enterProductToSearch(String product) {
		searchField.sendKeys(product);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void goToCart() {
		cart.click();
	}
	
	
	
}
