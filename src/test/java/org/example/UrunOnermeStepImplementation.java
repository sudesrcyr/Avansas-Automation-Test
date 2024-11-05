package org.example;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import identities.WebIdentityManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UrunOnermeStepImplementation {

    WebDriver driver = new ChromeDriver();
    private static final Logger logger = Logger.getLogger(UrunOnermeStepImplementation.class);

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

    @Step("Tarayıcıya git")
    public void openBrowser() {
        driver = DriverFactory.getDriver();
        logger.info("Tarayici acildi.");
    }
    @Step("<url> gider")
    public void openUrl(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(getLocator("cookies")).click();
        Thread.sleep(1000);
        String website = "https://avansas.com/";
        logger.info(String.format("%s sayfasina gidildi.", website));
    }
    @Step("Kategori navbar'ından <key> tıklar")
    public void clickTechnology(String key) throws InterruptedException {
        WebElement element = driver.findElement(getLocator("Teknoloji"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Thread.sleep(2000);
        String category="Teknoloji";
        logger.info(String.format("%s kategorisine tiklandi.", category));
    }
    @Step("Sağ altta bulunan büyüteç'e tıklar")
    public void clickUrunOnermeButton() throws InterruptedException {
        driver.findElement(getLocator("Buyutec")).click();
        Thread.sleep(1000);
        logger.info("Buyutece tiklandi.");
    }
    @Step("Marka textbox'ına tıklar")
    public void clickBrandTextbox() throws InterruptedException {
        driver.findElement(getLocator("Marka Önerme")).click();
        Thread.sleep(2000);
        logger.info("Marka textboxina tiklandi.");
    }
    @Step("İstediği markayı yazar <key>")
    public void enterBrand(String key) throws InterruptedException {
        By locator = getLocator("Marka Önerme");
        WebElement markaOnerme = driver.findElement(locator);
        sendKeyOperations(markaOnerme, key);
        Thread.sleep(2000);
        String markaOnerisi= "HP";
        logger.info(String.format("%s markasi yazildi.", markaOnerisi));
    }

    @Step("Model textbox'ına tıklar")
    public void clickModelTextbox() throws InterruptedException {
        driver.findElement(getLocator("Model Önerme")).click();
        Thread.sleep(2000);
        logger.info("Model textboxina tiklandi");
    }
    @Step("İstediği modeli yazar <key>")
    public void enterModel(String key) throws InterruptedException {
        By locator = getLocator("Model Önerme");
        WebElement modelOnerme = driver.findElement(locator);
        sendKeyOperations(modelOnerme, key);
        Thread.sleep(2000);
        String modelOnerisi= "HP Z3700 Kablosuz Mouse Gri 758A9AA";
        logger.info(String.format("%s modeli yazildi.", modelOnerisi));
    }
    @Step("Ad-Soyad textbox'ına tıklar")
    public void clickNameTextbox() throws InterruptedException {
        driver.findElement(getLocator("Ad-Soyad")).click();
        Thread.sleep(2000);
        logger.info("Ad-soyad textboxina tiklandi");
    }
    @Step("Ad-Soyad girer <key>")
    public void enterNameSurname(String key) throws InterruptedException {
        By locator = getLocator("Ad-Soyad");
        WebElement nameSurname = driver.findElement(locator);
        sendKeyOperations(nameSurname, key);
        Thread.sleep(2000);
        String person= "Sude Saricayir";
        logger.info(String.format("%s ad-soyadi girildi.", person));
    }
    @Step("Popup'ı kaydır")
    public void popupSlider() throws InterruptedException {
        WebElement slider = driver.findElement(getLocator("Popup Slider"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 300;", slider);
        Thread.sleep(1000);
    }
    @Step("Telefon numarası textbox'ına tıklar")
    public void clickPhoneTextbox() throws InterruptedException {
        driver.findElement(getLocator("Telefon")).click();
        Thread.sleep(2000);
        logger.info("Telefon numarasi textboxina tiklandi");
    }

    @Step("10 haneli cep telefonu numarası girer <key>")
    public void enterPhoneNo(String key) throws InterruptedException {
        By locator = getLocator("Telefon");
        WebElement tel = driver.findElement(locator);
        sendKeyOperations(tel, key);
        Thread.sleep(3000);
        String phone= "5333333333";
        logger.info(String.format("%s telefon numarasi girildi.", phone));
    }
    @Step("Checkbox'a tıklar")
    public void clickCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(getLocator("Checkbox"));
        if (checkbox.isDisplayed() && checkbox.isEnabled()) {
            checkbox.click();
            System.out.println("Checkbox'a tiklandi.");
        } else {
            System.out.println("Checkbox gorunur degil veya tiklanamaz durumda.");
        }
        Thread.sleep(2000);
        logger.info("Checkboxa tiklandi");
    }
    @Step("Gönder butonuna tıklar")
    public void clickSendButton() throws InterruptedException {
        driver.findElement(getLocator("Gonder")).click();
        Thread.sleep(2000);
        logger.info("Gonder butonuna tiklandi");
    }

}