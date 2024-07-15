package gianluca.pageobject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gianluca.AbstractComponent.ComponentAbstract;


public class LandingPage extends ComponentAbstract {

	WebDriver driver;

	// costruttore
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);// indichiamo il driver alle annotazioni
		// inizializza gli elemnti
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail") // trova lid selezionato
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement subMitClick;
	
	
	//div[@class='invalid-feedback']
			//.top-tab
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductCatalog loginApplications(String email, String passwordLogin) {
		userEmail.sendKeys(email);
		password.sendKeys(passwordLogin);
		subMitClick.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;
	}
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage) ;
		return errorMessage.getText();
		
	}

}// close class
