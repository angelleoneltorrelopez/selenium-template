package auxiliary.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    protected WebDriver driver;

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void init(@Optional("chrome") String browser){
        System.out.println(System.getProperty("os.name"));

        switch (browser){
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
