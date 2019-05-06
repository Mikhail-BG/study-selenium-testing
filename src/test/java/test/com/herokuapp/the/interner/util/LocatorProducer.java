package test.com.herokuapp.the.interner.util;

import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocatorProducer
{
    public static final Logger LOGGER;
    private static Properties LOCATORS;

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

    public static By get(String fileName, String locatorName)
    {
        try
        {
            InputStream inputStream = LocatorProducer.class.getResourceAsStream(fileName);
            LOCATORS.load(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String propertyValue = LOCATORS.getProperty(locatorName);
        return getLocator(propertyValue);
    }

    private static By getLocator(String locator)
    {
        String[] locatorItems = locator.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);
        String locatorValue = locatorItems[1];

        switch (locatorType)
        {
            case id:
            {
                return By.id(locatorValue);
            }
            case className:
            {
                return By.className(locatorValue);
            }
            case name:
            {
                return By.name(locatorValue);
            }
            case css:
            {
                return By.cssSelector(locatorValue);
            }
            case xpath:
            {
                return By.xpath(locatorValue);
            }
            case tag:
            {
                return By.tagName(locatorValue);
            }
            case text:
            {
                return By.linkText(locatorValue);
            }
            case parText:
            {
                return By.partialLinkText(locatorValue);
            }
            default:
            {
                throw new IllegalArgumentException("No such argument: " + locatorItems[0]);
            }
        }
    }
}

