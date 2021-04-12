import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.*;


class SearchListTest extends TestBase {


    private static final String AMAZON_PAGE_TITLE = "Amazono.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private static final String CHROME_DRIVER_PATH = "D:\\chromedriver.exe";
    private static final String URL = "https:\\amazon.com";
    private WebDriver driver;
    private static final String SEARCHED_ITEM = "cheyenne";


    public SearchListTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public String getPageURL() {
        return URL;
    }





    void searchForItem(String text) {

        @FindBy(id = "twotabsearchtextbox")
        private WebElement searchTextBox;

        @FindBy(xpath =)
        private WebElement searchTextBox;

        WebElement searchBar = driver.findElement(By.id());
        searchBar.sendKeys(SEARCHED_ITEM);
        searchBar.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//span[text()=\"Tattoo Machine Parts\"]")).click();
        WebDriverWait waiter = new WebDriverWait(driver , 2);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Cheyenne\"]"))).click();
        driver.findElement(By.xpath("//span[text()=\"Cheyenne Tattoo Machine Hawk Pen - Black\"]")).click();
        String product = driver.findElement(By.id("productTitle")).getText();
        Assertions.assertTrue(product.contains("Cheyenne Tattoo Machine Hawk Pen - Black"));
        String brand = driver.findElement(By.id("bylineInfo")).getText();
        Assertions.assertTrue(brand.equals("Brand: Cheyenne"));

    }

}