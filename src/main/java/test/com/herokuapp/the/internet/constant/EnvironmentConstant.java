package test.com.herokuapp.the.internet.constant;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * Project constant container.
 */
public final class EnvironmentConstant
{
    public static final EnvironmentValue ENVIRONMENT;
    public static final Properties SELENOID_PROPERTIES;
    public static final Properties LOCAL_PROPERTIES;

    private EnvironmentConstant()
    {
    }

    static
    {
        final String environmentVariable = System.getenv("Environment");

        if (StringUtils.isEmpty(environmentVariable))
        {
            ENVIRONMENT = EnvironmentValue.LOCAL;
        }
        else
        {
            ENVIRONMENT = EnvironmentValue.valueOf(environmentVariable.toUpperCase());
        }

        SELENOID_PROPERTIES = PropertyLoader.getProperties("/environment/selenoid.properties");

        if (System.getProperty("os.name").contains("Win"))
        {
            LOCAL_PROPERTIES = PropertyLoader.getProperties("/environment/localsetup/win.properties");
        }
        else
        {
            LOCAL_PROPERTIES = PropertyLoader.getProperties("/environment/localsetup/lnx.properties");
        }
    }

    /**
     * This documents environments.
     */
    public enum EnvironmentValue
    {
        LOCAL("local"),
        SELENOID("selenoid");

        private String strValue;

        EnvironmentValue(String strValue)
        {
            this.strValue = strValue;
        }

        public String getStrValue()
        {
            return strValue;
        }
    }
}
