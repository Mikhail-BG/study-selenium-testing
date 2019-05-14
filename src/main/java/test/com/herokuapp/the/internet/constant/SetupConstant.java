package test.com.herokuapp.the.internet.constant;

/**
 * Project constant container.
 */
public final class SetupConstant
{
    public static final String GECKODRIVER;

    static
    {
        GECKODRIVER = PropertyLoader.getProperties("/setup.properties").getProperty("geckodriver");
    }

    private SetupConstant()
    {
    }
}
