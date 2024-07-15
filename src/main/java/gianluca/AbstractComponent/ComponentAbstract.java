package gianluca.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gianluca.pageobject.CartPage;
import gianluca.pageobject.OrderPage;

public class ComponentAbstract {

	WebDriver driver;

	public ComponentAbstract(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// metodo visibilta
	public void waitForElemntToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader ;
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
	     OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}

	

	// metodoInvisibilta
	public void waitForElemntToScompair(WebElement el) throws InterruptedException {
		
		Thread.sleep(1000);
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(el))*/
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

}// close class
