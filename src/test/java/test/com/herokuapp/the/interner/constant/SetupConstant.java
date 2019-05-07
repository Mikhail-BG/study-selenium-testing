package test.com.herokuapp.the.interner.constant;

public class SetupConstant
{
    public static final String GECKODRIVER;

    static
    {
        GECKODRIVER = PropertyLoader.getProperties("/setup.properties").getProperty("geckodriver");
    }
}
