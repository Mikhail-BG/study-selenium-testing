package test.com.herokuapp.the.internet.test;

import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.page.herokuapp.AddRemoveElementsPage;

public class AddRemoveElementTest extends TestBase
{
    private AddRemoveElementsPage page;

    public AddRemoveElementTest()
    {
        super("AddRemoveElementTest");
    }

    @Test(priority = 1)
    public void addOneElement()
    {
        logTestMethod("Add one removable element");
        page = new AddRemoveElementsPage(getWebDriver());
        page.openPage();
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
    }

    @Test(priority = 2)
    public void removeOneElement()
    {
        logTestMethod("Add and remove one element");
        page = new AddRemoveElementsPage(getWebDriver());
        page.openPage();
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
        page.removeOneElement();
        softAssertWrapper.softAssertEquals(0, page.countRemoveElement());
    }
}
