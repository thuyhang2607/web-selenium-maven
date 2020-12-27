package old;

import com.sun.tools.javac.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProducts {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.xuanhanh.vn");
        System.out.println("----1");
        driver.findElement(By.className("search-toggler111")).click();
        System.out.println("----2");
        driver.findElement(By.id("search-box")).sendKeys("Khẩu trang y tế kháng khuẩn Hamita");
        driver.findElement(By.className("btn-orange")).click();
        List<WebElement> productsList = driver.findElements(By.className("col-product"));
        Assert.check(productsList.size() > 0);
        driver.quit();
        System.out.println("---- Thanh cong");

    }
}
