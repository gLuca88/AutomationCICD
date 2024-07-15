
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background:
  Given  navigo sulla pagina Ecommerce

  @Regression
  Scenario Outline: Test positivo acquisto prodotto
  
  
    Given io faccio il login con userName <userName> e password <password> 
    When  aggiungo un prodotto <NomeProdotto> al carrello
    And   vado nel carrello controllo presenza <NomeProdotto> e clicco acquista
    Then  "THANKYOU FOR THE ORDER." verifico messagio di conferma

    Examples: 
      | userName                    | password          | NomeProdotto           |
      | radescagianluca88@gmail.com | Gianluca88!       | ADIDAS ORIGINAL        |
      
