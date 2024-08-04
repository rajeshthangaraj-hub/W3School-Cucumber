package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {
	
    private WebDriver driver;
    private WebDriverWait wait;
    private String parentWindowHandle;

    public ReusableUtils(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        this.parentWindowHandle = driver.getWindowHandle();
    }
    
    public boolean switchToWindowByTitle(String windowTitle) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                return true;  // Exit the method once the desired window is found
            }
        }
        
        return false;
        //throw new RuntimeException("No window with title: " + windowTitle + " found.");
    }
    
	public void switchToParentWindow() {
		
		driver.switchTo().window(parentWindowHandle);
		
	}
	

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForPageTitle(String title) {
        try {
			wait.until(ExpectedConditions.titleIs(title));
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public void switchToIframe(WebElement iframeElement ) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }
    
    public void switchToDefaultContent()
    {
    driver.switchTo().defaultContent();

    }
    
}
