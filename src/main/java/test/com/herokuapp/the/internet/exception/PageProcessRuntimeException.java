package test.com.herokuapp.the.internet.exception;

import test.com.herokuapp.the.internet.config.logger.LocaleLog;

/**
 * Exception in a case of processing any element on a page during test run.
 */
public class PageProcessRuntimeException extends RuntimeException
{
    /**
     * Default constructor.
     */
    public PageProcessRuntimeException(String message)
    {
        super(message);
        LocaleLog.error(message);
    }
}
