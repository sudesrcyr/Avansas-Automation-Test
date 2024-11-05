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
import static org.junit.Assert.*;
public class SiparisStepImplementation {

    private static final Logger logger = Logger.getLogger(SiparisStepImplementation.class);
    WebDriver driver = new ChromeDriver();
    WebElement email;
    WebElement password;
    WebElement address;
    WebElement bina;
    WebElement daire;
    WebElement kat;
    WebElement adresBasligi;

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

    @Step("Tarayıcıyı aç ve <url> git")
    public void goToWebsite(String url) {
        driver = DriverFactory.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Step("İmleci navbar'da bulunun Giriş Yap'a getir")
    public void moveToCursorToLogin() {
        driver.findElement(getLocator("Giriş Yap")).click();
    }

    @Step("Açılan dropdown'da Giriş Yap'a tıkla")
    public void clickLogin() {
        driver.findElement(getLocator("Login")).click();
        WebElement slider = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
    }

    @Step("E-posta textboxına tıkla")
    public void clickEmailTextbox() {
        email = driver.findElement(getLocator("username"));
        email.click();
    }

    @Step("E-posta gir <key>")
    public void enterEmail(String key) {
        By locator = getLocator("username");
        WebElement email = driver.findElement(locator);
        sendKeyOperations(email, key);
        assertTrue(email.isDisplayed());
        String mail = "sudesa@gmail.com";
        logger.info(String.format("%s mail adresi girildi.", mail));
    }

    @Step("Şifre textboxına tıkla")
    public void clickPasswordTextbox() {
        password = driver.findElement(getLocator("password"));
        password.click();
        logger.info("Sifre textboxina tiklandi.");
    }

    @Step("Şifre gir <key>")
    public void enterPassword(String key) {
        By locator = getLocator("password");
        WebElement password = driver.findElement(locator);
        sendKeyOperations(password, key);
        String sifre = "1234567890";
        logger.info(String.format("%s sifresi girildi.", sifre));
    }

    @Step("Cookie'yi kapat")
    public void closeTheCookie() {
        WebElement cookie = driver.findElement(getLocator("cookies"));
        cookie.click();
    }

    @Step("Beni Hatirla Checkboxina Tikla")
    public void beniHatirlaCheckbox() {
        WebElement beniHatirla = driver.findElement(getLocator("beni hatirla"));
        beniHatirla.click();
    }

    @Step("Giriş Yap butonuna tıkla")
    public void clickLoginButton() {
        driver.findElement(getLocator("LoginSubmitButton")).submit();
        logger.info("Giris Yap butonuna tiklandi.");
        logger.info("Kullanici anasayfaya yonlendirildi.");
    }

    @Step("Ofis-kırtasiyeye tıkla")
    public void clickTheCategory() throws InterruptedException {
        WebElement element = driver.findElement(getLocator("Ofis-Kırtasiye"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        logger.info("Ofis-Kirtasiye kategorisine tiklandi.");
        Thread.sleep(6000);
    }

    @Step("Sayfayı aşağı kaydır")
    public void moveToSlider() throws InterruptedException {
        WebElement slider2 = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider2).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2100);");
        logger.info("Urunleri goruntulemek icin sayfa asagi kaydirildi.");
        Thread.sleep(2000);
    }

    @Step("Bir ürünü sepete ekle")
    public void addProduct() throws InterruptedException {
        //sepete ekle 108852
        WebElement product = driver.findElement(getLocator("ürün"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).click().perform();
        logger.info("Secilen bir urun sepete eklendi.");
        Thread.sleep(3000);
    }

    @Step("Navbardaki sepet ikonuna tıkla")
    public void clickTheCartIcon() throws InterruptedException {
        driver.findElement(getLocator("Sepet İkonu")).click();
        logger.info("Navbardaki sepet ikonuna tiklandi.");
        Thread.sleep(5000);
    }

    @Step("Açılan dropdown'da Sepete Git'e tıkla")
    public void clickTheGoToTheCartButton() throws InterruptedException {
        WebElement buttonElement = driver.findElement(getLocator("Sepete Git"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonElement);
        logger.info("Acilan dropdown'dan Sepete Git'e tiklandi.");
        Thread.sleep(3000);
    }

    @Step("Sepet sayfasını aşağı kaydır")
    public void pageUpDown() throws InterruptedException {
        WebElement slider3 = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider3).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        logger.info("Sepet sayfasi goruntulendi ve sayfa asagi kaydirildi.");
        Thread.sleep(3000);
    }

    @Step("Devam Et butonuna tıkla")
    public void clickToContinueButton() throws InterruptedException {
        driver.findElement(getLocator("Devam Et")).click();
        logger.info("Devam Et butonuna tikla.");
        Thread.sleep(8000);
    }

    @Step("Yeni adres ekle butonuna tıkla")
    public void clickToAddNewAddressButton() throws InterruptedException {
        driver.findElement(getLocator("Yeni Adres Ekle")).click();
        logger.info("Yeni adres ekle butonuna tiklandi.");
        Thread.sleep(9000);
    }

    @Step("İl combobox'ına tıkla")
    public void clickToCity() {
        driver.findElement(getLocator("İl Combobox")).click();
        logger.info("Il combobox'ina tiklandi.");
    }

    @Step("İl seç <key>")
    public void chooseCity(String key) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator("İl Seçme")));
        driver.findElement(getLocator("İl Seçme")).click();
        String il = "Adana";
        logger.info(String.format("%s ili secildi.", il));
    }

    @Step("İlçe combobox'ına tıkla")
    public void clickCounty() {
        driver.findElement(getLocator("İlçe Combobox")).click();
        logger.info("Ilce combobox'ina tiklandi.");
    }

    @Step("İlçe seç <key>")
    public void chooseCounty(String key) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator("İlçe Seçme")));
        driver.findElement(getLocator("İlçe Seçme")).click();
        String ilce = "Aladag";
        logger.info(String.format("%s ilcesi secildi.", ilce));
    }

    @Step("Mahalle combobox'ına tıkla")
    public void clickNeighborhood() {
        driver.findElement(getLocator("Mahalle Combobox")).click();
        logger.info("Mahalle combobox'ina tiklandi.");
    }

    @Step("Mahalle seç <key>")
    public void chooseNeighborhood(String key) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator("Mahalle Seç")));
        driver.findElement(getLocator("Mahalle Seç")).click();
        Thread.sleep(1000);
        String mahalle = "Akören Mahallesi";
        logger.info(String.format("%s secildi.", mahalle));
    }

    @Step("Textbox'a tıkla")
    public void clickTextbox() throws InterruptedException {
        address = driver.findElement(getLocator("Apartman/Cadde/Sokak"));
        address.click();
        Thread.sleep(1000);
        logger.info("Apartman no textboxina tiklandi.");
    }

    @Step("Apartman/cadde/sokak bilgisi gir <key>")
    public void enterTheStreet(String key) throws InterruptedException {
        address.sendKeys("Sude Apartmanı");
        Thread.sleep(1000);
        String apartman = "Sude Apartmani";
        logger.info(String.format("%s girildi.", apartman));
    }

    @Step("Bina no textbox'ına tıkla")
    public void clickBuildTextbox() {
        bina = driver.findElement(getLocator("Bina No"));
        bina.click();
        logger.info("Bino no textboxina tiklandi");
    }

    @Step("Bina no gir <key>")
    public void enterBuildNo(String key) throws InterruptedException {
        bina.sendKeys("1");
        Thread.sleep(1000);
        String bina = "1";
        logger.info(String.format("Bina no %s girildi.", bina));
    }

    @Step("Daire no textbox'ına tıkla")
    public void clickApartmentTextbox() {
        daire = driver.findElement(getLocator("Daire No"));
        daire.click();
        logger.info("Daire no textboxina tiklandi.");
    }

    @Step("Daire no gir <key>")
    public void enterApartmentNo(String key) throws InterruptedException {
        daire.sendKeys("1");
        Thread.sleep(1000);
        String daire = "1";
        logger.info(String.format("Daire no %s girildi.", daire));
    }

    @Step("Kat no textbox'ına tıkla")
    public void clickFloorTextbox() {
        kat = driver.findElement(getLocator("Kat No"));
        kat.click();
        logger.info("Kat no textboxina tiklandi.");
    }

    @Step("Kat no gir <key>")
    public void enterFloorNo(String key) throws InterruptedException {
        kat.sendKeys("1");
        Thread.sleep(1000);
        String kat = "1";
        logger.info(String.format("Kat no %s girildi.", kat));
    }

    @Step("Adres başlığı textbox'ına tıkla")
    public void clickAddressHeader() {
        adresBasligi = driver.findElement(getLocator("Adres Başlığı"));
        adresBasligi.click();
        logger.info("Adres basligi textboxina tiklandi.");
    }

    @Step("Adres başlığı yaz <key>")
    public void enterAddressHeader(String key) throws InterruptedException {
        adresBasligi.sendKeys("ev");
        Thread.sleep(1000);
        String adres = "ev";
        logger.info(String.format("Adres basligi %s girildi.", adres));
    }

    @Step("Teslimat ve fatura adresim aynı olsun checkbox'ına tıkla")
    public void clickTheCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(getLocator("Fatura-Teslimat Adresi Checkbox"));
        checkbox.click();
        Thread.sleep(1000);
        boolean isChecked = checkbox.isSelected();
        assertTrue("Checkbox tiklanmadi!", isChecked);
        logger.info("Checkboxa tiklandi.");
    }

    @Step("Kaydet butonuna tıkla")
    public void clickTheSaveButton() throws InterruptedException {
        driver.findElement(getLocator("Kaydet")).submit();
        Thread.sleep(5000);
        driver.findElement(getLocator("Reklam")).click();
        Thread.sleep(1000);
        logger.info("Kaydet butonuna tiklandi.");
    }

    @Step("Sayfayı buton görene kadar aşağı kaydır")
    public void slider() throws InterruptedException {
        WebElement slider4 = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider4).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(2000);
        logger.info("Sayfa butonu gormek icin kaydirildi.");
    }

    @Step("Ödemeye Geç butonuna tıkla")
    public void clickPaymentButton() {
        driver.findElement(getLocator("Ödemeye Geç")).click();
        logger.info("Odemeye Gec butonuna tiklandi.");
    }

    @Step("Bir ödeme yöntemi seç")
    public void choosePaymentMethod() {
        WebElement radioButton = driver.findElement(getLocator("Ödeme Yöntemi Radiobutton"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", radioButton);
        logger.info("BKM odemi yontemi secildi.");
    }

    @Step("Sayfayı kaydır")
    public void downPage() throws InterruptedException {
        WebElement slider5 = driver.findElement(getLocator("Slider"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider5).clickAndHold().moveByOffset(150, 0).release().build().perform();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(2000);
        logger.info("Sayfa kaydirildi.");
    }

    @Step("Satış Sözleşmesi checkbox'ına tıkla")
    public void clickTheContractCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(getLocator("Satış Sözleşmesi Checkbox"));
        checkbox.click();
        Thread.sleep(2000);
        boolean isChecked = checkbox.isSelected();
        assertTrue("Satis sozlesmesi checkbox'ina tiklanmadi!", isChecked);
        logger.info("Satis sozlesmesi checkboxina tiklandi.");
    }

    @Step("Alışverişi Tamamla butonuna tıkla")
    public void clickCompleteTheShoppingButton() {
        driver.findElement(getLocator("Alışverişi Tamamla")).click();
        logger.info("Alisverisi tamamla butonuna tiklandi.");
    }

    public String getEmailValue() {
        return email.getAttribute("value");
    }

    public String getPasswordValue() {
        return password.getAttribute("value");
    }
}
