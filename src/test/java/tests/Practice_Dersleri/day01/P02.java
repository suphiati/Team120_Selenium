package tests.Practice_Dersleri.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {


    public static void main(String[] args) {

        /*
     . .Exercise2...
1-Driver oluşturalim
2-Java class'imiza chnomedriver.exet i tanitalim
3-Driver'in tum ekranı kaplamasini saglayalim
4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
5-"https://www.otto.de" adresine gidelim
6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
8-Ardindan "https://wisequarter.com/" adresine gidip
9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
10-Bir onceki web sayfamiza geri donelim
11-Sayfayı yenileyelim
12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

        // 1-Driver oluşturalim
        System.setProperty("web.driver.chrome", "src/kurulumDosyalari/chromedriver.exe");

        //2-Java class'imiza chnomedriver.exet i tanitalim
        WebDriver driver=new ChromeDriver();

        //3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();

        // 4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        // Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        //5-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");

        //6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        System.out.println(driver.getTitle()); // OTTO - Mode, Möbel & Technik » Zum Online-Shop

        String title= driver.getTitle();
        System.out.println(title); // OTTO - Mode, Möbel & Technik » Zum Online-Shop

        //7-Title ve url inin "OTTO" kelimesinin içerip icermedigini kontrol edelim
        if (driver.getTitle().contains("OTTO") && driver.getCurrentUrl().contains("OTTO")) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        // 8-Ardindan "https://wisequarter.com/" adresine gidip
        // 9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        driver.navigate().to("https://wisequarter.com/");
        if (driver.getTitle().contains("Quarter")){
            System.out.println("Site Quarter iceriyor: Wise Quarte Candir");
        }else {
            System.out.println("wise quarter her daim candir");

            //10-Bir onceki web sayfamiza geri donelim
            driver.navigate().back();

            //11-Sayfayı yenileyelim
            driver.navigate().refresh();

            //12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
            driver.navigate().forward();
            driver.close();

            //13- En son adim olarak butun sayfalarimizi kapatmis olalim
            driver.quit();

        }


    }
}
