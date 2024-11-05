package identities;
import org.openqa.selenium.By;
import java.util.HashMap;
public class web_identities {
    public static HashMap<String, By> WebIdentities;
    private web_identities() {
    }
    public static HashMap<String, By> WebIdentities() {
        if (WebIdentities == null)
            WebIdentities = new HashMap<String, By>();
        if (WebIdentities.size() <= 0) initWebIdentities();
        return WebIdentities;
    }
    private static void addId(String key, By value) {
        WebIdentities.put(key, value);
    }
    private static void initWebIdentities() {
        addId("Giriş Yap", By.xpath("/html/body/div[3]/div[2]/header/section[1]/div/div/div/div[2]/div/div/div[2]/div[1]"));
        addId("Login", By.cssSelector("#header-main > div > div > div > div.col-xs-4 > div > div > div.list.user-menu-list > div.header-dropdown.active > nav > a:nth-child(1)"));
        addId("Slider", By.cssSelector("html.ng-scope"));
        addId("username", By.id("j_username")); //eposta-input
        addId("password", By.id("j_password")); //şifre-input
        addId("cookies", By.id("closeCookieConsent")); //cookie
        addId("beni hatirla", By.className("icheckbox_minimal"));
        addId("LoginSubmitButton", By.id("loginSubmitButton"));
        addId("Ofis-Kırtasiye", By.xpath("//a[@title='Ofis Kırtasiye']"));
        addId("cookie", By.className("ins-custom-close-button")); //ofis-kırtasiye cookie'si
        addId("ürün", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[4]/div[10]/div/div[3]/div[2]/form/div[1]/button"));
        addId("Sepet İkonu", By.className("cart-arrow"));
        addId("Sepete Git", By.cssSelector("#miniCartLayer > footer > div > div > div.col-xs-6.right-align > a"));
        addId("Sepet Ürünleri Listesi", By.cssSelector("#full-cart > div.cart-left-col > cart-list:nth-child(8) > div"));
        addId("Ürün Kodu", By.className("item-name"));
        addId("Devam Et", By.className("btn-continue")); //devam et butonu
        addId("Yeni Adres Ekle",By.cssSelector("#address-page > div.cart-left-col > address-selection:nth-child(2) > div > div.ng-scope > button"));
        addId("İl Combobox", By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(1) > avansas-select > div > div.select-text"));
        addId("İl Seçme", By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[1]/avansas-select/div/div[2]/ul/li[2]"));
        addId("İlçe Combobox", By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(2) > avansas-select > div > div.select-text"));
        addId("İlçe Seçme", By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[2]/avansas-select/div/div[2]/ul/li[2]"));
        addId("Mahalle Combobox", By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(3) > avansas-select > div > div.select-text"));
        addId("Mahalle Seç", By.xpath("//html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[3]/avansas-select/div/div[2]/ul/li[2]"));
        addId("Apartman/Cadde/Sokak", By.cssSelector("#line1"));
        addId("Bina No", By.cssSelector("#buildNo"));
        addId("Daire No", By.cssSelector("#doorNo"));
        addId("Kat No", By.cssSelector("#floorNo"));
        addId("Adres Başlığı", By.cssSelector("#addressTitle"));
        addId("Fatura-Teslimat Adresi Checkbox", By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[7]/div/checkbox/span/span[1]"));
        addId("Kaydet", By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[8]/button"));
        addId("Reklam", By.xpath("/html/body/div[7]/div/div/div/div/div[5]/div"));
        addId("Ödemeye Geç", By.cssSelector("#address-page > div.cart-right-col > checkout-side-bar > div:nth-child(2) > button"));
        addId("Ödeme Yöntemi Radiobutton", By.cssSelector("#full-cart > div.cart-left-col > div > payment-type > div > div.tabs > label:nth-child(2) > div"));
        addId("Satış Sözleşmesi Checkbox", By.cssSelector("#full-cart > div.cart-right-col > checkout-side-bar > div:nth-child(2) > div > checkbox > span > span.custom-checkbox"));
        addId("Alışverişi Tamamla", By.cssSelector("#full-cart > div.cart-right-col > checkout-side-bar > div:nth-child(2) > button"));
        addId("Register", By.cssSelector("#header-main > div > div > div > div.col-xs-4 > div > div > div.list.user-menu-list > div.header-dropdown.active > nav > a:nth-child(2)"));
        addId("Name", By.id("firstName"));
        addId("Surname", By.id("lastName"));
        addId("Phone", By.id("contactNo1") );
        addId("Mail", By.id("email"));
        addId("Password", By.id("password"));
        addId("Payment", By.id("invoiceTypes2"));
        addId("Job", By.id("select2-jobSelect-container"));
        addId("Engineer", By.xpath("/html/body/div[3]/main/div[2]/section/div/div[1]/form/div[1]/div[7]/span[2]/span/span[2]/ul/li[5]"));
        addId("İleti Checkbox", By.xpath("/html/body/div[3]/main/div[2]/section/div/div[1]/form/div[1]/div[9]/label/div"));
        addId("Üye Ol Buton", By.xpath("/html/body/div[3]/main/div[2]/section/div/div[1]/form/div[1]/div[10]/button"));
        addId("HomePageLogo", By.xpath("/html/body/div[3]/section[2]/div/div/div/div[1]/a/img"));
        addId("Searchbar", By.cssSelector("#multiple-datasets > span > input.search-input.tt-input"));
        addId("Search Button", By.xpath("/html/body/div[4]/header/section[1]/div/div/div/div[1]/div/div/div[2]/div/form/button"));
        addId("Brand", By.cssSelector("#main > div.container-fluid > div:nth-child(4) > div > div > div > div.col-xs-2 > div > div > div > div:nth-child(2) > div.content > ul > li:nth-child(1) > label > div > ins"));
        addId("Category", By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[1]/div/div/div/div[3]/div[2]/ul/li[4]/form/label/a"));
        addId("NumberOfProduct", By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div[3]/div[3]/form/div[1]/div/div[2]/input"));
        addId("Sepete Ekle", By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div[3]/div[3]/form/div[1]/button"));
        addId("Avansas Blog", By.cssSelector("body > div:nth-child(25) > div.wrapper.overflow-hidden > div > section.footer-shortcut > div:nth-child(3)"));
        addId("Slick", By.className("slick-next"));
        addId("Printer", By.cssSelector("#epcl-post-carousel-1 > div > div > div:nth-child(9) > div > div > article > a"));
        addId("Epson L15150", By.cssSelector("#single > div.content.row > div > div > article > section > div.text > div > div.owl-stage-outer > div > div:nth-child(8) > div > a > div.custom_price.two-side-bg > span.alt_satir"));
        addId("Blog Slider", By.xpath("/html"));
        addId("Add to Cart", By.xpath("/html/body/div[4]/main/div/div[3]/div/div/div[2]/div/div/div[4]/div/ul/li/form/div[3]/button"));
        addId("Kategori Kartus", By.cssSelector("#menu > div > nav > ul > li:nth-child(5)"));
        addId("Marka Combobox", By.cssSelector("#select-search-2 > span > span.selection > span"));
        addId("Marka Textbox", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[1]/span[2]/span/span[1]/input"));
        addId("Model Combobox", By.cssSelector("#select-search-3 > span > span.selection > span"));
        addId("Model Textbox", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[2]/span[2]/span/span[1]/input"));
        addId("Kartus-Toner Ara", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[3]/div/div/a"));
        addId("Siyah Toner", By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[1]/div/div[3]/div[3]/form/div[1]/button"));
        addId("Teknoloji", By.cssSelector("#menu > div > nav > ul > li:nth-child(4) > a"));
        addId("Buyutec", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[6]/div[2]"));
        addId("Marka Önerme", By.cssSelector("#brand"));
        addId("Model Önerme", By.cssSelector("#model"));
        addId("Ad-Soyad", By.cssSelector("#user"));
        addId("Popup Slider", By.cssSelector("#main > div:nth-child(7) > div > div > div > div > div.col-xs-8 > div > div > div > div.product-demand-module.ng-scope > div:nth-child(3) > div"));
        addId("Telefon", By.cssSelector("#phoneNumber"));
        addId("Checkbox", By.className("checkmark"));
        addId("Gonder", By.cssSelector("#main > div:nth-child(6) > div > div > div > div > div.col-xs-8 > div.section-container > div > div > div.product-demand-module.ng-scope > div:nth-child(3) > div > div > div > product-demand-popup > div > form > button"));
        addId("Kalem kodu", By.className("cart-item")); //item-code
        addId("Kartus Toner Alt kategorileri", By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/section/div/header/h2/span"));
    }
}
