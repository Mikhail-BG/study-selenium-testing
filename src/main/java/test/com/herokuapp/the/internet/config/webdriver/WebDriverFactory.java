package test.com.herokuapp.the.internet.config.webdriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.com.herokuapp.the.internet.constant.LocalProperties;
import test.com.herokuapp.the.internet.constant.SelenoidProperties;

/**
 * WebDriver factory: initialises WebDriver pre-configured instances.
 */
public final class WebDriverFactory
{
    private WebDriverFactory()
    {
    }

    /**
     * FireFox browser initializer.
     *
     * @return configured FireFox browser.
     */
    static WebDriver createFireFoxWebDriver()
    {
        initCommonLocalAndGridVariables();

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
        initCommonLocalAndGridVariables();

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("60");

        WebDriver remoteWebDriver;
        try
        {
            remoteWebDriver = new RemoteWebDriver(new URL(LocalProperties.GRID_NODE_URL), capabilities);
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

    static WebDriver initSelenoidWebDriver()
    {
        final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setVersion("77");
        desiredCapabilities.setCapability("enableVNC", SelenoidProperties.ENABLE_VNC);

        try
        {
            final RemoteWebDriver webDriver = new RemoteWebDriver(
                    URI.create(SelenoidProperties.HUB_URL).toURL(),
                    desiredCapabilities
            );
            webDriver.manage().window().maximize();
            return webDriver;
        }
        catch (MalformedURLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private static void initCommonLocalAndGridVariables()
    {
        System.setProperty("webdriver.gecko.driver", LocalProperties.GECKODRIVER);
    }
}
