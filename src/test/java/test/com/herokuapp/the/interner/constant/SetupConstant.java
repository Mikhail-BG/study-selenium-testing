package test.com.herokuapp.the.interner.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetupConstant
{
    public static final Logger LOGGER;
    public static final Properties PROPERTIES;

    public static final String GECKODRIVER;

    static
    {
        LOGGER = Logger.getLogger(SetupConstant.class.getName());
        LOGGER.setLevel(Level.CONFIG);

        PROPERTIES = new Properties();

        InputStream inputStream = SetupConstant.class.getResourceAsStream("/setup.properties");
        try
        {
            PROPERTIES.load(inputStream);
        }
        catch (IOException e)
        {
            LOGGER.info(e.getMessage());
        }

        GECKODRIVER = PROPERTIES.getProperty("geckodriver");
    }
}
