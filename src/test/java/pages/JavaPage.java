package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaPage {
	
	WebDriverWait wait;
	public WebDriver driver;
	
	public JavaPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@FindBy(linkText="Next ❯")
	WebElement next;
	
	@FindBy(linkText="Try it Yourself »")
	List<WebElement> tryBtn;

	public void clickListTryBtn() {
		
		tryBtn.get(2).click();
		
	
	 }
	
}

