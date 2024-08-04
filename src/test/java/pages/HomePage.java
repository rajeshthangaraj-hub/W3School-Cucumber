package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#search2")		
	WebElement search;
		
	@FindBy(css="a[href='/python/python_lists.asp']")
	WebElement python_lists;
	
	@FindBy(css="a[href='/python/python_arrays.asp']")
	WebElement python_arrays;
	
	@FindBy(xpath="(//a[@title='Certificates'])[1]")
	WebElement certMenu;
	
	@FindBy(xpath="(//a[@title='Java Certification Exam'])[2]")
	WebElement certJava;
	
	@FindBy(xpath="(//a[@title='Python Certification Exam'])[2]")
	WebElement certPython;
	
	@FindBy(xpath="(//a[@title='Paid Data Analytics Course'])[2]")
	WebElement courseDataAnal;	

    
    public void clickCert(String language){
    	
        Map<String,WebElement> map = new HashMap<>();
        
        map.put("Data Analytics", courseDataAnal);
        map.put("Java", certJava);
        map.put("Python", certPython);
        
        WebElement element = map.get(language);
        if (element != null) {
                element.click();
              } 
        else {
        throw new RuntimeException("No matching language found");
   } }
  
	
	public void searchTutorial(String tutorial) {
		
		search.sendKeys(tutorial);
	
	}
	
	public void clickSearchResult(String result) {
		
		if(result.equalsIgnoreCase("lists")) {
			
			python_lists.click();
			
		}else if(result.equalsIgnoreCase("arrays")){
			
			python_arrays.click();
			
		}else{
			
			throw new RuntimeException("No such element found : " + result);
		}
		
	}
	
	public void clickCertificateMenu() { 
		
		certMenu.click();
	}
	

	}

