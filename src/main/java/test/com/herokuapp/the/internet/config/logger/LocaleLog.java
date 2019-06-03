package test.com.herokuapp.the.internet.config.logger;

import org.apache.log4j.Logger;

/**
 * Log configuration.
 */
public final class LocaleLog
{
    private static Logger log = Logger.getLogger(LocaleLog.class.getName());

    private LocaleLog()
    {
    }

    /**
     * Log INFO message.
     */
    public static void info(String message)
    {
        log.info(message);
    }

    /**
     * Log WARN message.
     */
    public static void warn(String message)
    {
        log.warn(message);
    }

    /**
     * Log ERROR message.
     */
    public static void error(String message)
    {
        log.error(message);
    }

    /**
     * Log FATAL message.
     */
    public static void fatal(String message)
    {
        log.fatal(message);
    }

    /**
     * Log DEBUG message.
     */
    public static void debug(String message)
    {
        log.debug(message);
    }
}
