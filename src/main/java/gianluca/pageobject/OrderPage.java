package gianluca.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gianluca.AbstractComponent.ComponentAbstract;

public class OrderPage extends ComponentAbstract {

	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}// close constructor
	
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsNames;
	
	public boolean verificaPresenzaProdottoCart(String prod) {

		boolean match = productsNames.stream().anyMatch(p -> p.getText().equals(prod));

		return match;

	}
	
	
}//close class
