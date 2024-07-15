package gianluca.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSoloStandard {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();// il driver verra scaricato automaticamente un base alla versione del
												// browser

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// se si verificano problemi di
																			// sincronizzazione se occupa il sistema
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// acquistare un prodotto con un determinato nome

		// raccogliamo tutti i prodotti in una lista
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> prodotti = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prodottoCercato = prodotti.stream()
				.filter(prodotto -> prodotto.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);
		// iteriamo sull'elenco poi in base al tag b vhe contiene il nome del prodotto
		// facciamo il confronto
		// chiaramente con lo stream su prodotti iteriamo solo all'interno della classe
		// cercata in prodotti
		// find first trova il primo risultato or else null se on ritorna niente metodo
		// di congiunzione
		// click sul borttone add
		prodottoCercato.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// ora prtira dal prodotto la ricerca se ce corrspondenza e andar solo sul
		// bottone del prodotto ricercato
		// anchw se ci sono piu elemnti uguali

		// #toast-container icona prodotto caricato

		// aspettiamo che l'icona di prodotto aggiunto sia visibile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// icona caricamento ng-animating
		// aspettaimo che scompare
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// gli passiamo direttamente il web lemnwt è piu rapido

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	}// close main

}// close class
