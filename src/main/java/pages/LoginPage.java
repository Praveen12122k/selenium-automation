package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By Usernamefield= By.xpath("//input[@id='username']");
    private final By Passwordfield=By.xpath("//input[@id='password']");
    private final By Loginbtn=By.xpath("//form[@id=\"login\"]/button[@type='submit']");
    private final By Invalidmessage=By.xpath("//div[@id='flash-messages']/div[@class='flash error']");
    private final By Successmessage=By.xpath("//div[@id='flash-messages']/div[@class='flash success']");

    public LoginPage(WebDriver driver){
       this.driver=driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterusername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Usernamefield));
        driver.findElement(Usernamefield).sendKeys(username);
    }
    public void enterpassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Passwordfield));
        driver.findElement(Passwordfield).sendKeys(password);
    }
    public void Clickloginbtn(){
        wait.until(ExpectedConditions.elementToBeClickable(Loginbtn));
        driver.findElement(Loginbtn).click();
    }
    public WebElement Invalidmsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Invalidmessage));
        return driver.findElement(Invalidmessage);
    }
    public WebElement Successmsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Successmessage));
        return driver.findElement(Successmessage);
    }
}
