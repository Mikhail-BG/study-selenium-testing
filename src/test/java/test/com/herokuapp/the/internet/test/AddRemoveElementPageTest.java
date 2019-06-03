package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
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
        page = new AddRemoveElementsPage(LocalWebDriverManager.getFirefoxWebDriver());
        page.openPage();
    }

    @Test
    public void addOneElement()
    {
        logTestMethod("Add one removable element");
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
    }

    @Test
    public void addFiveElements()
    {
        logTestMethod("Add five elements");
        int timesToClickButton = 5;
        page.clickAddButton(timesToClickButton);
        softAssertWrapper.softAssertEquals(timesToClickButton, page.countRemoveElement());
    }

    @Test
    public void removeOneElement()
    {
        logTestMethod("Add and remove one element");
        page.clickAddButton();
        softAssertWrapper.softAssertEquals(1, page.countRemoveElement());
        page.clickDeleteButton();
        softAssertWrapper.softAssertEquals(0, page.countRemoveElement());
    }

    @Test
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
