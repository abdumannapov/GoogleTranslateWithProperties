package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {
	private WebDriver driver;
	
	public GoogleTranslatePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,  this);
	}

	@FindBy(id="source") 
	WebElement sourceTextField;
	
}
