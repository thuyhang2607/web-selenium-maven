package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

import java.util.ArrayList;
import java.util.List;

public class SearchProductHaveOnList extends BaseTest {
    @Test
    public void testSearchProductHaveOnList() {
        driver.get("https://www.xuanhanh.vn");
        driver.findElement(By.cssSelector(".link.shopee")).click();
        Common.sleep(3);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // tabs = 2  (0: old tab, 1: new tab)
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.className("shopee-searchbar-input__input")).sendKeys("duong da");// nhap tim kiem
        driver.findElement(By.cssSelector("button.btn.btn-solid-primary.btn--s.btn--inline")).click();// touch icon search
        WebElement eleDisplaySearchKey = driver.findElement(By.className("shopee-search-result-header__text-highlight"));
        String textDisplaySearchKey = eleDisplaySearchKey.getText();
        System.out.println(textDisplaySearchKey);
        Assert.assertEquals(textDisplaySearchKey, "duong da");
        List<WebElement> eleListProduct = driver.findElements(By.xpath("//div[@data-sqe='name']"));// display to list
        Assert.assertTrue(eleListProduct.size() > 0);//size : dem sp co trong list
    }
}
