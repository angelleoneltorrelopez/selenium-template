package pom.web;

import auxiliary.config.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage extends TestBase {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement title;

    public ProductPage(){
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,8);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
    }

    public String getTitle(){
        return title.getText();
    }
}
