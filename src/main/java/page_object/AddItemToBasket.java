package page_object;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

class AddItemToBasket extends TestBase {



    private static final String INK_ITEM = PropertyManager.getProperty("ink.item");
    private static final String CARTRIDGE_ITEM = PropertyManager.getProperty("tattoo cartridge");


    public AddItemToBasket (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (id = "twotabsearchtextbox")
    private WebElement searchItem1;

    @FindBy (xpath = "//span[text()=\"Mom's Black Onyx Tattoo Ink - 1/2oz\"]")
    private WebElement product1;

    @FindBy (xpath = "//span[text()=\"Dynamic Black Tattoo Ink Bottle 8oz\"]")
    private WebElement product2;

    @FindBy (xpath = "//span[text()=\"Dragonhawk Mast Tattoo Cartridges Needles 50pcs " +
                    "Round Liner Mixed 3RL 5RL 7RL 9RL 11RL Size for Machine Kit Supply (50pcs RL)\"]")
    private WebElement product3;

    @FindBy (id = "add-to-cart-button")
    private WebElement addItemToBasket;

    @FindBy (id = "hlb-view-cart-announce")
    private WebElement cartView;

    @FindBy (id = "sc-subtotal-label-activecart")
    private WebElement total;


    void addItems() {

        WebDriverWait wait = new WebDriverWait(driver , 3);


        searchItem1.sendKeys(INK_ITEM);
        searchItem1.sendKeys(Keys.ENTER);
        product1.click();
        wait.until(ExpectedConditions.elementToBeClickable((addItemToBasket))).click();

        searchItem1.sendKeys(INK_ITEM);
        searchItem1.sendKeys(Keys.ENTER);
        product2.click();
        wait.until(ExpectedConditions.elementToBeClickable((addItemToBasket))).click();
        searchItem1.sendKeys(CARTRIDGE_ITEM);
        searchItem1.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated((By) product3)).click();
        wait.until(ExpectedConditions.elementToBeClickable((addItemToBasket))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By) cartView)).click();
        total.getText();

      //  Assertions.assertEquals("Subtotal (3 items):" , total);
    }

    @Override
    public String getPageURL() {
        return null;
    }
}
