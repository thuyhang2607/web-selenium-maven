package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchProductNotFound extends BaseTest {
    @Test
    public void testSearchProductNotFound() {
        driver.get("https://www.xuanhanh.vn");

        driver.findElement(By.className("search-toggler")).click();
        driver.findElement(By.id("search-box")).sendKeys("a123");
        driver.findElement(By.className("btn-orange")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='col-xs-12']"));// element te bien khong dc trung
        WebElement element2 = driver.findElement(By.xpath("//div[@class='br-orange default-head category-title w-100']"));
        String text = element.getText();// text te bien khong dc trung
        String text2 = element2.getText();
        System.out.println(text);
        System.out.println(text2);
        Assert.assertEquals(text2, "Tìm kiếm: a123");// Display content user fill search
        Assert.assertEquals(text, "Không tìm thấy sản phẩm");// display notifi fail
    }

}
