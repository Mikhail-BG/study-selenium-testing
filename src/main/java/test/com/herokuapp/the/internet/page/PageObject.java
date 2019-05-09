package test.com.herokuapp.the.internet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject
{
    protected static String FILENAME;

    protected String url;
    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public abstract void openPage();

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }

    public void goBack()
    {
        webDriver.navigate().back();
    }
}
