package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.herokuapp.MainPage;

public class NavigationPageTest extends PageTestBase<MainPage>
{
    private MainPage page;

    public NavigationPageTest()
    {
        super("NavigationPageTest");
    }

    @Override
    public MainPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new MainPage(LocalWebDriverManager.getFirefoxWebDriver());
        page.openPage();
    }

    @Test
    public void gotoAbTest()
    {
        logTestMethod("AB Test");
        softAssertWrapper.softAssertEquals("A/B Test Control", page.gotoAbTest().findH3Text());
    }

    @Test
    public void gotoAddRemoveElementsTest()
    {
        logTestMethod("Add/Remove Elements Test");
        softAssertWrapper.softAssertEquals("Add/Remove Elements", page.gotoAddRemoveElements().findH3Text());
    }
}
