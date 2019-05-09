package test.com.herokuapp.the.internet.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.com.herokuapp.the.internet.page.herokuapp.MainPage;

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
        String expectedText = "A/B Test Control";
        page.openPage();
        String actualText = page.gotoAbTest().getH3Text();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 2)
    public void gotoAddRemoveElementsTest()
    {
        LOGGER.info("AddRemoveElementsTest");
        String expectedText = "Add/Remove Elements";
        page.openPage();
        String actualText = page.gotoAddRemoveElements().getH3Text();
        Assert.assertEquals(actualText, expectedText);
    }
}
