package test.com.herokuapp.the.internet.constant.url;

import java.util.Properties;

import test.com.herokuapp.the.internet.constant.PropertyLoader;

/**
 * URL loader from property file.
 */
public final class HerokuappUrl
{
    public static final String MAIN;
    public static final String ABTEST;
    public static final String ADDREMOVEELEMENTS;
    public static final String BROKENIMAGES;

    private static final String FILENAME = "/herokuapp/herokuapp_url.properties";

    static
    {
        final Properties properties = PropertyLoader.getProperties(FILENAME);
        MAIN = properties.getProperty("url_main");
        ABTEST = properties.getProperty("url_abtest");
        ADDREMOVEELEMENTS = properties.getProperty("url_addremoveelements");
        BROKENIMAGES = properties.getProperty("url_brokenimages");
    }

    private HerokuappUrl()
    {
    }
}
