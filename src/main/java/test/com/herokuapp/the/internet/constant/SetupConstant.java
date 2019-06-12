package test.com.herokuapp.the.internet.constant;

import java.util.Properties;

/**
 * Project constant container.
 */
public final class SetupConstant
{
    public static final String GECKODRIVER_WIN;
    public static final String GECKODRIVER_LNX;

    static
    {
        final Properties properties = PropertyLoader.getProperties("/setup.properties");
        GECKODRIVER_WIN = properties.getProperty("geckodriverwin");
        GECKODRIVER_LNX = properties.getProperty("geckodriverlnx");
    }

    private SetupConstant()
    {
    }
}
