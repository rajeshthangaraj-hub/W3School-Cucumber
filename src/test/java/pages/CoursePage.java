package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ReusableUtils;

public class CoursePage {

	public WebDriver driver;
	public ReusableUtils utils;
	
	public CoursePage(WebDriver driver,ReusableUtils utils) {
		
		this.driver = driver;
		this.utils=utils;
		PageFactory.initElements(driver, this);
	}
	
			
	@FindBy(xpath="(//span[@class='sls-custom-radio'])[2]")
	WebElement paymentPlan;
	
	@FindBy(xpath="//select[@name='subs_interval']")
	WebElement choosePlan;
	
	@FindBy(xpath="//button/span[@class='atc-button--text']")
	WebElement buyNowbtn;
	


	public void choosePlan(String plan) {
		
		Select select = new Select(choosePlan);
		
		select.selectByVisibleText(plan);
	}
	
	public void clickOnPaymentPlan(){
		
		WebElement waitForElementToBeVisible = utils.waitForElementToBeVisible(paymentPlan);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitForElementToBeVisible);
		
	}
	
	public void clickOnBuyNowbtn() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyNowbtn);
	}
	
	
	
}
