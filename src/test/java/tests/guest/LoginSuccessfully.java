package tests.guest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

public class LoginSuccessfully extends BaseTest {

    @Test
    public void TestLoginSucss() {
        driver.get("https://www.xuanhanh.vn/account/logon");
        Common.sleep(3);
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruong");
        driver.findElement(By.id("signin-button")).click();
        String fullName = driver.findElement(By.cssSelector(".dd-link .d-sm-inline strong")).getText();
        Assert.assertEquals(fullName, "GIA NHI");
    }

}
