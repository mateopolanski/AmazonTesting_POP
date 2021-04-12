import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;
import org.testng.annotations.*;
import utils.*;

@Listeners
public abstract class TestBase {

    protected WebDriver driver;
    protected BrowserManager browserManager;

    protected AddItemToBasket addItemToBasket;
    protected LoginPassTest loginPassTest;
    protected LoginWrongCredentialsTest loginWrongCredentialsTest;
    protected RegisterNewAccountTest registerNewAccountTest;
    protected SearchListTest searchListTest;

    public TestBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @Parameters("browserType")
    @BeforeClass
    public void setup (@Optional ("Chrome") String browserName, ITestContext iTestContext){

        browserManager = new BrowserManager();
        driver = browserManager.getDriver(browserName);
        iTestContext.setAttribute("Webdriver", driver);
        driver.manage().window();

        searchListTest = new SearchListTest(driver);

        addItemToBasket = new AddItemToBasket(driver);

    }

    public abstract String getPageURL();


    @AfterClass
    public void quit (){
        driver.quit();
    }



}

