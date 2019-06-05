package test.com.herokuapp.the.internet.util;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.testng.asserts.SoftAssert;

import test.com.herokuapp.the.internet.config.logger.LocaleLog;

/**
 * ... Wrapper to collect and maintain asserts
 */
public class SoftAssertWrapper
{
    private SoftAssert softAssert;
    private List<AssertionError> errors = new LinkedList<>();

    /**
     * This is default constructor.
     */
    public SoftAssertWrapper()
    {
    }

    /**
     * Asserts if two instances are equal.
     */
    public void softAssertEquals(Object actual, Object expected)
    {
        softAssert = new SoftAssert();
        final String logMessage = "ASSERT: " + actual + " EQUALS TO: " + expected;
        LocaleLog.info(logMessage);
        if (actual.getClass() != expected.getClass())
        {
            throw new RuntimeException("ACTUAL and EXPECTED are instances of different classes: ACTUAL: '"
                    + actual.getClass().getSimpleName() + "' EXPECTED: '" + expected.getClass().getSimpleName() + "'");
        }
        else
        {
            softAssert.assertEquals(actual, expected);
        }
        collectError();
    }

    /**
     * Asserts if statement is true.
     */
    public void softAssertTrue(boolean condition, String message)
    {
        softAssert = new SoftAssert();
        LocaleLog.info("ASSERT that TRUE: " + message);
        softAssert.assertTrue(condition);
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
            errors.forEach(error -> LocaleLog.error(error.getMessage()));
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
