package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DependencyInjection;

public class ValidateEditor {
	
	public DependencyInjection depIn;
	
	public ValidateEditor(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
	@When("user should land on {string} page")
	public void user_should_land_new_page(String title) throws IOException, InterruptedException {
		
		Assert.assertTrue(depIn.reusableUtils.switchToWindowByTitle(title));
		//String title = depIn.basePage.WebDriverManager().getTitle();
		//depIn.reusableUtils.waitForPageTitle(title);
		
	}
	
	@Then("validate the result in output")
	public void validate_the_result_output()
	{

		int result = depIn.pageObjectManager.getEditorPage().getResult();
		
		System.out.println(result);
				
	       try {
	    	   Assert.assertEquals(result,4);
	    	   
	        } catch (AssertionError e) {
	            // Set the failed element in the context
	            WebElement resultElement = depIn.pageObjectManager.getEditorPage().getResultElement();
	            
	            depIn.setFailedElement(resultElement);
	            throw e; // Re-throw the exception to mark the step as failed
	        }
			
	}


}
