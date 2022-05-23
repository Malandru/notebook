package org.owner.notebook.domain.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils
{
    private static DateFormat dbDateFormat;
    private static DateFormat requestDateFormat;

    public final static String DATE_FORMAT_DB = "dd/MM/yyyy";
    public final static String DATE_FORMAT_REQUEST = "dd-MM-yyyy";  // HTML5 default date format is dd-MM-yyyy

    private static DateFormat getDbDateFormatInstance()
    {
        if (dbDateFormat == null)
            dbDateFormat = new SimpleDateFormat(DATE_FORMAT_DB);
        return dbDateFormat;
    }

    private static DateFormat getRequestDateFormatInstance()
    {
        if (requestDateFormat == null)
            requestDateFormat = new SimpleDateFormat(DATE_FORMAT_REQUEST);
        return requestDateFormat;
    }
}
