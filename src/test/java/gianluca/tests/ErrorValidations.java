package gianluca.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import gianluca.pageobject.CartPage;
import gianluca.pageobject.ProductCatalog;
import gianluca.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	// password erratae email corretta

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = gianluca.TestComponents.Retry.class)

	public void subMitOrder() throws IOException, InterruptedException {

		landingPage.loginApplications("radescagianluca88@gmail.com", "password1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		// per errore rimuoviamo or dalla stringa attesa

	}// method submitorder

	@Test
	public void ProductErrorValidations() throws InterruptedException {
		Thread.sleep(4000);
		ProductCatalog productCatalog = landingPage.loginApplications("radescagianluca88@gmail.com", "Gianluca88!");
		productCatalog.addProductCart("ZARA COAT 3");
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verificaPresenzaProdottoCart("ZARA COAT 33");
		Assert.assertFalse(match);
	}

	@DataProvider
	public void getData() {

	}

}// class
