package test.com.herokuapp.the.internet.constant.url;

import test.com.herokuapp.the.internet.constant.PropertyLoader;

import java.util.Properties;

public class HerokuappUrl
{
    private static final String FILENAME = "/herokuapp/herokuapp_url.properties";
    public static String MAIN;
    public static String ABTEST;
    public static String ADDREMOVEELEMENTS;

    static
    {
        Properties properties = PropertyLoader.getProperties(FILENAME);
        MAIN = properties.getProperty("url_main");
        ABTEST = properties.getProperty("url_abtest");
        ADDREMOVEELEMENTS = properties.getProperty("url_addremoveelements");
    }
}
