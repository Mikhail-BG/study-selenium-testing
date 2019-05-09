package test.com.herokuapp.the.internet.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.com.herokuapp.the.internet.constant.SetupConstant;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverProducer
{
    public static WebDriver initFirefoxWebDriver()
    {
        System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);

        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static WebDriver initGridWebdriver()
    {
        //System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("firefox");
        //capabilities.setVersion("43");

        WebDriver webDriver;
        try
        {
            webDriver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilities);
            webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            return webDriver;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
