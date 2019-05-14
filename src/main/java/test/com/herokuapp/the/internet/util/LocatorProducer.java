package test.com.herokuapp.the.internet.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;

/**
 * Utils for locators loading from property files.
 */
public final class LocatorProducer
{
    private static final Logger LOGGER;
    private static final Properties LOCATORS;

    /**
     * Locator types that can be used.
     */
    private enum LocatorType
    {
        id, className, name, css, xpath, tag, text, parText
    }

    static
    {
        LOGGER = Logger.getLogger(LocatorProducer.class.getName());
        LOGGER.setLevel(Level.CONFIG);
        LOCATORS = new Properties();
    }

    private LocatorProducer()
    {
    }

    /**
     * Get locator by its name from property file.
     * @param fileName source of locators.
     * @param locatorName locator name in property file.
     * @return By object for WebDriver.
     */
    public static By get(String fileName, String locatorName)
    {
        try
        {
            final InputStream inputStream = LocatorProducer.class.getResourceAsStream(fileName);
            LOCATORS.load(inputStream);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        final String propertyValue = LOCATORS.getProperty(locatorName);
        return getLocator(propertyValue);
    }

    private static By getLocator(String locator)
    {
        final String[] locatorItems = locator.split("=", 2);
        final LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);
        final String locatorValue = locatorItems[1];
        final By by;

        switch (locatorType)
        {
            case id:
            {
                by = By.id(locatorValue);
                break;
            }
            case className:
            {
                by = By.className(locatorValue);
                break;
            }
            case name:
            {
                by = By.name(locatorValue);
                break;
            }
            case css:
            {
                by = By.cssSelector(locatorValue);
                break;
            }
            case xpath:
            {
                by = By.xpath(locatorValue);
                break;
            }
            case tag:
            {
                by = By.tagName(locatorValue);
                break;
            }
            case text:
            {
                by = By.linkText(locatorValue);
                break;
            }
            case parText:
            {
                by = By.partialLinkText(locatorValue);
                break;
            }
            default:
            {
                throw new IllegalArgumentException("No such argument: " + locatorItems[0]);
            }
        }
        return by;
    }
}

