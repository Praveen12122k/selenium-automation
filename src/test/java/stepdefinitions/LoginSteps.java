package stepdefinitions;

import base.basepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.util.Objects;

public class LoginSteps {
    basepage base; WebDriver driver; WebDriverWait wait; LoginPage loginPage;
    @Given("User is on login Home page")
    public void applaunch(){
        base=new basepage();
        driver = base.driver;
        wait=base.Expwait();
        loginPage = new LoginPage(driver);
        base.launchwebsite();
    }
    @When("User enters username {string} and password {string}")
    public void validLogin(String username, String password) {
        loginPage.enterusername(username);
        loginPage.enterpassword(password);
        System.out.println("Successfully Entered Credentials");
    }
    @And("Click on login button")
    public void clikcbtn(){loginPage.Clickloginbtn();}

    @Then("User should see login result {string}")
    public void login_result(String result){
        if(Objects.requireNonNull(driver.getCurrentUrl()).contains(result)) {
            Assert.assertTrue(driver.getCurrentUrl().contains("secure"), "User is not redirected to Secure Area");
            Assert.assertTrue(loginPage.Successmsg().isDisplayed(), "Success message is not displayed");
            System.out.println(loginPage.Successmsg().getText());
            base.tearDown();
        } else {
            Assert.assertTrue(loginPage.Invalidmsg().isDisplayed(), "Error message is not displayed");
            // Optionally verify the exact error message text, e.g.
            Assert.assertTrue(loginPage.Invalidmsg().isDisplayed(),"Successfull login");
            System.out.println(loginPage.Invalidmsg().getText());
            base.tearDown();
        }
    }
}
