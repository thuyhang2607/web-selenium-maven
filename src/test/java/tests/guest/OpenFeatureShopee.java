package tests.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Common;

import java.util.ArrayList;

public class OpenFeatureShopee extends BaseTest {
    @Test
    public void testOpenFeatureShopee() {
        String currentTitle = "";
        driver.get("https://www.xuanhanh.vn");

        currentTitle = driver.getTitle();
        System.out.println("1. Title hien tai: " + currentTitle);

        driver.findElement(By.cssSelector(".link.shopee")).click();
        Common.sleep(3);

//        currentTitle = driver.getTitle();
//        System.out.println("2. Title hien tai: " + strCurrentTitle);

        // Chuyen driver sang tab moi
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // tabs = 2  (0: old tab, 1: new tab)
        driver.switchTo().window(tabs.get(1));

        currentTitle = driver.getTitle();
        System.out.println("3. Title moi nhat: " + currentTitle);

//        String strTitle = driver.getTitle();
//        System.out.println(strTitle);
        Assert.assertEquals(currentTitle, "Mỹ phẩm Xuân Hạnh, Cửa hàng trực tuyến | Shopee Việt Nam");

        String strURL = driver.getCurrentUrl();
        System.out.println(strURL);
        Assert.assertEquals(strURL, "https://shopee.vn/xuanhanh.com");
//        WebElement eleLogo = driver.findElement(By.className("section-seller-overview-horizontal__seller-portrait"));
        WebElement eleLogo = driver.findElement(By.cssSelector(".section-seller-overview-horizontal__seller-portrait"));
        System.out.println(eleLogo);
        Assert.assertTrue(eleLogo.isDisplayed());// Kiem tra logo hien thi


    }


}
