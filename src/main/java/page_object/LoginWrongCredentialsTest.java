package page_object;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

import java.util.*;
import java.util.concurrent.*;

class LoginWrongCredentialsTest {


   private WebDriver driver;
   private final String ACCOUNT_EMAIL = PropertyManager.getProperty("login.incorrect.email");
   private Random randomGenerator = new Random();
   private int badAuthorizationPass = randomGenerator.nextInt(10000);

   public LoginWrongCredentialsTest(WebDriver driver){
      this.driver = driver;
   }


    void unsuccessfullLoginToExistingAccount() {

       WebElement signInBtn = driver.findElement(By.xpath("//span[@class=\"nav-line-2 nav-long-width\"]"));
       signInBtn.click();

       WebDriverWait wait = new WebDriverWait(driver, 3);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email"))).sendKeys(ACCOUNT_EMAIL);
       driver.findElement(By.className("a-button-input")).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_password")));

       driver.findElement(By.id("ap_password")).sendKeys("pass"+badAuthorizationPass);
       driver.findElement(By.id("signInSubmit")).click();

       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

       WebElement wrongPswd = driver.findElement(By.className("a-list-item"));
       String alert = wrongPswd.getText();
       Assertions.assertEquals("Your password is incorrect", alert);

       /*
       Program should not log into account as an password authorisation key is not correct. Valid password is given
       in page_object.LoginPassTest.class
        */
   }

}