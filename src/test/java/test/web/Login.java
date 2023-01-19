package test.web;

import auxiliary.config.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.web.Product;

public class Login extends TestBase {

    pom.web.Login login;
    Product product;
    public void startPom(){
        login = new pom.web.Login(driver);
        product = new Product(driver);
    }

    @Test(description = "Verify login")
    public void testCheckLogin() {
        startPom();
        driver.get("https://www.saucedemo.com/");
        login.login("standard_user", "secret_sauce");
        Assert.assertEquals(product.getTitle(), "PRODUCTS");
    }

    @Test(description = "Fail login")
    public void testFailLogin() {
        startPom();
        driver.get("https://www.saucedemo.com/");
        login.login("standard_usersdf", "secret_sauce");
        Assert.assertEquals(login.getError(), "Epic sadface: Username and password do not match any user in this service");
    }
}
