package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.herokuapp.ChallengingDomPage;

public class ChallengingDomPageTest extends PageTestBase<ChallengingDomPage>
{
    private ChallengingDomPage page;

    public ChallengingDomPageTest()
    {
        super("Challenging DOM test");
    }

    @Override
    public ChallengingDomPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new ChallengingDomPage(LocalWebDriverManager.getFirefoxWebDriver());
        page.openPage();
    }

    @Test
    public void pressButtonTest()
    {
        logTestMethod("Press button");
        String beforeActionValue = page.readCanvasValue();
        page.pressButton();
        String afterActionValue = page.readCanvasValue();
        boolean valuesAreDifferent = !beforeActionValue.equals(afterActionValue);
        softAssertWrapper.softAssertTrue(valuesAreDifferent, "Value in canvas was changed after button pressing: "
                + "value before: '" + beforeActionValue + "', value after: '" + afterActionValue + "'");
    }

    @Test
    public void pressButtonAlertTest()
    {
        logTestMethod("Press button alert");
        String beforeActionValue = page.readCanvasValue();
        page.pressButton();
        String afterActionValue = page.readCanvasValue();
        boolean valuesAreDifferent = !beforeActionValue.equals(afterActionValue);
        softAssertWrapper.softAssertTrue(valuesAreDifferent, "Value in canvas was changed after button alert pressing: "
                + "value before: '" + beforeActionValue + "', value after: '" + afterActionValue + "'");
    }
}
