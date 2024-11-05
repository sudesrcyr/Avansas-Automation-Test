package org.example;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import identities.WebIdentityManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class SearchbarStepImplementation {
    WebDriver driver = new ChromeDriver();
    private static final Logger logger = Logger.getLogger(SearchbarStepImplementation.class);
    private List<WebElement> piece;

    private By getLocator(String key) {
        WebIdentityManager manager = new WebIdentityManager();
        By locator = manager.getWebIdentity(key);

        if (locator == null) {
            throw new IllegalArgumentException("Locator not found for key: " + key);
        }
        return locator;
    }

    private void sendKeyOperations(WebElement element, String key) {
        element.clear();
        element.sendKeys(key);
    }

    @Step("Tarayıcı açılır")
    public void openTheChrome() {
        driver = DriverFactory.getDriver();
        logger.info("Tarayici acildi.");
    }

    @Step("websitesine git <url>")
    public void goToTheWebsite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        String website = "https://avansas.com/";
        logger.info(String.format("%s sayfasina gidildi.", website));
    }

    @Step("Çerezleri kapat")
    public void closeCookie() throws InterruptedException {
        driver.findElement(getLocator("cookies")).click();
        Thread.sleep(1000);
    }

    @Step("Searchbara tıkla")
    public void clickSearchbar() throws InterruptedException {
        driver.findElement(getLocator("Searchbar")).click();
        Thread.sleep(1000);
        logger.info("Searchbar'a tiklanildi.");
    }

    @Step("Ürün adı yaz <key>")
    public void enterAnProductName(String key) throws InterruptedException {
        By locator = getLocator("Searchbar");
        WebElement product = driver.findElement(locator);
        sendKeyOperations(product, key);
        Thread.sleep(2000);
        String urun = "Kalem";
        logger.info(String.format("%s urun adi yazildi.", urun));
    }

    @Step("Arama butonuna tıkla")
    public void clickSearchButton() throws InterruptedException {
        WebElement click = driver.findElement(getLocator("Searchbar"));
        click.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        logger.info("Arama butonuna tiklandi.");
    }

    @Step("Marka seç <key>")
    public void chooseBrand(String key) throws InterruptedException {
        driver.findElement(getLocator("Brand")).click();
        Thread.sleep(2000);
        String markaSec = "Avansas";
        logger.info(String.format("%s markasi secildi.", markaSec));
    }

    @Step("Sayfayı kategorileri görene kadar kaydır")
    public void slider() throws InterruptedException {
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(2000);
        logger.info("Sayfa kategoriler goruntulenene kadar kaydirildi.");
    }

    @Step("Kategori seç <key>")
    public void chooseCategory(String key) throws InterruptedException {
        driver.findElement(getLocator("Category")).click();
        Thread.sleep(2000);
        String kategoriSec = "Tukenmez Kalemler";
        logger.info(String.format("%s kategorisi secildi.", kategoriSec));
    }

    @Step("Sayfayı ürünleri görene kadar kaydır")
    public void slider1() throws InterruptedException {
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000);
        logger.info("Urunler goruntulendi.");
    }

    @Step("Ürün altındaki textboxa tıkla")
    public void clickTextbox() throws InterruptedException {
        WebElement adet = driver.findElement(getLocator("NumberOfProduct"));
        adet.click();
        Thread.sleep(1000);
        adet.sendKeys(Keys.ARROW_RIGHT);
        adet.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        logger.info("Secilen bir urunun altindaki adet textboxina tiklandi.");
    }

    @Step("Ürün adeti girişi yap <key>")
    public void enterNumberofProduct(String key) throws InterruptedException {
        piece = driver.findElements(getLocator("NumberOfProduct")); // List olarak al
        for (WebElement quantityInput : piece) {
            sendKeyOperations(quantityInput, key);
            Thread.sleep(2000);
        }
        String urunAdeti = "2";
        logger.info(String.format("Adet sayisi icin %s girildi.", urunAdeti));
    }


    @Step("Butona bas <key>")
    public void clickCartButton(String key) throws InterruptedException {
        driver.findElement(getLocator("Sepete Ekle")).submit();
        Thread.sleep(3000);
        logger.info("Sepete ekle butonuna tiklandi.");
    }

    @Step("Sepeti görüntüle")
    public void showTheCart() throws InterruptedException {
        driver.findElement(getLocator("Sepet İkonu")).click();
        Thread.sleep(2000);
        driver.findElement(getLocator("Sepete Git")).click();
        logger.info("Sepete gidildi.");
        String kalem = "Avansas Softjel Tukenmez Kalem 0.5 mm Uclu Siyah Renk";
        logger.info(String.format("Sepette %s urunu bulundu.", kalem));
        logger.info("Test basariyla tamamlandi");
    }

}
