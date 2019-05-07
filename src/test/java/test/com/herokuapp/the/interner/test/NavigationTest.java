package test.com.herokuapp.the.interner.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.com.herokuapp.the.interner.page.herokuapp.MainPage;

public class NavigationTest extends TestBase
{
    private MainPage page;

    public NavigationTest()
    {
        this.page = new MainPage(webDriver);
    }

    @Test(priority = 1)
    public void gotoAbTest()
    {
        LOGGER.info("AbTest");
        page.openPage();
        page.gotoAbTest();
        Assert.assertEquals("The Internet", page.getTitle());
    }

    @Test(priority = 2)
    public void gotoAddRemoveElementsTest()
    {
        LOGGER.info("AddRemoveElementsTest");
        page.openPage();
        page.gotoAddRemoveElements();
        Assert.assertEquals("The Internet", page.getTitle());
    }
}
