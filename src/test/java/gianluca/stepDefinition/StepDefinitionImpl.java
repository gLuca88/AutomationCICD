package gianluca.stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import gianluca.TestComponents.BaseTest;
import gianluca.pageobject.CartPage;
import gianluca.pageobject.CheckOutPage;
import gianluca.pageobject.ConfirmationPage;
import gianluca.pageobject.LandingPage;
import gianluca.pageobject.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationPage;

	@Given("navigo sulla pagina Ecommerce")
	public void navigo_sulla_pagina_Ecommerce() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^io faccio il login con userName (.+) e password (.+)$")//cappello all'inizio stringa e $ alla fine indichiamo che è dinamica
	public void io_faccio_il_login_con_userName_e_password(String userName,String password) 
	{
	  productCatalog = landingPage.loginApplications(userName,password);
	}
	
	@When("^aggiungo un prodotto (.+) al carrello$")
	public void aggiungo_un_prodotto_al_carrello(String nomeProdotto) throws InterruptedException
	{
		productCatalog.addProductCart(nomeProdotto);
	}
	@And("^vado nel carrello controllo presenza (.+) e clicco acquista$")
	public void vado_nel_carrello_controllo_presenza_e_clicco_acquista$(String nomeProdotto) 
	{
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verificaPresenzaProdottoCart(nomeProdotto);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("Italy");
		confirmationPage = checkOutPage.subMitOrder();
	}
	@Then("{string} verifico messagio di conferma")
	public void verifico_messagio_di_conferma(String messaggio) 
	{
		String messaggioConferma=confirmationPage.getConfirmationMex();
		Assert.assertTrue(messaggioConferma.equalsIgnoreCase(messaggio));
		driver.close();
	}
	
    
	@Then("{string} verifico messagio di conferma errore")
    public void verifico_messagio_di_conferma_errore(String messaggio) {
		Assert.assertEquals(messaggio, landingPage.getErrorMessage());
		driver.close();
    }
	
	

}// close class
