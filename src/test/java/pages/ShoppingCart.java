package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableUtils;

public class ShoppingCart {

	public WebDriver driver;
	public ReusableUtils utils;
	public Actions action;
	
	public ShoppingCart(WebDriver driver,ReusableUtils utils) {
		
		this.driver = driver;
		this.utils=utils;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
	}
	 //iframe[@title='Checkout with PayPal']
	   @FindBy(xpath="iframe[@title='Checkout with PayPal']")
		WebElement payPalbtn;
	   
	   @FindBy(xpath="//iframe[@title='PayPal']")
	   WebElement childFramePayPal;
	   
	   @FindBy(xpath="//div[@id='zoid-paypal-button-d6d3b857bb']")
	   WebElement div1;
	   
	   @FindBy(xpath="//div/button[@name='checkout']")
	   WebElement checkoutBtn;
		
   
	   public void clickPayPalBtn() throws InterruptedException {
			
			utils.waitForElementToBeVisible(payPalbtn).click();			
	
		}
		
		public void clickCheckOutBtn() throws InterruptedException {
			
			utils.waitForElementToBeVisible(checkoutBtn).click();
			
		}
		
		public void scrollToCheckOut() {
			
			action.scrollFromOrigin(ScrollOrigin.fromElement(checkoutBtn), 0, 500).perform();
		}
		
		public void switchToFrame() {
			
			
			 //utils.switchToIframe(childFramePayPal);
			
			driver.switchTo().frame(payPalbtn);
			
			div1.click();
		}
		
	
}
