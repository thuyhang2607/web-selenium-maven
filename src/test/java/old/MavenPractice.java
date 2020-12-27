package old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenPractice {

    public static void main(String[] args) {

        // Selenium WebDriver: ChromeDriver, FirefoxDriver, SafariDriver,....

        WebDriverManager.chromedriver().setup();

        // Initiate your Chrome browser
        WebDriver driver = new ChromeDriver();  // public1234567890@gmail.com

        // Maximize window
        driver.manage().window().maximize();

        // Open browser and navigate to a URL
        driver.get("https://www.xuanhanh.vn/account/logon");

        // Login
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruongdao");
        driver.findElement(By.id("signin-button")).click();

        // Close the browser
        driver.close();
        System.out.println("Ket thuc chuong trinh thanh cong");

    }
}
