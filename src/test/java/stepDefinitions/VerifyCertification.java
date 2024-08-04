package stepDefinitions;

import io.cucumber.java.en.When;
import utils.DependencyInjection;

public class VerifyCertification {

	public DependencyInjection depIn;
	
	public VerifyCertification(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
	
	@When("user click on Certificate menu") 
	public void click_on_certificate_menu() {
		
		depIn.pageObjectManager.getHomePage().clickCertificateMenu();
	}
	@When("Click on {string} Certificate")
	public void click_on_Java_Cert(String language) {
		
		depIn.pageObjectManager.getHomePage().clickCert(language);
		
	}
	
	@When("user switch back to home page")
	public void switch_to_home(){
		
		depIn.reusableUtils.switchToParentWindow();
	}
}
