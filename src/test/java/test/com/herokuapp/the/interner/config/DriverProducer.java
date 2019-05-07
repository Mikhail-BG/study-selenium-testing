package test.com.herokuapp.the.interner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.com.herokuapp.the.interner.constant.SetupConstant;

import java.util.concurrent.TimeUnit;

public class DriverProducer
{
    public static WebDriver initWebDriver()
    {
        System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
