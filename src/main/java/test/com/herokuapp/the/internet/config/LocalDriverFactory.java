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
 * WebDriver factory: initialises WebDriver pre-configured instances.
 */
public final class LocalDriverFactory
{
    private LocalDriverFactory()
    {
    }

    /**
     * FireFox browser initializer.
     *
     * @return configured FireFox browser.
     */
    public static WebDriver createFireFoxWebDriver()
    {
        System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);
        System.setProperty("webdriver.firefox.silentOutput", "true");
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

        WebDriver remoteWebDriver;
        try
        {
            remoteWebDriver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilities);
            remoteWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            remoteWebDriver.manage().window().maximize();
        }
        catch (MalformedURLException ex)
        {
            remoteWebDriver = null;
            ex.printStackTrace();
        }
        return remoteWebDriver;
    }
}
