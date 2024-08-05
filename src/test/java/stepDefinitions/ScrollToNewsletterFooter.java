package stepDefinitions;

import io.cucumber.java.en.When;
import utils.DependencyInjection;

public class ScrollToNewsletterFooter {
	
	public DependencyInjection depIn;
	
	public ScrollToNewsletterFooter(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
	@When("user scroll to {string} section")
	public void user_scroll_to_section(String section) throws InterruptedException {
		
		depIn.pageObjectManager.getJavaPage().ScrollToFooterNewsletter();

	}
	
	@When("click on NEWSLETTER")
	public void click_Newsletter() {
		
		depIn.pageObjectManager.getJavaPage().clickNewsletter();
	}

}
