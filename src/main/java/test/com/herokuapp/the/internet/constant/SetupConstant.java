package test.com.herokuapp.the.internet.constant;

import java.util.Properties;

/**
 * Project constant container.
 */
public final class SetupConstant
{
    public static final String GECKODRIVER;
    public static final String GRID_NODE_URL;

    static
    {
        final Properties properties;
        if (System.getProperty("os.name").contains("Win"))
        {
            properties = PropertyLoader.getProperties("/setup/win.properties");
        }
        else
        {
            properties = PropertyLoader.getProperties("/setup/lnx.properties");

        }
        GECKODRIVER = properties.getProperty("geckodriver");
        GRID_NODE_URL = properties.getProperty("gridnodeurl");
    }

    private SetupConstant()
    {
    }
}
