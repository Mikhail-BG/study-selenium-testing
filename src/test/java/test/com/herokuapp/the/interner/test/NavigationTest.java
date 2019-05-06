package test.com.herokuapp.the.interner.test;

import org.junit.Assert;
import org.junit.Test;
import test.com.herokuapp.the.interner.page.StartingPage;

public class NavigationTest extends TestBase
{
    StartingPage page;

    public NavigationTest()
    {
        this.page = new StartingPage(webDriver);
    }

    @Test
    public void login()
    {
        page.gotoAbTest();
        Assert.assertEquals("The Internet", page.getTitle());
    }
}
