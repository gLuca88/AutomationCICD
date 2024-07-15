package gianluca.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gianluca.AbstractComponent.ComponentAbstract;

public class ProductCatalog extends ComponentAbstract {

	WebDriver driver;

	// costruttore
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);// indichiamo il driver alle annotazioni
		// inizializza gli elemnti
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products; // gia con l'inizializzazione della lista capisce che si trata di piu elemnti

	By locatorsProdotti = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {

		waitForElemntToAppear(locatorsProdotti);

		return products;

	}

	By locatorsProdotto = By.cssSelector("b");

	public WebElement getProductByName(String nomeProdotto) {
		WebElement prodottoCercato = getProductList().stream()
				.filter(prodotto -> prodotto.findElement(locatorsProdotto).getText().equals(nomeProdotto)).findFirst()
				.orElse(null);
		return prodottoCercato;
	}

	By locatorsAggiungiCarrello = By.cssSelector(".card-body button:last-of-type");
	By locatorsButtonGetCarrello = By.cssSelector("#toast-container");

	@FindBy(css = ".ng-animating")
	WebElement iconaCaricamento;

	public void addProductCart(String nomeProdotto) throws InterruptedException {
		WebElement prod = getProductByName(nomeProdotto);
		prod.findElement(locatorsAggiungiCarrello).click();
		waitForElemntToAppear(locatorsButtonGetCarrello);
		waitForElemntToScompair(iconaCaricamento);
		
	}

}// close class
