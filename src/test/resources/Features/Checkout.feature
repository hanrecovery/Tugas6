Feature: Checkout
  Scenario: Checkout by filling in the information according to the format
  Given I Open browser
  And Open website saucedemo
  And Located on saucedemo website
  And I input valid username
  And I input valid password
  When I go to homepage
  And I add to cart a product
  And Product successfully added to cart
  And I press the checkout button
  And I input valid first name
  And I input valid last name
  And I input valid  ZIP-postal code
  And I press the continue button
  Then the order must be successfully processed