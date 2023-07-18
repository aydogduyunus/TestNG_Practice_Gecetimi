package calismaGurubu.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {




        //HARD WAIT METHOD
        public static void bekle(int saniye) {
            try {
                Thread.sleep(saniye * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //Alert ACCEPT
        public static void alertAccept() {
            Driver.getDriver().switchTo().alert().accept();
        }

        //Alert DISMISS
        public static void alertDismiss() {
            Driver.getDriver().switchTo().alert().dismiss();
        }

        //Alert getText()
        public static void alertText() {
            Driver.getDriver().switchTo().alert().getText();
        }

        //Alert promptBox
        public static void alertprompt(String text) {
            Driver.getDriver().switchTo().alert().sendKeys(text);
        }

        //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
        public static void ddmVisibleText(WebElement ddm, String secenek) {
            Select select = new Select(ddm);
            select.selectByVisibleText(secenek);
        }

        //DropDown Index
        public static void ddmIndex(WebElement ddm, int index) {
            Select select = new Select(ddm);
            select.selectByIndex(index);
        }

        //DropDown Value
        public static void ddmValue(WebElement ddm, String secenek) {
            Select select = new Select(ddm);
            select.selectByValue(secenek);
        }

        //SwitchToWindow1
        public static void switchToWindow(int sayi) {
            List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
            Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
        }

        //SwitchToWindow2
        public static void window(int sayi) {
            Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
        }
        //EXPLICIT WAIT METHODS

        //Visible Wait
        public static void visibleWait(WebElement element, int sayi) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
            wait.until(ExpectedConditions.visibilityOf(element));

        }

        //VisibleElementLocator Wait
        public static WebElement visibleWait(By locator, int sayi) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }

        //Alert Wait
        public static void alertWait(int sayi) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
            wait.until(ExpectedConditions.alertIsPresent());

        }

        //Tüm Sayfa ScreenShot
        public static void tumSayfaResmi(String name) {
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + name + ".png";
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            try {
                FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //WebElement ScreenShot
        public static void webElementResmi(WebElement element) {
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

            try {
                FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

