package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import base.basepage;

public class LoginTest {
    basepage base; WebDriver driver; WebDriverWait wait; LoginPage loginPage;

    @BeforeMethod
    public void websitelaunch(){
        base=new basepage();
        driver = base.driver;
        wait=base.Expwait();
        loginPage = new LoginPage(driver);
        base.launchwebsite();
    }
    @Test(priority = 1)
    public void validLoginTest() {
        loginPage.enterusername("tomsmith");
        loginPage.enterpassword("SuperSecretPassword!");
        loginPage.Clickloginbtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"), "User is not redirected to Secure Area");
        Assert.assertTrue(loginPage.Successmsg().isDisplayed(),"Unsuccessfull login");
        System.out.println(loginPage.Successmsg().getText());
    }
    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.enterusername("Tmsmith");
        loginPage.enterpassword("SuperSecretPassword!");
        loginPage.Clickloginbtn();
        Assert.assertTrue(loginPage.Invalidmsg().isDisplayed(),"Successfull login");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "User is redirected to Secure Area");
        System.out.println(loginPage.Invalidmsg().getText());
    }
    @Test(priority = 3)
    public void emptyfieldTest() {
        loginPage.Clickloginbtn();
        Assert.assertTrue(loginPage.Invalidmsg().isDisplayed(),"Successfull login");
        System.out.println(loginPage.Invalidmsg().getText());
    }
    @AfterMethod
    public void tearDown() {
        base.tearDown();
    }
}
