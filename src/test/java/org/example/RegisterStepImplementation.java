package org.example;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import identities.WebIdentityManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterStepImplementation {
    WebDriver driver = new ChromeDriver();
    private static final Logger logger = Logger.getLogger(RegisterStepImplementation.class);

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
    @Step("Tarayıcıyı aç")
    public void tarayiciAc() {
        driver = DriverFactory.getDriver();
        logger.info("Tarayici acildi.");
    }
    @Step("<url> git")
    public void goWebpage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        String website = "https://avansas.com/";
        logger.info(String.format("%s sayfasina gidildi.", website));
    }
    @Step("Navbar'da bulunun Giriş Yap'a tıkla")
    public void clickLogin() throws InterruptedException {
        driver.findElement(getLocator("Giriş Yap")).click();
        Thread.sleep(2000);
        logger.info("Giris Yap'a tiklandi.");
    }
    @Step("Açılan dropdown'da Üye Ol'a tıkla")
    public void clickRegister() throws InterruptedException {
        driver.findElement(getLocator("Register")).click();
        Thread.sleep(2000);
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000);
        WebElement cookie = driver.findElement(By.id("closeCookieConsent"));
        cookie.click();
        Thread.sleep(2000);
        logger.info("Acilan dropdown'dan uye ol'a tiklandi.");
    }
    @Step("Ad textboxına tıkla")
    public void clikckNameTextbox() throws InterruptedException {
        driver.findElement(getLocator("Name")).click();
        Thread.sleep(2000);
        logger.info("Ad textboxina tiklandi.");
    }
    @Step("İsim yaz <key>")
    public void enterName(String key) throws InterruptedException {
        By locator = getLocator("Name");
        WebElement isim = driver.findElement(locator);
        sendKeyOperations(isim, key);
        Thread.sleep(2000);
        String name = "Sude";
        logger.info(String.format("%s ismi girildi.", name));
    }
    @Step("Soyisim textboxına tıkla")
    public void clickSurnameTextbox() throws InterruptedException {
        driver.findElement(getLocator("Surname")).click();
        Thread.sleep(2000);
        logger.info("Soyad textboxina tiklandi.");
    }
    @Step("Soyisim yaz <key>")
    public void enterSurname(String key) throws InterruptedException {
        By locator = getLocator("Surname");
        WebElement soyisim = driver.findElement(locator);
        sendKeyOperations(soyisim, key);
        Thread.sleep(2000);
        String lastname = "Saricayir";
        logger.info(String.format("%s soyismi girildi.", lastname));
    }
    @Step("Cep telefonu textboxına tıkla")
    public void clickPhoneNoTextbox() throws InterruptedException {
        driver.findElement(getLocator("Phone")).click();
        Thread.sleep(2000);
        logger.info("Cep telefonu textboxina tiklandi.");
    }
    @Step("Telefon numarası yaz <key>")
    public void enterPhoneNo(String key) throws InterruptedException {
        By locator = getLocator("Phone");
        WebElement cepTel = driver.findElement(locator);
        sendKeyOperations(cepTel, key);
        Thread.sleep(2000);
        String cep = "5222222222";
        logger.info(String.format("%s telefon numarasi girildi.", cep));
    }
    @Step("E-posta textbox'ına tıkla")
    public void clickMailTextbox() throws InterruptedException {
        driver.findElement(getLocator("Mail")).click();
        Thread.sleep(2000);
        logger.info("E-posta textboxina tiklandi.");
    }
    @Step("E-posta yaz <key>")
    public void enterEmail(String key) throws InterruptedException {
        By locator = getLocator("Mail");
        WebElement eposta = driver.findElement(locator);
        sendKeyOperations(eposta, key);
        Thread.sleep(2000);
        String mail = "sudesa@gmail.com";
        logger.info(String.format("%s mail adresi girildi.", mail));
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);
    }
    @Step("Şifre textbox'ına tıkla")
    public void clickPasswordTextbox() throws InterruptedException {
        driver.findElement(getLocator("Password")).click();
        Thread.sleep(2000);
        logger.info("Sifre textboxina tiklandi.");
    }
    @Step("Şifre yaz <key>")
    public void enterPassword(String key) throws InterruptedException {
        By locator = getLocator("Password");
        WebElement sifre = driver.findElement(locator);
        sendKeyOperations(sifre, key);
        Thread.sleep(2000);
        String password = "123sude*-";
        logger.info(String.format("%s sifresi girildi.", password));
    }
    @Step("Fatura türü seç <key>")
    public void clickPaymentType(String key) throws InterruptedException {
        driver.findElement(getLocator("Payment")).click();
        Thread.sleep(2000);
        String fatura = "Bireysel";
        logger.info(String.format("%s fatura turu secildi.", fatura));
    }
    @Step("Meslek seç <key>")
    public void chooseProfession(String key) throws InterruptedException {
        driver.findElement(getLocator("Job")).click();
        Thread.sleep(2000);
        driver.findElement(getLocator("Engineer")).click();
        String meslek = "Muhendis";
        logger.info(String.format("%s meslegi girildi.", meslek));
    }
    @Step("Checbox tıkla")
    public void clickCheckbox() {
        WebElement checkbox = driver.findElement(getLocator("İleti Checkbox"));
        checkbox.click();
        logger.info("Checkbox'a tiklanildi.");
    }
    @Step("Üye Ol butonuna tıkla <key>")
    public void clickButton(String key) throws InterruptedException {
        driver.findElement(getLocator("Üye Ol Buton")).submit();
        Thread.sleep(5000);
        logger.info("Uye Ol butonuna tiklandi");
        logger.info("Kullanici anasayfaya yonlendirildi.");
        logger.info("Test basariyla tamamlandi.");
    }
}

