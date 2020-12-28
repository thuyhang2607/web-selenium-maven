package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class DeleteProductOnCart extends BaseTest {
    @Test
    public void testDeleteProductOnCart() {

        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.className("search-toggler")).click();
        driver.findElement(By.id("search-box")).sendKeys("son moi");
        driver.findElement(By.className("btn-orange")).click();
        List<WebElement> listSaleProducts = driver.findElements(By.cssSelector("span.title"));
        // tabs = 2  (0: old tab, 1: new tab)
//        driver.switchTo().window(listSaleProducts.get(0));
        listSaleProducts.get(0).click();
//        for (int i = 0; i < listSaleProducts.size(); i++) {
//            if (i == 0) {
//                WebElement item = listSaleProducts.get(i);
//                item.click();
//                break;
//            }
//        }
        driver.findElement(By.cssSelector(".btn.btn-success.cart-add-button")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Xóa')]")).click();
        WebElement eleTong = driver.findElement(By.cssSelector(".text-right.mt-3"));
        String textTong = eleTong.getText();
        System.out.println(textTong);
        Assert.assertEquals(textTong, "Tổng: 0 đ");
    }
}
