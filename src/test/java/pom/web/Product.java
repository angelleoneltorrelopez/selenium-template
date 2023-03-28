package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Product {

    WebDriver driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement title;

    public Product(WebDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,8);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
    }

    public String getTitle(){
        return title.getText();
    }
}
