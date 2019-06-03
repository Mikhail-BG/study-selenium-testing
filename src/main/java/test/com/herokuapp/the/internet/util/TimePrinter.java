package test.com.herokuapp.the.internet.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Use to get or print current time.
 */
public final class TimePrinter
{
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";

    private static DateTimeFormatter dateTimeFormatter;

    static
    {
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    }

    private TimePrinter()
    {
    }

    /**
     * Print current Date and Time.
     *
     * @return formatted Date and Time message.
     */
    public static String getDateTimeMessage()
    {
        return "[" + LocalDateTime.now().format(dateTimeFormatter) + "] ";
    }
}
