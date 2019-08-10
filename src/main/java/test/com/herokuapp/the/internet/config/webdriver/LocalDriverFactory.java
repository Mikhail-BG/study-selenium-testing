package test.com.herokuapp.the.internet.config.webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.com.herokuapp.the.internet.constant.SetupConstant;

/**
 * WebDriver factory: initialises WebDriver pre-configured instances.
 */
public final class LocalDriverFactory
{
    static
    {
        System.setProperty("webdriver.gecko.driver", SetupConstant.GECKODRIVER);
    }

    private LocalDriverFactory()
    {
    }

    /**
     * FireFox browser initializer.
     *
     * @return configured FireFox browser.
     */
    static WebDriver createFireFoxWebDriver()
    {
        System.setProperty("webdriver.firefox.silentOutput", "true");
        //disable Marionette logs
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        //Set Firefox Headless mode as TRUE
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);

        final WebDriver webDriver = new FirefoxDriver(firefoxOptions);
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    /**
     * Grid browsers initializer.
     *
     * @return Grid browser.
     */
    static WebDriver initGridWebDriver()
    {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("60");

        WebDriver remoteWebDriver;
        try
        {
            remoteWebDriver = new RemoteWebDriver(new URL(SetupConstant.GRID_NODE_URL), capabilities);
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
