package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basepage {
    public WebDriver driver;
    String WebsiteURL="https://the-internet.herokuapp.com/login";

    public WebDriverWait Expwait(){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public basepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public void launchwebsite(){
        driver.get(WebsiteURL);
    }
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
}}
