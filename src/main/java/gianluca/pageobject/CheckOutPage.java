package gianluca.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gianluca.AbstractComponent.ComponentAbstract;

public class CheckOutPage extends ComponentAbstract {
	WebDriver driver; 
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}//close constructor
	
	@FindBy(css=".totalRow button")
	WebElement buttonAcquista;
	
	public void procediAcquisto() {
		buttonAcquista.click();
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement inputNazionalita;
	
	By locatorsDinamicoNazionalita=By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[1]");
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[1]")
	WebElement campoDinamico;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement subMit;
	
	public void selectCountry(String paese) 
	{
		inputNazionalita.sendKeys("Italy");	
		waitForElemntToAppear(locatorsDinamicoNazionalita);
		campoDinamico.click();
		
				
	}
	@FindBy(css=".hero-primary")
	WebElement campoTestoPagAcquisto;
	public String verificaText() {
		
		
	 return campoTestoPagAcquisto.getText();
	
		
	}
	public ConfirmationPage subMitOrder() {
		subMit.click();
		return new ConfirmationPage(driver);
	}
     /*
      * usare actions 
      * Actions a =new Actions(driver);
      * a.sendkeyes(WebElemnt,stringaInsetita).build.perform
      */
     
}//close class
