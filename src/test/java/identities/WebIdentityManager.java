package identities;
import org.openqa.selenium.By;
public class WebIdentityManager {
    public By getWebIdentity(String key) {
        if (key.equals("Giriş Yap")) {
            return By.xpath("/html/body/div[3]/div[2]/header/section[1]/div/div/div/div[2]/div/div/div[2]/div[1]");
        } else if (key.equals("Login")) {
            return By.cssSelector("#header-main > div > div > div > div.col-xs-4 > div > div > div.list.user-menu-list > div.header-dropdown.active > nav > a:nth-child(1)");
        } else if (key.equals("username")) {
            return By.id("j_username"); // E-posta input
        } else if (key.equals("password")) {
            return By.id("j_password"); // Şifre input
        }else if (key.equals("beni hatirla")) {
            return By.className("icheckbox_minimal");
        }else if (key.equals("beni hatirla2")) {
            return By.className("iCheck-helper");
        }else if (key.equals("LoginSubmitButton")) {
            return By.id("loginSubmitButton");
        } else if (key.equals("Ofis-Kırtasiye")) {
            return By.xpath("//a[@title='Ofis Kırtasiye']");
        } else if (key.equals("ürün")) {
            return By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[4]/div[10]/div/div[3]/div[2]/form/div[1]/button");
        } else if (key.equals("Sepet İkonu")) {
            return By.className("cart-arrow");
        } else if (key.equals("Sepete Git")) {
            return By.cssSelector("#miniCartLayer > footer > div > div > div.col-xs-6.right-align > a");
        } else if (key.equals("Sepet Ürünleri Listesi")) {
            return By.cssSelector("#full-cart > div.cart-left-col > cart-list:nth-child(8) > div");
        } else if (key.equals("Ürün Kodu")) {
            return By.className("item-name");
        } else if (key.equals("Devam Et")) {
            return By.className("btn-continue"); // Devam et butonu
        } else if (key.equals("Yeni Adres Ekle")) {
            return By.cssSelector("#address-page > div.cart-left-col > address-selection:nth-child(2) > div > div.ng-scope > button");
        } else if (key.equals("İl Combobox")) {
            return By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(1) > avansas-select > div > div.select-text");
        } else if (key.equals("İl Seçme")) {
            return By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[1]/avansas-select/div/div[2]/ul/li[2]");
        } else if (key.equals("İlçe Combobox")) {
            return By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(2) > avansas-select > div > div.select-text");
        } else if (key.equals("İlçe Seçme")) {
            return By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[2]/avansas-select/div/div[2]/ul/li[2]");
        } else if (key.equals("Mahalle Combobox")) {
            return By.cssSelector("body > div.project.ng-scope > section > add-address-popup > div > div > div > form.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-maxlength > div > div:nth-child(3) > div:nth-child(3) > avansas-select > div > div.select-text");
        } else if (key.equals("Mahalle Seç")) {
            return By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[2]/div[3]/avansas-select/div/div[2]/ul/li[2]");
        } else if (key.equals("Apartman/Cadde/Sokak")) {
            return By.cssSelector("#line1");
        } else if (key.equals("Bina No")) {
            return By.cssSelector("#buildNo");
        } else if (key.equals("Daire No")) {
            return By.cssSelector("#doorNo");
        } else if (key.equals("Kat No")) {
            return By.cssSelector("#floorNo");
        } else if (key.equals("Adres Başlığı")) {
            return By.cssSelector("#addressTitle");
        } else if (key.equals("Fatura-Teslimat Adresi Checkbox")) {
            return By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[7]/div/checkbox/span/span[1]");
        } else if (key.equals("Kaydet")) {
            return By.xpath("/html/body/div[1]/section/add-address-popup/div/div/div/form[1]/div/div[8]/button");
        } else if (key.equals("Reklam")) {
            return By.xpath("/html/body/div[7]/div/div/div/div/div[5]/div");
        } else if (key.equals("Ödemeye Geç")) {
            return By.cssSelector("#address-page > div.cart-right-col > checkout-side-bar > div:nth-child(2) > button");
        } else if (key.equals("Ödeme Yöntemi Radiobutton")) {
            return By.cssSelector("#full-cart > div.cart-left-col > div > payment-type > div > div.tabs > label:nth-child(2) > div");
        } else if (key.equals("Satış Sözleşmesi Checkbox")) {
            return By.cssSelector("#full-cart > div.cart-right-col > checkout-side-bar > div:nth-child(2) > div > checkbox > span > span.custom-checkbox");
        } else if (key.equals("Alışverişi Tamamla")) {
            return By.cssSelector("#full-cart > div.cart-right-col > checkout-side-bar > div:nth-child(2) > button");
        } else if (key.equals("Slider")) {
            return By.cssSelector("html.ng-scope");
        } else if (key.equals("Register")){
            return By.cssSelector("#header-main > div > div > div > div.col-xs-4 > div > div > div.list.user-menu-list > div.header-dropdown.active > nav > a:nth-child(2)");
        } else if (key.equals("Name")){
            return By.id("firstName");
        } else if (key.equals("Surname")){
            return By.id("lastName");
        } else if (key.equals("Phone")){
            return By.id("contactNo1");
        } else if (key.equals("Mail")){
            return By.id("email");
        } else if (key.equals("Password")){
            return By.id("password");
        } else if (key.equals("Payment")){
            return By.id("invoiceTypes2");
        } else if (key.equals("Job")){
            return By.id("select2-jobSelect-container");
        } else if (key.equals("Engineer")){
            return By.xpath("/html/body/div[3]/main/div[2]/section/div/div[1]/form/div[1]/div[7]/span[2]/span/span[2]/ul/li[5]");
        } else if (key.equals("İleti Checkbox")) {
            return By.xpath("/html/body/div[3]/main/div[2]/section/div/div[1]/form/div[1]/div[9]/label/div");
        } else if (key.equals("Üye Ol Buton")){
            return By.id("registerSubmitButton");
        } else if (key.equals("Searchbar")){
            return By.cssSelector("#multiple-datasets > span > input.search-input.tt-input");
        } else if (key.equals("Search Button")){
            return By.xpath("/html/body/div[4]/header/section[1]/div/div/div/div[1]/div/div/div[2]/div/form/button");
        } else if (key.equals("Brand")){
            return By.cssSelector("#main > div.container-fluid > div:nth-child(4) > div > div > div > div.col-xs-2 > div > div > div > div:nth-child(2) > div.content > ul > li:nth-child(1) > label > div > ins");
        } else if (key.equals("Category")) {
            return By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[1]/div/div/div/div[3]/div[2]/ul/li[4]/form/label/a");
        } else if (key.equals("NumberOfProduct")){
            return By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div[3]/div[3]/form/div[1]/div/div[2]/input");
        } else if (key.equals("Sepete Ekle")) {
            return By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div[3]/div[3]/form/div[1]/button");
        } else if (key.equals("cookies")) {
            return By.id("closeCookieConsent");
        } else if (key.equals("Avansas Blog")) {
            return By.cssSelector("body > div:nth-child(25) > div.wrapper.overflow-hidden > div > section.footer-shortcut > div:nth-child(3)");
        } else if (key.equals("Slick")) {
            return By.className("slick-next");
        } else if (key.equals("Printer")) {
            return By.cssSelector("#epcl-post-carousel-1 > div > div > div:nth-child(9) > div > div > article > a");
        } else if (key.equals("Epson L15150")) {
            return By.cssSelector("#single > div.content.row > div > div > article > section > div.text > div > div.owl-stage-outer > div > div:nth-child(8) > div > a > div.custom_price.two-side-bg > span.alt_satir");
        } else if (key.equals("Blog Slider")) {
            return By.xpath("/html");
        } else if (key.equals("Add to Cart")) {
           return By.xpath("/html/body/div[4]/main/div/div[3]/div/div/div[2]/div/div/div[4]/div/ul/li/form/div[3]/button");
        } else if (key.equals("Kategori Kartus")) {
            return By.cssSelector("#menu > div > nav > ul > li:nth-child(5)");
        } else if (key.equals("Marka Combobox")) {
            return By.cssSelector("#select-search-2 > span > span.selection > span");
        } else if (key.equals("Marka Textbox")) {
            return By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[1]/span[2]/span/span[1]/input");
        } else if (key.equals("Model Combobox")) {
            return By.cssSelector("#select-search-3 > span > span.selection > span");
        } else if (key.equals("Model Textbox")){
            return By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[2]/span[2]/span/span[1]/input");
        } else if (key.equals("Kartus-Toner Ara")) {
            return By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/form/div[1]/div[3]/div/div/a");
        }  else if (key.equals("Siyah Toner")){
            return By.xpath("/html/body/div[4]/main/div[3]/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[1]/div/div[3]/div[3]/form/div[1]/button");
        } else if (key.equals("Teknoloji")){
            return By.cssSelector("#menu > div > nav > ul > li:nth-child(7) > a");
        } else if (key.equals("Buyutec")){
            return By.xpath("/html/body/div[4]/main/div[5]/div/div/div/div/div[2]/div[1]/div/div/div[6]/div[2]");
        }else if (key.equals("Marka Önerme")){
            return By.cssSelector("#brand");
        } else if (key.equals("Model Önerme")){
            return By.cssSelector("#model");
        } else if (key.equals("Ad-Soyad")){
            return By.cssSelector("#user");
        } else if (key.equals("Telefon")){
            return By.cssSelector("#phoneNumber");
        } else if (key.equals("Checkbox")){
            return By.className("checkmark");
        } else if (key.equals("Gonder")){
            return By.cssSelector("#main > div:nth-child(6) > div > div > div > div > div.col-xs-8 > div.section-container > div > div > div.product-demand-module.ng-scope > div:nth-child(3) > div > div > div > product-demand-popup > div > form > button");
        } else if (key.equals("Popup Slider")) {
            return By.cssSelector("#main > div:nth-child(6) > div > div > div > div > div.col-xs-8 > div.section-container > div > div > div.product-demand-module.ng-scope > div:nth-child(3) > div");
        } else {
            throw new IllegalArgumentException("Web identity not found for key: " + key);
        }
    }
}
