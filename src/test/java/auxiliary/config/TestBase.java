package auxiliary.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @BeforeMethod
    public void init(Object[] args){
        System.out.println(System.getProperty("os.name"));

        switch ("chrome"){
            case "chrome":
                driver = DriverCapabilities.chromeDriver();
                break;
            case "safari":
                driver = DriverCapabilities.safariDriver();
                break;
            case "edge":
                driver = DriverCapabilities.edgeDriver();
                break;
            default:
                driver = DriverCapabilities.firefoxDriver();
                break;
        }
    }
}
