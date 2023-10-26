package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Step {

//LOGIN
    WebDriver driver;
    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open website saucedemo")
    public void openWebsiteSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input empty username")
    public void iInputEmptyUsername() {
        driver.findElement(By.name("user-name")).sendKeys("");
    }

    @And("I input valid password")
    public void iInputValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assert(errorElement.getText().contains(errorMessage));
    }

    @When("I input valid username")
    public void iInputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I go to homepage")
    public void iGoToHomepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
    }

//CART

    @And("I add to cart a product")
    public void iAddToCartAProduct() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Product successfully added to cart")
    public void productSuccessfullyAddedToCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

//CHECKOUT

    @And("I press the checkout button")
    public void iPressTheCheckoutButton() {
        driver.findElement(By.name("checkout")).click();
    }

    @And("I input valid first name")
    public void iInputValidFirstName() {
        driver.findElement(By.name("firstName")).sendKeys("Muhammad");
    }

    @And("I input valid last name")
    public void iInputValidLastName() {
        driver.findElement(By.name("lastName")).sendKeys("Sholihan");
    }

    @And("I input valid  ZIP-postal code")
    public void iInputValidZIPPostalCode() {
        driver.findElement(By.name("postalCode")).sendKeys("123456");
    }

    @And("I press the continue button")
    public void iPressTheButton() {
        driver.findElement(By.name("continue")).click();
    }

    @Then("the order must be successfully processed")
    public void theOrderMustBeSuccessfullyProcessed() {
        driver.findElement(By.name("finish")).isDisplayed();
    }

}
