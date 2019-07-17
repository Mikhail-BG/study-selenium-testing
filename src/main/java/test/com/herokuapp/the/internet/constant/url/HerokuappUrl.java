package test.com.herokuapp.the.internet.constant.url;

import java.util.Properties;

import test.com.herokuapp.the.internet.constant.PropertyLoader;

/**
 * URL loader from property file.
 */
public final class HerokuappUrl
{
    public static final String MAIN;
    public static final String AB_TEST;
    public static final String ADD_REMOVE_ELEMENTS;
    public static final String BASIC_AUTH;
    public static final String BROKEN_IMAGES;

    private static final String FILENAME = "/herokuapp/herokuapp_url.properties";

    static
    {
        final Properties properties = PropertyLoader.getProperties(FILENAME);
        MAIN = properties.getProperty("url_main");
        AB_TEST = properties.getProperty("url_abtest");
        ADD_REMOVE_ELEMENTS = properties.getProperty("url_addremoveelements");
        BASIC_AUTH = properties.getProperty("url_basicauth");
        BROKEN_IMAGES = properties.getProperty("url_brokenimages");
    }

    private HerokuappUrl()
    {
    }
}
