package pom.web;

import auxiliary.config.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends TestBase {

    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    @FindBy(id="user-name")
    public WebElement inputUser;
    @FindBy(id="password")
    public WebElement inputPassword;
    @FindBy(id="login-button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public  WebElement errorMessage;

    public LoginPage(){
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,8);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
    }

    public void navigateToSauceDemoPage(){
        navigateTo("https://www.saucedemo.com/");
    }

    public void login(String user, String password){
        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public String getError(){
        return errorMessage.getText();
    }
}
