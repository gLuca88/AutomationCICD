package gianluca.tests;


import java.io.IOException;

import java.util.HashMap;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gianluca.pageobject.CheckOutPage;
import gianluca.pageobject.CartPage;
import gianluca.pageobject.ProductCatalog;
import gianluca.pageobject.ConfirmationPage;
import gianluca.pageobject.OrderPage;
import gianluca.TestComponents.BaseTest;

public class SubMitOrderTest2 extends BaseTest {

	String prodottoR = "ADIDAS ORIGINAL";
	String testoattesoDopoAcquisto = "THANKYOU FOR THE ORDER.";

	@Test(dataProvider = "getData", groups = "provaDataProvider",retryAnalyzer=gianluca.TestComponents.Retry.class)
	public void subMitOrder2(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalog productCatalog = landingPage.loginApplications(input.get("email"), input.get("password"));
		// List<WebElement> products=productCatalog.getProductList();
		productCatalog.addProductCart(input.get("prodotto"));
		// andiamo alla pagina carrello
		CartPage cartPage = productCatalog.goToCartPage();
		// verifichiamo se il prodotto è stato aggiunto
		boolean match = cartPage.verificaPresenzaProdottoCart(input.get("prodotto"));
		Assert.assertTrue(match);
		// andiamo alla pagina pagamento(checkOut)
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("Italy");
		ConfirmationPage confirmationPage = checkOutPage.subMitOrder();
		Assert.assertEquals(testoattesoDopoAcquisto, confirmationPage.getConfirmationMex());
	}// method submitorder

	@Test(dependsOnMethods = { "subMitOrder2" })
	public void OrderHistoryTest() throws InterruptedException {
		ProductCatalog productCatalog = landingPage.loginApplications("radescagianluca88@gmail.com", "Gianluca88!");
		OrderPage ordersPage = productCatalog.goToOrderPage();
		Assert.assertTrue(ordersPage.verificaPresenzaProdottoCart(prodottoR));
	}

	/*
	 * @DataProvider public Object getData() {
	 * 
	 * //diamo piu parametri allo stesso test return new Object[][] {
	 * {"radescagianluca88@gmail.com","Gianluca88!","ADIDAS ORIGINAL"},
	 * {"radescagianluca88@gmail.com","Gianluca88!","ZARA COAT 3"} };
	 * 
	 * }
	 */
	/*
	 * // es hash map
	 * 
	 * @DataProvider public Object getData() { HashMap<String, String> map = new
	 * HashMap<String, String>(); map.put("email", "radescagianluca88@gmail.com");
	 * map.put("password", "Gianluca88!"); map.put("prodotto", "ADIDAS ORIGINAL");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "radescagianluca88@gmail.com"); map1.put("password",
	 * "Gianluca88!"); map1.put("prodotto","ZARA COAT 3");
	 * 
	 * return new Object[][] { { map }, { map1 } };
	 * 
	 * }//close method
	 */
	// es file json
	
	@DataProvider
	public Object getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				"E:\\eclipse-workspace_selenium\\SeleniumFrameWorkDesignSez18\\src\\test\\java\\gianluca\\Data\\DatiOrdine.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}// close method

}// class
