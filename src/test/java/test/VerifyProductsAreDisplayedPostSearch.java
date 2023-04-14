package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductSearchPage;

@Listeners(test.Listeners.class)
public class VerifyProductsAreDisplayedPostSearch extends BaseTest {
//public static WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void openBrowser(String browser) {
		 driver =Browser.launchBrowser(browser);
	}
	
	@Test
	public void verifyProductsAreDisplayedForValidSearch() throws InterruptedException {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearchButton();
		
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		int products =productSearchPage.getNumberOfDisplayedProducts(driver);
		System.out.println(products);
	
		Assert.assertTrue(products==0);	
	}
	
	@Test
	public void verifyProductsAreNotDisplayedForInvalidSearch() {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("iphone");
		naptolHomePage.clickOnSearchButton();
		
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		int products =productSearchPage.getNumberOfDisplayedProducts(driver);
		System.out.println(products);
	
		Assert.assertEquals(products,0 );	
	}
	
}
