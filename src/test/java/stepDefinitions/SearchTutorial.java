package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utils.DependencyInjection;

public class SearchTutorial {
	
	public DependencyInjection depIn;
	
	public SearchTutorial(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	

@Given("user is on home page")
public void user_is_on_home_page() {

	
	// Assert.assertTrue(depIn.driver.getTitle().contains("W3Schools"));
	
}
@When("user click on search box and type {string}")
public void user_click_on_search_box_and_type(String tutorial) {

	depIn.pageObjectManager.getHomePage().searchTutorial(tutorial);
}

@When("select {string} from the recommended search dropdown")
public void select_from_the_recommended_search_dropdown(String result) {

	depIn.pageObjectManager.getHomePage().clickSearchResult(result);
}

@Then("user should land on {string} {string} tutorial page")
public void user_should_land_on_java_tutorial_page(String tutorial,String result) throws IOException {

	String title = depIn.basePage.WebDriverManager().getTitle();
	
	if(title.contains(result)) {
		
		System.out.println("user is on"+tutorial+result+"page");
	}
}

@When("user click on Try it Yourself")
public void user_click_on_Try_it_Yourself() {
	
	depIn.pageObjectManager.getJavaPage().clickListTryBtn();
	
}


}
