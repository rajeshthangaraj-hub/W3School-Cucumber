package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DependencyInjection;

public class ChangeTheme {

	public DependencyInjection depIn;
	
	public ChangeTheme(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
	@When("user click on change theme")
	public void When_user_click_on_change_theme() throws InterruptedException {
		
		depIn.pageObjectManager.getEditorPage().ChangeTheme();
		Thread.sleep(5000);
	}

	@Then("editor page should turn dark")
	public void editor_page_should_turn_dark(){
		
		String validateTheme = depIn.pageObjectManager.getEditorPage().validateTheme();
		
		Assert.assertEquals(validateTheme,"darktheme");
	}
	
	@Then("editor page should turn light")
	public void editor_page_should_turn_light(){
		
		String validateTheme = depIn.pageObjectManager.getEditorPage().validateTheme();
		      try {
	    	  
	    	   Assert.assertEquals(validateTheme,"light");
	    	   
	        } catch (AssertionError e) {
	            // Set the failed element in the context
	            WebElement resultElement = depIn.pageObjectManager.getEditorPage().themeElement();
	            
	            depIn.setFailedElement(resultElement);
	            throw e; // Re-throw the exception to mark the step as failed
	        }
	}
	
	
	
	
}
