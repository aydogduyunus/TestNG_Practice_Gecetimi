package calismaGurubu.test.day01;


import calismaGurubu.page.KitapYurduPages;
import calismaGurubu.utilities.ConfigReader;
import calismaGurubu.utilities.Driver;
import calismaGurubu.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class C01_KitapYurdu {

    @Test
    public void test01() {
        // https://www.kitapyurdu.com/ adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("kitapYurduUrl"));


// Arama motorunda "Java" kelimesini aratınız.
        KitapYurduPages kitapYurduPages = new KitapYurduPages();
        kitapYurduPages.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime"), Keys.ENTER);


// Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
    kitapYurduPages.birinciUrunSepeteEkle.click();
        ReusableMethods.bekle(2);
    kitapYurduPages.ikinciUrunSepeteEkle.click();

        ReusableMethods.bekle(2);

//ikinci urun sepete ekle eklendiğini dogrula
        kitapYurduPages.sepetimClick.click();
        Assert.assertTrue(kitapYurduPages.sepettekiUrun.isDisplayed());

// birinci urunun sepete ekle eklendiğini urun listesi ile dogrula
        //Assert.assertTrue(kitapYurduPages.sepettekiIkinciUrun.isDisplayed());
        List<WebElement> urunList = kitapYurduPages.sepetimdekiUrunler;
      /*
        for (int i = 0; i < urunList.size() ; i++) {
            System.out.println(urunList.get(0).getText());
        }

       */
        urunList.forEach(t-> System.out.println(t.getText()));

       Assert.assertEquals(kitapYurduPages.aramaSonucuIlkUrun.getText(),urunList.get(1).getText());


//  İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
//"Alisverişe devam et" fonksiyonunun görünür olmadığını doğrulayınız.
// Ürünlere ait kontrol kutularını seçili hale getiriniz.
// Kontrol kutularının seçili olduğunu doğrulayınız.
// İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
// Kontrol kutularının seçili olduğunu doğrulayınız.
// İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
//"Seçilenleri Daha Sonra Al" fonksiyonunun aktif olduğunu doğrulayınız.

    }
}
