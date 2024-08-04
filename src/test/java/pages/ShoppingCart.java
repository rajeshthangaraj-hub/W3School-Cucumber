package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableUtils;

public class ShoppingCart {

	
	public WebDriver driver;
	public ReusableUtils utils;
	
	public ShoppingCart(WebDriver driver,ReusableUtils utils) {
		
		this.driver = driver;
		this.utils=utils;
		PageFactory.initElements(driver, this);
	}
	
	   @FindBy(css="li.Vru56DW5IUIiRpxbGTDg")
		WebElement payPalbtn;
	   
	   @FindBy(xpath="//div/button[@name='checkout']")
	   WebElement checkoutBtn;
		
   
	   public void clickPayPalBtn() throws InterruptedException {
			
			utils.waitForElementToBeVisible(payPalbtn).click();			
	
		}
		
		public void clickCheckOutBtn() throws InterruptedException {
			
			utils.waitForElementToBeVisible(checkoutBtn).click();
			
		}
		
	
}
