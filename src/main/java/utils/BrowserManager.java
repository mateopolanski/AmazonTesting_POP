package utils;

import java.util.Locale;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BrowserManager {
    private static final Logger log = LogManager.getLogger(BrowserManager.class.getSimpleName());

    public WebDriver getDriver(String driverType){

        WebDriver requestedDriver = null;
        if ("CHROME".equals(driverType.toUpperCase(Locale.ROOT))) {
            log.info("Chrome driver selected");
            requestedDriver = initChrome();
            log.info("Firefox driver selected");
            requestedDriver = initFirefox();
            log.info("Edge driver selected");
            requestedDriver = initEdge();
        } else if ("FIREFOX".equals(driverType.toUpperCase(Locale.ROOT))) {
            log.info("Firefox driver selected");
            requestedDriver = initFirefox();
            log.info("Edge driver selected");
            requestedDriver = initEdge();
        } else if ("EDGE".equals(driverType.toUpperCase(Locale.ROOT))) {
            log.info("Edge driver selected");
            requestedDriver = initEdge();
        }
        return requestedDriver;
    }

    private WebDriver initChrome(){
        log.info("Setting up new ChromeDriver");
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path") + "/chromedriver.exe");
        return new ChromeDriver();
    }
    private WebDriver initFirefox(){
        //firefox requires not only browser to be installed but also profile to be created.
        log.info("Setting up new FirefoxDriver");
        System.setProperty("webdriver.gecko.driver", System.getProperty("driver.path") + "/geckodriver.exe");
        FirefoxProfile profile = new ProfilesIni().getProfile("TestAutomation");
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setProfile(profile);
        return new FirefoxDriver(ffOptions);
    }

    private WebDriver initEdge(){
        log.info("Setting up new EdgeDriver");
        System.setProperty("webdriver.edge.driver", System.getProperty("driver.path") + "/msedgedriver.exe");
        return new EdgeDriver();
    }
}