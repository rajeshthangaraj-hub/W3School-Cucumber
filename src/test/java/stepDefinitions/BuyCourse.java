package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DependencyInjection;

public class BuyCourse {

	public DependencyInjection depIn;
	
	public BuyCourse(DependencyInjection depIn) {
		
		this.depIn = depIn;
	}
	
	@When("click on payment plans under purchase options")
	public void click_on_payment_plan() {
		
		depIn.pageObjectManager.getCoursePage().clickOnPaymentPlan();
	}
	@When("choose {string} plan")
	public void choose_plan(String plan) {
		depIn.pageObjectManager.getCoursePage().choosePlan(plan);
	}
	
	@When("click on buy now button")
	public void click_buy_now() throws InterruptedException {
		
		depIn.pageObjectManager.getCoursePage().clickOnBuyNowbtn();
		
	}
	
	@Then("user should navigate to {string} page")
	public void get_title_page(String title) {
		
		Assert.assertTrue(depIn.reusableUtils.waitForPageTitle(title));
		
	}
	
	@Then("click on paypal button")
	public void click_paypal_btn() throws InterruptedException {
		
		depIn.pageObjectManager.getShoppingCartPage().clickCheckOutBtn();
	}
}
