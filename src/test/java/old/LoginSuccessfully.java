package old;

import com.sun.tools.javac.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSuccessfully {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.xuanhanh.vn/account/logon");
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruong");
        driver.findElement(By.id("signin-button")).click();
        String fullName = driver.findElement(By.cssSelector(".dd-link .d-sm-inline strong")).getText();
        Assert.check(fullName.equals("GIA NHI"));
        driver.quit();
        String abc = "Hello";
    }

}
