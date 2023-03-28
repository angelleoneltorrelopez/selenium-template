package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {
    WebDriver driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    @FindBy(id = "user-name")
    public WebElement inputUser;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "login-button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public  WebElement errorMessage;

    public Login(WebDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,8);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
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
