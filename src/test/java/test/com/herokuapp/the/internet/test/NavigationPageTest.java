package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
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
        logTestMethod("Navigation to AB Page");
        String expectedText = "Also known as split testing.";
        softAssertWrapper.softAssertTrue(page.gotoAbTest().findPageText().contains(expectedText),
                "AB Page contains text: '" + expectedText + "'");
    }

    @Test
    public void gotoAddRemoveElementsTest()
    {
        logTestMethod("Navigation to Add/Remove Elements Page");
        softAssertWrapper.softAssertEquals(page.gotoAddRemoveElements().findH3Text(), "Add/Remove Elements");
    }

    @Test
    public void gotoBasicAuthTest()
    {
        logTestMethod("Navigation to Basic Auth Page");
        softAssertWrapper
                .softAssertEquals(page.gotoBasicAuthPage().getTextOnPage(),
                        "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void gotoChallengingDomTest()
    {
        logTestMethod("Navigation to Challenging DOM Page");
        softAssertWrapper.softAssertEquals(page.gotoChallengingDomPage().findH3Text(), "Challenging DOM");
    }
}
