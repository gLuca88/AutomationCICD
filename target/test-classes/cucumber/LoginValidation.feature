
@tag
Feature: Error Validations
  I want to use this template for my feature file

 

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
       
       Given  navigo sulla pagina Ecommerce
       Given io faccio il login con userName <userName> e password <password> 
       Then "Incorrect email or password." verifico messagio di conferma errore
    

    Examples: 
      | userName                    | password          |
      | radescagianluca88@gmail.com | Gianluc88!        |
