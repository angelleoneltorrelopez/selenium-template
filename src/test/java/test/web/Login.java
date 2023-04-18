package test.web;

import auxiliary.config.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
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
        login = new pom.web.Login(driver.get());
        product = new Product(driver.get());
    }

    @Test(description = "Verify iframe")
    public void testIframe(){
        driver.get().get("https://demoqa.com/frames");
        String mainTap = driver.get().getWindowHandle();
        WebElement iframe = driver.get().findElement(By.id("frame1"));

        driver.get().switchTo().frame(iframe);
        String text = driver.get().findElement(By.id("sampleHeading")).getText();

        System.out.println(text);
        System.out.println(driver.get().getTitle());
        driver.get().switchTo().window(mainTap);
        Assert.assertTrue(driver.get().findElement(By.id("frame2")).isDisplayed());
        //
    }

    @Test(description = "Verify multi tabs")
    public void testTab(){
        driver.get().get("https://demoqa.com/links");
        String mainTab = driver.get().getWindowHandle();

        ((JavascriptExecutor) driver.get()).executeScript("window.open()");
        ((JavascriptExecutor) driver.get()).executeScript("window.open()");
        Set<String> handles = driver.get().getWindowHandles();

        for (String current:
             handles) {
            System.out.println(current);
            if (!current.equalsIgnoreCase(mainTab)){
                driver.get().switchTo().window(current);
                driver.get().get("https://www.ingenieriazeros.com/");
            }
        }
        System.out.println("-------------");
    }

    @Test(description = "Verify screenshot")
    public void testScreenshot() throws IOException {

        driver.get().get("https://www.ingenieriazeros.com/");
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollBy(0,750)");
        File screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("./screen.png"));

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        };
    }

    @Test(description = "Verify scroll")
    public void testScroll() throws IOException {

        driver.get().get("https://www.ingenieriazeros.com/");
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollBy(0,750)");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        };
    }

    @Test(description = "Verify broken links")
    public void testCheckLinks() {
        driver.get().get("https://demoqa.com/broken");
        List<WebElement> links = driver.get().findElements(By.tagName("a"));

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
        driver.get().get("https://www.saucedemo.com/");
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollBy(0,750)");
        login.login("standard_user", "secret_sauce");
        Assert.assertEquals(product.getTitle(), "Products");
    }

    @Test(description = "Fail login")
    public void testLoginError() {
        startPom();
        driver.get().get("https://www.saucedemo.com/");
        login.login("standard_usersdf", "secret_sauce");
        Assert.assertEquals(login.getError(), "Epic sadface: Username and password do not match any user in this service");
    }
}
