package test.com.herokuapp.the.internet.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyLoader
{
    private static final Logger LOGGER;

    static
    {
        LOGGER = Logger.getLogger(SetupConstant.class.getName());
    }

    public static Properties getProperties(String propertyFileName)
    {
        LOGGER.setLevel(Level.CONFIG);

        Properties properties = new Properties();
        InputStream inputStream = SetupConstant.class.getResourceAsStream(propertyFileName);
        try
        {
            properties.load(inputStream);
        }
        catch (IOException e)
        {
            LOGGER.info(e.getMessage());
        }

        return properties;
    }
}
