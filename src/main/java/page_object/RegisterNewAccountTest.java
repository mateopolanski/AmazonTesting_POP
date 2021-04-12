package page_object;

import org.jboss.aerogear.security.otp.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import utils.*;

import java.util.*;
import java.util.concurrent.*;

class RegisterNewAccountTest {

   private WebDriver driver;
   private Random randomGenerator = new Random();
   private int randomInt = randomGenerator.nextInt(10000);
   private final String PASS = PropertyManager.getProperty("register.password");
   //TODO private final String OTP_MESSAGE = "//div[@class=\"a-section cvf-alert-section cvf-widget-alert-message\"]";

   private String otpKeyStr = PropertyManager.getProperty("register.otp.key"); // <- this 2FA secret key.
   private Totp totp = new Totp(otpKeyStr);
   private String twoFactorCode = totp.now(); // <- got 2FA coed at this time!


   public RegisterNewAccountTest(WebDriver driver){

        this.driver = driver;
    }


            void registerNewAccount() {

               WebElement signInBtn = driver.findElement(By.xpath("//span[@class=\"nav-line-2 nav-long-width\"]"));
               signInBtn.click();

               driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
               WebElement newAccount = driver.findElement(By.xpath("//a[@class=\"a-button-text\"]"));

               newAccount.click();
               driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
               driver.findElement(By.id("ap_customer_name")).sendKeys("Mateusz");
               driver.findElement(By.id("ap_email")).sendKeys("usernamex" + randomInt + "@gmail.com");
               driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASS);
               driver.findElement(By.xpath("//input[@id=\"ap_password_check\"]")).sendKeys(PASS);
               driver.findElement(By.className("a-button-input")).click();
               driver.findElement(By.xpath("//input[@name=\"code\"]")).sendKeys(twoFactorCode);
               driver.findElement(By.className("a-button-input")).click();
            //todo   WebElement message = driver.findElement(By.xpath(OTP_MESSAGE));
            //todo   String alert = message.getText();
             //todo  Assertions.assertEquals("Invalid OTP. Please check your code and try again." , alert);

               /*
               Even with additional libraries "org.jboss.aerogear.security.otp.Totp;" safety F2V of Amazon would not
               allow to bypass OTP code, and progress further to register a new account by Selenium.
                */
           }

}

