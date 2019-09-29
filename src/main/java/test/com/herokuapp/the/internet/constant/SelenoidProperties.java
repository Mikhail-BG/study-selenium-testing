package test.com.herokuapp.the.internet.constant;

/**
 * Selenoid variables constant container.
 */
public final class SelenoidProperties
{
    public static final String HUB_URL;
    public static final boolean ENABLE_VNC;

    static
    {
        HUB_URL = EnvironmentConstant.SELENOID_PROPERTIES.getProperty("HubUrl");
        ENABLE_VNC = Boolean.parseBoolean(EnvironmentConstant.SELENOID_PROPERTIES.getProperty("enableVNC"));
    }

    private SelenoidProperties()
    {
    }
}
