package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.PageObjectManager;

public class DependencyInjection {

	public PageObjectManager pageObjectManager;
	public BasePage basePage;
	public ReusableUtils reusableUtils;
		
	
	public DependencyInjection() throws IOException {
		
		basePage = new BasePage(); // instantiate driver object
		
		WebDriver driver = basePage.WebDriverManager();
		reusableUtils = new ReusableUtils(driver,Duration.ofSeconds(10)); // 10 seconds timeout
		pageObjectManager = new PageObjectManager(driver ,reusableUtils);
	}
	
	
    private ThreadLocal<List<WebElement>> failedElement = ThreadLocal.withInitial(ArrayList::new);

    public List<WebElement> getFailedElement() {
        return failedElement.get();
    }

    public void setFailedElement(WebElement result) {
        failedElement.get().add(result);
    }

    public void removeFailedElement() {
        failedElement.get().clear();
    }
}
