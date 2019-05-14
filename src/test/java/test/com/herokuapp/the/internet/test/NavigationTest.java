package test.com.herokuapp.the.internet.test;

import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.page.herokuapp.MainPage;

public class NavigationTest extends TestBase
{
    private MainPage page;

    public NavigationTest()
    {
        super("NavigationTest");
    }

    @Test(priority = 1)
    public void gotoAbTest()
    {
        logTestMethod("AB Test");
        page = new MainPage(getWebDriver());
        String expectedText = "A/B Test Control";
        page.openPage();
        String actualText = page.gotoAbTest().findH3Text();
        softAssertWrapper.softAssertEquals(actualText, expectedText);
    }

    @Test(priority = 2)
    public void gotoAddRemoveElementsTest()
    {
        logTestMethod("Add/Remove Elements Test");
        page = new MainPage(getWebDriver());
        String expectedText = "Add/Remove Elements";
        page.openPage();
        String actualText = page.gotoAddRemoveElements().getH3Text();
        softAssertWrapper.softAssertEquals(actualText, expectedText);
    }
}
