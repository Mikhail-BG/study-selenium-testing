package test.com.herokuapp.the.internet.config.webdriver;

import org.openqa.selenium.WebDriver;

import test.com.herokuapp.the.internet.constant.EnvironmentConstant;

/**
 * WebDriver manager. Creates WebDriver thread, manage of running and killing WebDriver instances.
 */
public final class WebDriverManager
{
    private static ThreadLocal<WebDriver> webDrivers = new ThreadLocal<>();

    private WebDriverManager()
    {
    }

    /**
     * Browser initializer.
     *
     * @return browser based on environment values
     */
    public static WebDriver initWebDriver()
    {
        final WebDriver webDriver;

        switch (EnvironmentConstant.ENVIRONMENT)
        {
            case LOCAL:
            {
                webDriver = getFirefoxWebDriver();
                break;
            }
            case SELENOID:
            {
                webDriver = getSelenoidDriver();
                break;
            }
            default:
            {
                webDriver = null;
                break;
            }
        }
        return webDriver;
    }

    /**
     * Browser destroyer.
     */
    public static void destroyWebDriver(WebDriver webDriver)
    {
        if (webDriver != null)
        {
            webDriver.quit();
        }
        webDrivers.remove();
    }

    private static WebDriver getFirefoxWebDriver()
    {
        final WebDriver webDriver = WebDriverFactory.createFireFoxWebDriver();
        webDrivers.set(webDriver);
        return webDriver;
    }

    private static WebDriver getGridWebDriver()
    {
        final WebDriver webDriver = WebDriverFactory.initGridWebDriver();
        webDrivers.set(webDriver);
        return webDriver;
    }

    private static WebDriver getSelenoidDriver()
    {
        final WebDriver webDriver = WebDriverFactory.initSelenoidWebDriver();
        webDrivers.set(webDriver);
        return webDriver;
    }
}
