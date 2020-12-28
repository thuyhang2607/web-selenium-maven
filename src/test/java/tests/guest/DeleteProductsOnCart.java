package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class DeleteProductsOnCart extends BaseTest {
    @Test
    public void testDeleteProductOnCart() {

        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.className("search-toggler")).click();
        driver.findElement(By.id("search-box")).sendKeys("son moi");
        driver.findElement(By.className("btn-orange")).click();
        // tabs = 2  (0: old tab, 1: new tab)
//        driver.switchTo().window(listSaleProducts.get(0));
//        listSaleProducts.get(3).click();
        for (int i = 0; i < 3; i++) { // i
            List<WebElement> listSaleProducts = driver.findElements(By.cssSelector("span.title"));
            WebElement item = listSaleProducts.get(i);
            item.click();
            driver.findElement(By.cssSelector(".btn.btn-success.cart-add-button")).click(); // click Them gio hang
            if (i < 2) {
                for (int j = 0; j < 2; j++) {
                    driver.navigate().back();
                }
            }
        }
        for (int k = 0; k < 3; k++) {
            driver.findElement(By.xpath("//a[contains(text(),'Xóa')]")).click();
        }

        WebElement eleTong = driver.findElement(By.cssSelector(".text-right.mt-3"));
        String textTong = eleTong.getText();
        System.out.println(textTong);
        Assert.assertEquals(textTong, "Tổng: 0 đ");
    }
}
