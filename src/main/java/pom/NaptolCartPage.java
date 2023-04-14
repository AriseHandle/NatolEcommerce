package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaptolCartPage {
	
	@FindBy(xpath="(//a[@onclick='cart.continueShopping()'])[1]") private WebElement ContinueShopping;
	@FindBy(xpath="(//a[@class='red_button2'])[1]") private WebElement ProceedToCheckOut;
	@FindBy(xpath = "//ul[@id='cartData']")private List<WebElement> cartItem;
	@FindBy(xpath = "//a[@title='Close']")private WebElement close;
	@FindBy(xpath = "//a[text()='Remove']")private List<WebElement> remove;
	
	public NaptolCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnContinueShoppingOption()
	{
		ContinueShopping.click();
	}

	public void clickOnProceedToCheckOut()
	{
		ProceedToCheckOut.click();
	}
	
	public void waitForCatToDisplay(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(close));
	}
	
	public int getCartItems() {
		int size = cartItem.size();
		return size;
	}
	
	public void clickOnRemove(int index) {
		remove.get(0).click();
	}
	
	
}
