Feature: Cart
  Scenario: Successful add cart
    Given I Open browser
    And Open website saucedemo
    And Located on saucedemo website
    And I input valid username
    And I input valid password
    When I go to homepage
    And I add to cart a product
    Then Product successfully added to cart