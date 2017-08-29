package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

private WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,  this);
	}
	
	@FindBy(id="lst-ib")
	public WebElement searchInput;
}
