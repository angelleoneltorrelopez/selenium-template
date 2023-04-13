package test.web;

import auxiliary.config.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.web.Product;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class Login extends TestBase {

    pom.web.Login login;
    Product product;
    public void startPom(){
        login = new pom.web.Login(driver);
        product = new Product(driver);
    }

    @Test(description = "Verify iframe")
    public void testIframe(){
        driver.get("https://demoqa.com/frames");
        String mainTap = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.id("frame1"));

        driver.switchTo().frame(iframe);
        String text = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println(text);
        System.out.println(driver.getTitle());
        driver.switchTo().window(mainTap);
        Assert.assertTrue(driver.findElement(By.id("frame2")).isDisplayed());
        //
    }

    @Test(description = "Verify multi tabs")
    public void testTab(){
        driver.get("https://demoqa.com/links");
        String mainTab = driver.getWindowHandle();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> handles = driver.getWindowHandles();

        for (String current:
             handles) {
            System.out.println(current);
            if (!current.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(current);
                driver.get("https://www.ingenieriazeros.com/");
            }
        }
        System.out.println("-------------");
    }

    @Test(description = "Verify scroll")
    public void testC() throws IOException {

        driver.get("https://www.ingenieriazeros.com/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,750)");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\angel\\OneDrive\\Escritorio\\selenium-template/screen.png"));

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){

        };
    }

    @Test(description = "Verify broken links")
    public void testCheckLinks() {
        driver.get("https://demoqa.com/broken");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        HttpURLConnection httpURLConnection = null;

        for (WebElement link:
             links) {
            try {
                String href = link.getAttribute("href");
                System.out.println(href);
                httpURLConnection = (HttpURLConnection) (new URL(href).openConnection());
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();

                System.out.println(httpURLConnection.getResponseCode());
            } catch (Exception e){}

        }
    }

    @Test(description = "Verify login")
    public void testCheckLogin() {
        startPom();
        driver.get("https://www.saucedemo.com/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,750)");
        login.login("standard_user", "secret_sauce");
        Assert.assertEquals(product.getTitle(), "Products");
    }

    @Test(description = "Fail login")
    public void testLoginError() {
        startPom();
        driver.get("https://www.saucedemo.com/");
        login.login("standard_usersdf", "secret_sauce");
        Assert.assertEquals(login.getError(), "Epic sadface: Username and password do not match any user in this service");
    }
}
