package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

import java.util.ArrayList;

public class SearchProductDontHaveOnListProduct extends BaseTest {
    @Test
    public void testSearchProductDontHaveOnListProduct() {
        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.cssSelector(".link.shopee")).click();
        Common.sleep(3);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // tabs = 2  (0: old tab, 1: new tab)
        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.className("shopee-searchbar-input__input")).sendKeys("ilearnautomationtest");// nhap tim kiem
        driver.findElement(By.cssSelector("button.btn.btn-solid-primary.btn--s.btn--inline")).click();// touch icon search
        WebElement eleContentNotification = driver.findElement(By.className("shopee-search-empty-result-section__title"));//content not find product
        String textContentNotification = eleContentNotification.getText();
        Assert.assertEquals(textContentNotification, "Không tìm thấy sản phẩm bạn cần tìm trong Shop này");// check display content notifi true content UI
        WebElement disBntFindProductToAllShoppe = driver.findElement(By.className("shopee-button-solid"));// check display button search product on entry page
        String findProductToAllShoppe = disBntFindProductToAllShoppe.getText();
        Assert.assertEquals(findProductToAllShoppe, "Tìm sản phẩm trên toàn sàn Shopee");//check display content button

    }
}
