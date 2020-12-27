package tests.guest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class SearchProduct extends BaseTest {
    @Test
    public void TestSearchProduct() {
        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.className("search-toggler")).click();
        driver.findElement(By.id("search-box")).sendKeys("Khẩu trang y tế kháng khuẩn Hamita");
        driver.findElement(By.className("btn-orange")).click();
        List<WebElement> productsList = driver.findElements(By.className("col-product"));
        Assert.assertTrue(productsList.size() > 0);//
    }
}
