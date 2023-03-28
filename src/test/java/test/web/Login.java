package test.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.web.LoginPage;
import pom.web.ProductPage;

public class Login {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(description = "Verify login")
    public void testCheckLogin() {
        loginPage.navigateToSauceDemoPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productPage.getTitle(), "Products");
    }

    @Test(description = "Fail login")
    public void testLoginError() {
        loginPage.navigateToSauceDemoPage();
        loginPage.login("standard_usersdf", "secret_sauce");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }
}
