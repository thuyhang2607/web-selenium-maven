package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

public class ViewCartEmpty1 extends BaseTest {
    @Test
    public void testViewCartEmpty() {
        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.id("mini-cart")).click();  // Click vao Cart
        driver.findElement(By.cssSelector(".checkout-item .btn-success")).click();//click vao xem gio hang
        Common.sleep(3);
        WebElement sum = driver.findElement(By.cssSelector(".text-right.mt-3 h2"));
        String text = sum.getText();
        System.out.println(text);
        Assert.assertEquals(text, "Tổng: 0 đ");
        WebElement elementUpdateCart = driver.findElement(By.cssSelector(".btn.btn-general"));
        String textUpdateCart = elementUpdateCart.getText();
        System.out.println(textUpdateCart);
        Assert.assertEquals(textUpdateCart.trim(), "Cập nhật giỏ hàng");
//        WebElement btnOrder = driver.findElement(By.xpath("//button[text()=\"Đặt mua\"]")); //casch 1
        WebElement btnOrder = driver.findElement(By.cssSelector("div.text-right button.btn-success"));
        Assert.assertTrue(btnOrder.isDisplayed());

    }
}
