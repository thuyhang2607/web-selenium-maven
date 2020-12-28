package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.Common;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void initializeTest() {
        WebDriverManager.firefoxdriver().setup();// k cần tải file chrome.exe nữa. mà nó tự tải về
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
        Common.sleep(3);
    }
}
