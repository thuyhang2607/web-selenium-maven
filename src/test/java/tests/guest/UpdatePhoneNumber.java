package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

public class UpdatePhoneNumber extends BaseTest {

    @Test
    public void testUpdatePhoneNumber() {
        driver.get("https://www.xuanhanh.vn/account/logon");
        Common.sleep(3);
        driver.findElement(By.id("email")).sendKeys("loptruong.dao@gmail.com");
        driver.findElement(By.id("password")).sendKeys("loptruong");
        driver.findElement(By.id("signin-button")).click();
        Common.sleep(3);
        driver.findElement(By.cssSelector("a.dd-link .d-none.d-sm-inline")).click(); //Xin chao Gia nhi
        Common.sleep(3);
        driver.findElement(By.partialLinkText("CẬP NHẬT THÔNG TIN CÁ NHÂN")).click();// update profile
        WebElement elePhoneNumber = driver.findElement(By.id("phone"));
        elePhoneNumber.clear();
        elePhoneNumber.sendKeys("0988888888");// Phonenumber
        driver.findElement(By.xpath("//button[contains(text(),'Cập nhật thông tin cá nhân')]")).click();// button update profile
        Common.sleep(2);
        WebElement element = driver.findElement(By.id("notification")); // notification
        String text = element.getText();
        System.out.println(text);
        Assert.assertEquals(text, "Thông tin đã được cập nhật ");
    }


}
