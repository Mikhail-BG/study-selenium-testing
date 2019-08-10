package test.com.herokuapp.the.internet.config.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * WebDriver manager. Creates WebDriver thread, manage of running and killing WebDriver instances.
 */
public final class LocalWebDriverManager
{
    private static ThreadLocal<WebDriver> webDrivers = new ThreadLocal<>();

    private LocalWebDriverManager()
    {
    }

    /**
     * FireFox Browser initializer.
     *
     * @return FireFox browser
     */
    public static WebDriver getFirefoxWebDriver()
    {
        final WebDriver webDriver = LocalDriverFactory.createFireFoxWebDriver();
        webDrivers.set(webDriver);
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
        webDrivers.get();
    }

    /**
     * GRID Browser initializer.
     *
     * @return GRID Firefox browser
     */
    public static WebDriver getGridWebDriver()
    {
        final WebDriver webDriver = LocalDriverFactory.initGridWebDriver();
        webDrivers.set(webDriver);
        return webDriver;
    }
}
