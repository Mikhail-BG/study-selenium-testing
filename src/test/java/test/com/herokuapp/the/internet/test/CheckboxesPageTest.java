package test.com.herokuapp.the.internet.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.herokuapp.CheckboxesPage;

public class CheckboxesPageTest extends PageTestBase<CheckboxesPage>
{
    private CheckboxesPage page;

    public CheckboxesPageTest()
    {
        super("CheckboxesPage");
    }

    @Override
    public CheckboxesPage getPage()
    {
        return page;
    }

    @BeforeMethod
    public void initPage()
    {
        page = new CheckboxesPage(LocalWebDriverManager.getFirefoxWebDriver());
        page.openPage();
    }

    @Test
    public void checkboxFirstIsUncheckedOnLoad()
    {
        logTestMethod("Check if checkbox 1 is unchecked when page is loaded");
        softAssertWrapper.softAssertTrue(!page.getStateCheckboxFirst(), "Checkbox 1 is unchecked");
    }

    @Test
    public void checkboxFirstIsChecked()
    {
        logTestMethod("Check that checkbox 1 is checked");
        if (!page.getStateCheckboxFirst())
        {
            page.clickCheckboxFirst();
        }
        softAssertWrapper.softAssertTrue(page.getStateCheckboxFirst(), "Checkbox 1 is checked");
    }

    @Test
    public void checkboxSecondIsCheckedOnLoad()
    {
        logTestMethod("Check if checkbox 2 is checked when page is loaded");
        softAssertWrapper.softAssertTrue(page.getStateCheckboxSecond(), "Checkbox 2 is checked");
    }

    @Test
    public void checkboxSecondIsChecked()
    {
        logTestMethod("Check that checkbox 2 is unchecked");
        if (page.getStateCheckboxSecond())
        {
            page.clickCheckboxSecond();
        }
        softAssertWrapper.softAssertTrue(!page.getStateCheckboxSecond(), "Checkbox 2 is unchecked");
    }
}
