package test.com.herokuapp.the.internet.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.com.herokuapp.the.internet.constant.SetupConstant;

/**
 * WebDriver configuration and initializer.
 */
public final class DriverProducer
{
    private DriverProducer()
    {
    }

    /**
     * FireFox Browser initializer.
     *
     * @return FireFox browser
     */
    public static WebDriver initFirefoxWebDriver()
    {
        System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);

        final WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    /**
     * Grid browsers initializer.
     *
     * @return Grid browser.
     */
    public static WebDriver initGridWebdriver()
    {
        //System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("firefox");
        //capabilities.setVersion("43");

        WebDriver webDriver;
        try
        {
            webDriver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilities);
            webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }
        catch (MalformedURLException ex)
        {
            webDriver = null;
            ex.printStackTrace();
        }
        return webDriver;
    }

    /**
     * Browser destroyer.
     */
    public static void destroyWebDriver(WebDriver webDriver)
    {
        webDriver.quit();
    }
}
