package gianluca.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gianluca.AbstractComponent.ComponentAbstract;

public class ConfirmationPage extends ComponentAbstract {

WebDriver driver; 
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}//close constructor
	
	@FindBy(css=".hero-primary")
	WebElement campoTestoPagAcquisto;
	public String getConfirmationMex() {
		
		
	 return campoTestoPagAcquisto.getText();
	
		
	}
	
	
}
