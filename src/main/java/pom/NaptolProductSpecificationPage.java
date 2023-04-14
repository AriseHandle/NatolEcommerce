package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolProductSpecificationPage {
	@FindBy(xpath="//a[@id='cart-panel-button-0']") private WebElement clickHearToBuy;
	@FindBy(xpath = "(//ul[@id='color_box_0']//li)[1]") private WebElement colour;
	
	
	public NaptolProductSpecificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void ClickOnClickHearToBuyOption()
	{
		try
		{
			colour.click();
		}
		catch (Exception e) {
			System.out.println("Colour option not available");
		}
		clickHearToBuy.click();
	}
	
	
}

