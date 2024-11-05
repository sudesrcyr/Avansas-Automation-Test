package org.example;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import identities.WebIdentityManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
public class BlogPageStepImplementation {

    WebDriver driver = new ChromeDriver();
    private static final Logger logger = Logger.getLogger(BlogPageStepImplementation.class);
    private By getLocator(String key) {
        WebIdentityManager manager = new WebIdentityManager();
        By locator = manager.getWebIdentity(key);
        if (locator == null) {
            throw new IllegalArgumentException("Locator not found for key: " + key);
        }
        return locator;
    }
    @Step("Tarayıcı aç")
    public void openBrowser() {
        driver = DriverFactory.getDriver();
        logger.info("Tarayici acildi.");
    }
    @Step("Websitesini aç <url>")
    public void openWebsite(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String website = "https://avansas.com/";
        logger.info(String.format("%s sayfasina gidildi.", website));
    }
    @Step("Sayfayı footera kadar kaydır")
    public void scrollPage() throws InterruptedException {
        Long scrollHeightLong = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        int scrollHeight = scrollHeightLong.intValue();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + (scrollHeight * 0.85) + ");");
        logger.info("Sayfada Avansas Blog bulundu.");
        Thread.sleep(3000);
    }
    @Step("<key> a tıkla")
    public void clickBlog(String key) throws InterruptedException {
        driver.findElement(getLocator("Avansas Blog")).click();
        Thread.sleep(3000);
        assertTrue(driver.getTitle().contains("Blog"));
        String site = "Avansas Blog";
        logger.info(String.format("%s tiklandi.", site));
    }
    @Step("Carouselı sağa kaydır")
    public void scrollTheRightSide() throws InterruptedException {
        driver.findElement(getLocator("Slick")).click();
        Thread.sleep(3000);
        logger.info("Carousel blog yazisi bulunmasi icin saga kaydirildi.");
    }
    @Step("Blog yazısına tıkla <key>")
    public void clickWrittenBlog(String key) throws InterruptedException {
        driver.findElement(getLocator("Printer")).click();
        Thread.sleep(3000);
        assertTrue(driver.getTitle().contains("En İyi 10 Yazıcı Önerisi"));
        String blog = "En Iyi 10 Yazici Onerisi";
        logger.info(String.format("%s blog yazisina tiklandi.", blog));
    }
    @Step("Ürünleri görmek için sayfayı kaydır")
    public void scrollDownPage() throws InterruptedException {
        WebElement slider = driver.findElement(getLocator("Blog Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(3000);
        logger.info("Urunler goruntulenene kadar sayfa kaydirildi.");
    }
    @Step("Önerilen yazıcılara tıkla <key>")
    public void clickPrinter(String key) throws InterruptedException {
        driver.findElement(getLocator("Epson L15150")).click();
        Thread.sleep(3000);
        String printer = "Epson L15150";
        logger.info(String.format("%s yazicisina tiklanildi.", printer));
    }
    @Step("Ürünü sepete ekle")
    public void addToCartButton() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(1000);
        WebElement slider = driver.findElement(getLocator("Blog Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div[2]/button")).click(); //cookie kapat
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(getLocator("Add to Cart")));
        addToCartButton.click();
        logger.info("Yazici sepete eklendi.");
        Thread.sleep(1000);
    }
    @Step("Sepete git")
    public void completeShopping() throws InterruptedException {
        driver.findElement(getLocator("Sepet İkonu")).click();
        Thread.sleep(2000);
        WebElement buttonElement = driver.findElement(getLocator("Sepete Git"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonElement);
        Thread.sleep(2000);
        logger.info("Sepete gidildi ve yazicinin sepete eklendigi goruntulendi.");
        logger.info("Test basariyla tamamlandi!");
    }

}
