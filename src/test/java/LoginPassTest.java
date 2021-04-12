import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

import java.util.concurrent.*;


class LoginPassTest {



    private WebDriver driver;
    private final String ACCOUNT_EMAIL = PropertyManager.getProperty("login.correct.email");
    private final String AUTH_PASS = PropertyManager.getProperty("login.correct.pass");

    public LoginPassTest (WebDriver driver){
        this.driver = driver;
    }

    void successfullLginToExistingAccount() {

        WebElement signInBtn = driver.findElement(By.xpath("//span[@class=\"nav-line-2 nav-long-width\"]"));
        signInBtn.click();

        WebDriverWait wait = new WebDriverWait(driver , 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email"))).sendKeys(ACCOUNT_EMAIL);
        driver.findElement(By.className("a-button-input")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_password")));

        driver.findElement(By.id("ap_password")).sendKeys(AUTH_PASS);
        driver.findElement(By.id("signInSubmit")).click();

        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);

        try {
            WebElement signName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            String match = signName.getText();
            Assertions.assertEquals("Hello, AmazonTester" , match);
        } catch (ExceptionInInitializerError e) {
            System.out.println("Captcha Appeared");
        }

    }
}