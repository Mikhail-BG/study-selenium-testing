package test.com.herokuapp.the.internet.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utils to load property from property file.
 */
public final class PropertyLoader
{
    private static final Logger LOGGER;

    static
    {
        LOGGER = Logger.getLogger(SetupConstant.class.getName());
    }

    private PropertyLoader()
    {
    }

    /**
     * Loads properties from file.
     *
     * @param propertyFileName filename of property file.
     * @return loaded properties from file.
     */
    public static Properties getProperties(String propertyFileName)
    {
        LOGGER.setLevel(Level.CONFIG);

        final Properties properties = new Properties();
        final InputStream inputStream = SetupConstant.class.getResourceAsStream(propertyFileName);
        try
        {
            properties.load(inputStream);
        }
        catch (IOException ex)
        {
            LOGGER.info(ex.getMessage());
        }

        return properties;
    }
}
