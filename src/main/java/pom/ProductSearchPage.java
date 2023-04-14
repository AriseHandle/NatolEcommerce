package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	@FindBy (xpath = "//div[@class='grid_Square ']") private List<WebElement> products;
	@FindBy (xpath = "//div[@class='item_title']//a") private List<WebElement> productName;	
	@FindBy (xpath = "//span[text()='Quick View']") private List<WebElement> quickView;
	
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfDisplayedProducts(WebDriver driver) {
		int size =products.size();
		return size;
	}
	
	public void selectProduct(int index) {
		products.get(index).click();
	}
	
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	
	public void moveMouseToProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	
	public void clickOnQuickView(int index) {
		quickView.get(index).click();
	}
}
