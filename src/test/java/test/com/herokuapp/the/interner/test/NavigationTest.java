package test.com.herokuapp.the.interner.test;

import org.junit.Assert;
import org.junit.Test;
import test.com.herokuapp.the.interner.page.herokuapp.MainPage;

public class NavigationTest extends TestBase
{
    private MainPage page;

    public NavigationTest()
    {
        this.page = new MainPage(webDriver);
    }

    @Test
    public void gotoAbTest()
    {
        page.gotoAbTest();
        Assert.assertEquals("The Internet", page.getTitle());
    }

    @Test
    public void gotoAddRemoveElementsTest()
    {
        page.gotoAddRemoveElements();
        Assert.assertEquals("The Internet", page.getTitle());
    }
}
