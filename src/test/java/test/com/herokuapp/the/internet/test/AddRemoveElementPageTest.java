package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.DriverProducer;
import test.com.herokuapp.the.internet.page.herokuapp.AddRemoveElementsPage;

public class AddRemoveElementPageTest extends PageTestBase<AddRemoveElementsPage>
{
    private AddRemoveElementsPage page;

    public AddRemoveElementPageTest()
    {
        super("AddRemoveElementPageTest");
    }

    @Override
    public AddRemoveElementsPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new AddRemoveElementsPage(DriverProducer.initFirefoxWebDriver());
        page.openPage();
    }

    @Test(priority = 1)
    public void addOneElement()
    {
        logTestMethod("Add one removable element");
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
    }

    @Test(priority = 2)
    public void addFiveElements()
    {
        logTestMethod("Add five elements");
        int timestoClickButton = 5;
        page.clickAddButton(timestoClickButton);
        softAssertWrapper.softAssertEquals(timestoClickButton, page.countRemoveElement());
    }

    @Test(priority = 3)
    public void removeOneElement()
    {
        logTestMethod("Add and remove one element");
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
        page.clickDeleteButton();
        softAssertWrapper.softAssertEquals(0, page.countRemoveElement());
    }

    @Test(priority = 4)
    public void removeFiveElements()
    {
        logTestMethod("Add and remove five elements");
        int timesToClickButton = 5;
        page.clickAddButton(timesToClickButton);
        softAssertWrapper.softAssertEquals(timesToClickButton, page.countRemoveElement());
        page.clickDeleteButton(timesToClickButton);
        softAssertWrapper.softAssertEquals(0, page.countRemoveElement());
    }
}
