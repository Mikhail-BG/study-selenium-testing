package test.com.herokuapp.the.interner.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject
{
    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }
}
