package tests.Practice_Dersleri.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class P01 {

    /*
1-Driver oluşturalim
2-Java class'imiza chnomedriver. exe'yi tanitalim
3-Driver'in tum ekranı kaplamasini sagu ayalim
4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
 Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
5-Navigate to http://www.babayigit.net/murat/testpage.html
6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
    alanlarına gerekli bilgileri yazsın
7-Submit tuşuna bassın.
8- All information was entered correctly.. yazısının göründüğünü test etsin ve yazdırsın
9- Clear butonu ile tüm butonları temizlesin
10- Manuel olarak temizlendiğini görecek kadar beklesin
11- Sayfayı kapatsın
10-8. maddededeki Test sonucunu yazdırsın
 */

    public static void main(String[] args) throws InterruptedException {
        //1-Driver oluşturalim
        //2-Java class'imiza chnomedriver. exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        //3-Driver'in tum ekranı kaplamasini sagu ayalim
        driver.manage().window().maximize();
        //4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        // Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //5-Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("http://www.babayigit.net/murat/testpage.html");
        //6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        //    alanlarına gerekli bilgileri yazsın
        /*
        firstname textbox
        //input[@type='text'][1]
        //input[@id='ad'] --xpath olsa böyle yazarız
       //input[@name='ad']
         */
        driver.findElement(By.id("ad")).sendKeys("Suphi Atılım");
        driver.findElement(By.id("soyad")).sendKeys("Çeliköz");
        driver.findElement(By.id("yas")).sendKeys("35");
        driver.findElement(By.id("meslek")).sendKeys("Mühendis");
        driver.findElement(By.id("dogum_yeri")).sendKeys("İzmir");
        driver.findElement(By.id("mezun_okul")).sendKeys("Dokuz Eylul University");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("0");
       // 7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //8- All information was entered correctly.. yazısının göründüğünü test etsin ve yazdırsın
        String expectedResult="All information was entered correctly..";
        String actualResult= driver.findElement(By.xpath("//p[text()=All information was entered correctly..]")).getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        //9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
        //10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(5000);
        //11- Sayfayı kapatsın
        driver.close();









    }
}
