package gianluca.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gianluca.AbstractComponent.ComponentAbstract;

public class CartPage extends ComponentAbstract {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}// close constructor

	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;

	@FindBy(css = ".cartSection h3")
	List<WebElement> listaCarrello;

	By locatorsElemntCart = By.cssSelector(".cartSection h3");

	public List<WebElement> getListCart() {
		waitForElemntToAppear(locatorsElemntCart);
		return listaCarrello;

	}

	public boolean verificaPresenzaProdottoCart(String prod) {

		boolean match = listaCarrello.stream().anyMatch(p -> p.getText().equals(prod));

		return match;

	}

	public CheckOutPage goToCheckOut() {
		checkOutEle.click();
		return new CheckOutPage(driver);
	}

}
