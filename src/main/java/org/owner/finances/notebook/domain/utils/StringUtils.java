package org.owner.finances.notebook.domain.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringUtils
{
    private final static StringWriter sw = new StringWriter();
    private final static PrintWriter pw = new PrintWriter(sw);

    public static String getStackTrace(Exception e)
    {
        e.printStackTrace(pw);
        return sw.toString();
    }
}
