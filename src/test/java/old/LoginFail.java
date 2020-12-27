package old;

import com.sun.tools.javac.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginFail {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.xuanhanh.vn/account/logon");
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruongdaaaaaaa");
        driver.findElement(By.id("signin-button")).click();
        String fullName = driver.findElement(By.cssSelector("#error-message div")).getText();
        Assert.check(fullName.equals("Tên đăng nhập hoặc mật khẩu không hợp lệ"));

        driver.close();

    }
}
