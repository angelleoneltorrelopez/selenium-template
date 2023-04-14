package auxiliary.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
   // protected WebDriver driver;
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @AfterMethod
    public void close(){
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void init(@Optional("chrome") String browser){

        switch (browser){
            case "firefox":
                driver.set(DriverCapabilities.firefoxDriver());
                driver.get();
                break;
            case "safari":
                driver.set(DriverCapabilities.safariDriver());
                driver.get();
                break;
            case "edge":
                driver.set(DriverCapabilities.edgeDriver());
                driver.get();
                break;
            default:
                driver.set(DriverCapabilities.chromeDriver());
                driver.get();
                break;
        }
    }
}
