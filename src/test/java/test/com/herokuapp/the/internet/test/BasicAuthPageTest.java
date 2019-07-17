package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.herokuapp.BasicAuthPage;

public class BasicAuthPageTest extends PageTestBase<BasicAuthPage>
{
    private BasicAuthPage page;

    public BasicAuthPageTest()
    {
        super("BasicAuthPage");
    }

    @Override
    public BasicAuthPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new BasicAuthPage(LocalWebDriverManager.getFirefoxWebDriver());
        page.openPage();
    }

    @Test
    public void verifyBasicAuth()
    {
        logTestMethod("Verify basic auth with credentials: ");
        softAssertWrapper.softAssertEquals(page.getTextOnPage(), "Congratulations! You must have the proper credentials.");
    }
}
