package test.com.herokuapp.the.interner.constant;

public class HerokuappUrl
{
    private static final String FILENAME = "/herokuapp/herokuapp_url.properties";
    public static String MAIN;

    static
    {
        MAIN = PropertyLoader.getProperties(FILENAME).getProperty("url_main");
    }
}
