import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.*;

import java.util.concurrent.*;


class SearchListTest extends TestBase {


    private static final String URL = "https:\\amazon.com";
    private WebDriver driver;
    private static final String SEARCHED_ITEM = "cheyenne";


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(xpath = "//span[text()=\"Tattoo Machine Parts\"]")
    private WebElement searchCategoryTattooMachineParts;

    @FindBy(xpath = "//span[text()=\"Cheyenne\"]")
    private WebElement CategoryCheyenne;

    @FindBy(xpath = "//span[text()=\"Cheyenne Tattoo Machine Hawk Pen - Black\"]")
    private WebElement CheyenneHawkPen;

    @FindBy(id = "productTitle")
    private WebElement productDesc;

    @FindBy(id = "bylineInfo")
    private WebElement infoDesc;


    public SearchListTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public String getPageURL() {
        return URL;
    }


    public void searchForItem(String SEARCHED_ITEM) {


        WebDriverWait waiter = new WebDriverWait(driver , 2);
        searchTextBox.sendKeys(SEARCHED_ITEM);
        searchTextBox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
        searchCategoryTattooMachineParts.sendKeys(Keys.SPACE);
        waiter.until(ExpectedConditions.presenceOfElementLocated((By) CheyenneHawkPen)).click();
        productDesc.getText();
        infoDesc.getText();

        Assertions.assertEquals("Cheyenne Tattoo Machine Hawk Pen - Black" , productDesc);
        Assertions.assertEquals("Brand: Cheyenne" , infoDesc);
    }
}


