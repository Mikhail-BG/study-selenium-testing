package test.com.herokuapp.the.internet.constant;

public class SetupConstant
{
    public static final String GECKODRIVER;

    static
    {
        GECKODRIVER = PropertyLoader.getProperties("/setup.properties").getProperty("geckodriver");
    }
}
