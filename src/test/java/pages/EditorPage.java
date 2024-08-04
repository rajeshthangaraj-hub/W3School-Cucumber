package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableUtils;

public class EditorPage {
	
	public WebDriver driver;
	public ReusableUtils utils;
	
	public EditorPage(WebDriver driver,ReusableUtils utils) {
		
		this.driver = driver;
		this.utils=utils;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath = "//div[@id='iframewrapper']/div[@id='iframeResult']")
    WebElement result;
	
	@FindBy(xpath="//a[@onclick='retheme()']")
	WebElement theme;
	
	@FindBy(xpath="//body[@class='  darktheme']")
	WebElement darkTheme;
	
	@FindBy(css="body")		
	WebElement body;
	
	public int getResult() {
		
		String str = result.getText().trim();
		
		int actual = Integer.parseInt(str);
		
		return actual;
	}
	
    public WebElement getResultElement() {
    	
    	return utils.waitForElementToBeVisible(result);
         
    }
	

	public void ChangeTheme() {
		
		theme.click();
		
	}
	
	public String validateTheme() {
		
		return utils.waitForElementToBeVisible(body).getAttribute("class").trim();
		
			}
	
	public WebElement themeElement() {
		
		
		return theme;
	}
}


