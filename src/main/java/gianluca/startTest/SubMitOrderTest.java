package gianluca.startTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import gianluca.pageobject.CheckOutPage;
import gianluca.pageobject.CartPage;
import gianluca.pageobject.LandingPage;
import gianluca.pageobject.ProductCatalog;
import gianluca.pageobject.ConfirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubMitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		String email = "radescagianluca88@gmail.com";
		String password = "Gianluca88!";
		String prodottoR = "ADIDAS ORIGINAL";
		String paese = "Italy";
		String testoattesoDopoAcquisto = "THANKYOU FOR THE ORDER.";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// login applications
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		// aggiungiamo prodotto al catalogo
		ProductCatalog productCatalog = landingPage.loginApplications(email, password);
		// List<WebElement> products=productCatalog.getProductList();
		productCatalog.addProductCart(prodottoR);
		// andiamo alla pagina carrello
		CartPage cartPage = productCatalog.goToCartPage();
		// verifichiamo se il prodotto è stato aggiunto
		boolean match = cartPage.verificaPresenzaProdottoCart(prodottoR);
		Assert.assertTrue(match);
		// andiamo alla pagina pagamento(checkOut)
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry(paese);
		ConfirmationPage confirmationPage = checkOutPage.subMitOrder();
		Assert.assertEquals(testoattesoDopoAcquisto, confirmationPage.getConfirmationMex());

		//

	}// main

}// class
