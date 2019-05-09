package test.com.herokuapp.the.internet.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimePrinter
{
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";

    private static DateTimeFormatter dateTimeFormatter;

    static
    {
        dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    }

    public static String getDateTimeMessage()
    {
        return "[" + LocalDateTime.now().format(dateTimeFormatter) + "] ";
    }
}
