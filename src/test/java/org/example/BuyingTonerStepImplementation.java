package org.example;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import identities.WebIdentityManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.log4j.Logger;

public class BuyingTonerStepImplementation {
    WebDriver driver = new ChromeDriver();
    private static final Logger logger = Logger.getLogger(BuyingTonerStepImplementation.class);

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

    @Step("Kullanıcı tarayıcıyı açar")
    public void BrowserAc() {
        driver = DriverFactory.getDriver();
        logger.info("Tarayici acildi.");
    }

    @Step("websitesine gider <url>")
    public void SayfayaGit(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(getLocator("cookies")).click();
        Thread.sleep(1000);
        String website = "https://avansas.com/";
        logger.info(String.format("%s sayfasina gidildi.", website));
    }

    @Step("Kategori navbar'ından Kartuş ve Toner'e tıklar")
    public void KartusKategorisiniSec() throws InterruptedException {
        WebElement element = driver.findElement(getLocator("Kategori Kartus"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Thread.sleep(1000);
    }

    @Step("<key> objesi gorunene kadar kaydir")
    public void scrollToElement(String key) throws InterruptedException {
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = driver.findElement(By.xpath("//*[text()='HP Kartuş']"));
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", element);

         String obje = "HP Kartus";
         logger.info(String.format("%s gorulene kadar sayfa kaydirildi.",obje));

        Thread.sleep(1000);
    }

    @Step("Marka seçiniz combobox'ına tıklar")
    public void MarkaComboboxTikla() throws InterruptedException {
        driver.findElement(getLocator("Marka Combobox")).click();
        logger.info("Marka combobox'ina tiklandi.");

        Thread.sleep(1000);
    }

    @Step("Açılan dropdown'dan marka seçer <key>")
    public void MarkaSec(String key) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement marka = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator("Marka Textbox")));
        marka.click();
        sendKeyOperations(marka, key);
        marka.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        String brand = "Epson";
        logger.info(String.format("%s markasi secildi.",brand));
    }

    @Step("Yazıcı modeli seçiniz combobox'ına tıklar")
    public void ModelComboboxTikla() throws InterruptedException {
        WebElement modelCombobox = driver.findElement(getLocator("Model Combobox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();" , modelCombobox);
        driver.findElement(getLocator("Model Combobox")).click();
        logger.info("Yazici modeli combobox'ina tiklandi.");
        Thread.sleep(1000);
    }

    @Step("Açılan dropdown'dan model seçer <key>")
    public void ModelSec(String key) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement model = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator("Model Textbox")));
        sendKeyOperations(model, key);
        model.sendKeys(Keys.ENTER);

        String mdl = "Inkjet L6570";
        logger.info(String.format("%s modeli secildi.",mdl));

        Thread.sleep(1000);

    }

    @Step("Kartuş&Toner Ara butonuna tıklar")
    public void AramaButonunaTikla() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(getLocator("Kartus-Toner Ara")).click();

        logger.info("Kartus&Toner Ara butonuna tiklandi.");
        Thread.sleep(1000);
    }

    @Step("Sonuçları görüntülemek için sayfayı aşağı kaydırır")
    public void SonuclariListele() throws InterruptedException {
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);

        logger.info("Sonuclari goruntulemek icin sayfa kaydirildi.");
        Thread.sleep(1000);
    }

    @Step("Sepete kartuş ekler <key>")
    public void SepeteUrunEkle(String key) throws InterruptedException {
        WebElement kartus = driver.findElement(getLocator("Siyah Toner"));
        kartus.submit();
        Thread.sleep(3000);

        String kartusSyh = "Epson C13T06C14A Siyah (Black) Kartus";
        logger.info(String.format("%s sepete eklendi.",kartusSyh));

    }

    @Step("Sepeti görüntüler")
    public void SepetiGoruntule() throws InterruptedException {
        driver.findElement(getLocator("Sepet İkonu")).click();
        logger.info("Sepet goruntulendi.");
        logger.info("Test basariyla tamamlandi");
        Thread.sleep(2000);
    }


}
