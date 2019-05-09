package test.com.herokuapp.the.internet.util;

import org.apache.commons.collections4.CollectionUtils;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SoftAssertWrapper
{
    private static final Logger LOGGER = Logger.getLogger(SoftAssertWrapper.class.getName());

    private SoftAssert softAssert;
    private List<AssertionError> errors = new LinkedList<>();

    public SoftAssertWrapper()
    {
        LOGGER.setLevel(Level.FINE);
    }

    public void softAssertEquals(String actual, String expected)
    {
        softAssert = new SoftAssert();
        LOGGER.info(TimePrinter.getDateTimeMessage() + " ASSERT :" + actual + " EQUALS TO: " + expected);
        softAssert.assertEquals(actual, expected);
        collectError();
    }

    public boolean isEmpty()
    {
        if (CollectionUtils.isEmpty(errors))
        {
            return true;
        }
        else
        {
            errors.forEach(Throwable::getMessage);
            return false;
        }
    }

    private void collectError()
    {
        try
        {
            softAssert.assertAll();
        }
        catch (AssertionError e)
        {
            errors.add(e);
        }
    }
}
