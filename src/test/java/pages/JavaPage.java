package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaPage {
	
	public WebDriver driver;
	public Actions action;
	
	public JavaPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
		this.action = new Actions(driver);
		
	}
	
	@FindBy(linkText="Next ❯")
	WebElement next;
	
	@FindBy(linkText="Try it Yourself »")
	List<WebElement> tryBtn;
	
	@FindBy(xpath="//div[@class='footerlinks_1']/a[text()='NEWSLETTER']")
	WebElement footerNewsletter;

	public void clickListTryBtn() {
		
		tryBtn.get(2).click();		
	
	 }
	
	public void ScrollToFooterNewsletter() {
		
		action.scrollFromOrigin(ScrollOrigin.fromElement(footerNewsletter),0,200).perform();
		
	}
	
	public void clickNewsletter() {
		
		footerNewsletter.click();
	}
	
}

