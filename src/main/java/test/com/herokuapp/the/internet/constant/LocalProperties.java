package test.com.herokuapp.the.internet.constant;

/**
 * Local variables constant container.
 */
public final class LocalProperties
{
    public static final String GECKODRIVER;
    public static final String GRID_NODE_URL;

    static
    {
        GECKODRIVER = EnvironmentConstant.LOCAL_PROPERTIES.getProperty("geckodriver");
        GRID_NODE_URL = EnvironmentConstant.LOCAL_PROPERTIES.getProperty("gridnodeurl");
    }

    private LocalProperties()
    {
    }
}
