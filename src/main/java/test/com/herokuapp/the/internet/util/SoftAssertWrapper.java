package test.com.herokuapp.the.internet.util;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.collections4.CollectionUtils;
import org.testng.asserts.SoftAssert;

/**
 * ... Wrapper to collect and maintain asserts
 */
public class SoftAssertWrapper
{
    private static final Logger LOGGER = Logger.getLogger(SoftAssertWrapper.class.getName());

    private SoftAssert softAssert;
    private List<AssertionError> errors = new LinkedList<>();

    /**
     * This is default constructor.
     */
    public SoftAssertWrapper()
    {
        LOGGER.setLevel(Level.FINE);
    }

    /**
     * This implementation logs and do assertion.
     */
    public void softAssertEquals(Object actual, Object expected)
    {
        softAssert = new SoftAssert();
        LOGGER.info(TimePrinter.getDateTimeMessage() + " ASSERT :" + actual + " EQUALS TO: " + expected);
        softAssert.assertEquals(actual, expected);
        collectError();
    }

    /**
     * This implementation check if assertion errors occurred.
     *
     * @return false if no errors occurred.
     */
    public boolean isEmpty()
    {
        boolean result = false;
        if (CollectionUtils.isEmpty(errors))
        {
            result = true;
        }
        else
        {
            errors.forEach(Throwable::getMessage);
        }
        return result;
    }

    private void collectError()
    {
        try
        {
            softAssert.assertAll();
        }
        catch (AssertionError ex)
        {
            errors.add(ex);
        }
    }
}
