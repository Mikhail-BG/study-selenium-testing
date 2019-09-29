package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.WebDriverManager;
import test.com.herokuapp.the.internet.page.herokuapp.BrokenImagesPage;

public class BrokenImagesPageTest extends PageTestBase<BrokenImagesPage>
{
    private BrokenImagesPage page;

    public BrokenImagesPageTest()
    {
        super("BrokenImagesPageTest");
    }

    @Override
    public BrokenImagesPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new BrokenImagesPage(WebDriverManager.initWebDriver());
        page.openPage();
    }

    @Test
    public void verifyAllImagesNumber()
    {
        logTestMethod("Count all images");
        softAssertWrapper.softAssertEquals(page.countAllImages(), 3);
    }

    @Test
    public void verifyBrokenImagesNumber()
    {
        logTestMethod("Count broken images");
        softAssertWrapper.softAssertEquals(page.countBrokenImages(), 2);
    }
}
