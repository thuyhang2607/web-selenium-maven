package tests.guest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

public class LoginFail extends BaseTest {

    @Test
    public void testLoginFailed() {
        driver.get("https://www.xuanhanh.vn/account/logon");
        Common.sleep(3);
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruongdaaaaaaa");
        driver.findElement(By.id("signin-button")).click();
        String fullName = driver.findElement(By.cssSelector("#error-message div")).getText();
        Assert.assertEquals(fullName, "Tên đăng nhập hoặc mật khẩu không hợp lệ");
    }

}
