package pages;

import org.openqa.selenium.WebDriver;

import utils.ReusableUtils;

public class PageObjectManager {
	
	public WebDriver driver;
	public HomePage homePage;
	public JavaPage javaPage;
	public EditorPage editorPage;
	public CoursePage coursePage;
	public ReusableUtils utils;
	public ShoppingCart shoppingCart;
	
	public PageObjectManager(WebDriver driver,ReusableUtils reusableUtils) {
		
		this.driver = driver;
		this.utils = reusableUtils;
			}
	
	public ShoppingCart getShoppingCartPage() {
		
        if (shoppingCart == null) {
        	shoppingCart = new ShoppingCart(driver,utils);
        }
        return shoppingCart;
	}
	
	public CoursePage getCoursePage() {
		
        if (coursePage == null) {
        	coursePage = new CoursePage(driver,utils);
        }
        return coursePage;
	}
	
	public HomePage getHomePage() {
		
        if (homePage == null) {
        	homePage = new HomePage(driver);
        }
        return homePage;
	}
	
	public JavaPage getJavaPage() {
		
        if (javaPage == null) {
        	javaPage = new JavaPage(driver);
        }
        return javaPage;
	}
	
	
	public EditorPage getEditorPage() {
		
        if (editorPage == null) {
            editorPage = new EditorPage(driver,utils);
        }
        return editorPage;
	}
	
}
