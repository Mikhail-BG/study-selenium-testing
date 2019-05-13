package test.com.herokuapp.the.internet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Super class for Page objects.
 */
public abstract class AbstractPageObject
{
    private static String filename;

    private String url;
    private WebDriver webDriver;

    /**
     * Default constructor.
     */
    public AbstractPageObject(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Open the page.
     */
    public abstract void openPage();

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public static String getFilename()
    {
        return filename;
    }

    public static void setFilename(String filename)
    {
        AbstractPageObject.filename = filename;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Read page title.
     * @return title of the page.
     */
    public String readTitle()
    {
        return webDriver.getTitle();
    }

    /**
     * Forward the page.
     */
    public void goBack()
    {
        webDriver.navigate().back();
    }
}
