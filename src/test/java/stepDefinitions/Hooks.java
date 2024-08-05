package stepDefinitions;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.DependencyInjection;

public class Hooks {
	
	public DependencyInjection depIn;
	
	public Hooks(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
//	@After
//	public void afterScenario() throws IOException {
//		
//		depIn.basePage.WebDriverManager().quit();
//	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			
	           try {
	                WebDriver driver = depIn.basePage.WebDriverManager();
	                
	                // Highlight all failed elements using JavaScript
	                List<WebElement> failedElements = depIn.getFailedElement();
	                JavascriptExecutor js = (JavascriptExecutor) driver;

	                for (WebElement element : failedElements) {
	                    js.executeScript("arguments[0].style.border='3px solid red'", element);
	                }

	                // Capture the full screen using Robot class
	                Robot robot = new Robot();
	                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

	                // Convert BufferedImage to byte array
	                ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                ImageIO.write(screenFullImage, "png", baos);
	                byte[] screenshotBytes = baos.toByteArray();

	                // Attach screenshot to scenario
	                scenario.attach(screenshotBytes, "image/png", scenario.getName());

	            } catch (Exception e) {
	                System.err.println("Failed to capture full-page screenshot: " + e.getMessage());
	            } finally {
	                depIn.removeFailedElement();
	            }
	        }
	}

} 
