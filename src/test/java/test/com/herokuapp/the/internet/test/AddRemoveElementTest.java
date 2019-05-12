package test.com.herokuapp.the.internet.test;

import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.page.herokuapp.AddRemoveElementsPage;

public class AddRemoveElementTest extends TestBase
{
    private AddRemoveElementsPage page;

    public AddRemoveElementTest()
    {
        super("AddRemoveElementTest");
        this.page = new AddRemoveElementsPage(webDriver);
    }

    @Test(priority = 1)
    public void addOneElement()
    {
        LOGGER.info("Add one removable element");
        page.openPage();
        page.clickAddButton();;
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
    }

    @Test(priority = 2)
    public void removeOneElement()
    {
        LOGGER.info("Add and remove one element");
        page.openPage();
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
        page.removeOneElement();
        softAssertWrapper.softAssertEquals(0, page.countRemoveElement());
    }
}
