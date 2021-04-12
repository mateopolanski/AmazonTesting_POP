import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.*;


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


    public SearchListTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public String getPageURL() {
        return URL;
    }





    public searchForItem(String text) {

        searchTextBox.sendKeys(text);
        searchTextBox.sendKeys(Keys.ENTER);

        return new search;




        WebElement searchBar = driver.findElement(By.id());
        searchBar.sendKeys(SEARCHED_ITEM);
        searchBar.sendKeys(Keys.ENTER);


        WebDriverWait waiter = new WebDriverWait(driver , 2);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Cheyenne\"]"))).click();
        driver.findElement(By.xpath("//span[text()=\"Cheyenne Tattoo Machine Hawk Pen - Black\"]")).click();
        String product = driver.findElement(By.id("productTitle")).getText();
        Assertions.assertTrue(product.contains("Cheyenne Tattoo Machine Hawk Pen - Black"));
        String brand = driver.findElement(By.id("bylineInfo")).getText();
        Assertions.assertTrue(brand.equals("Brand: Cheyenne"));

    }

}