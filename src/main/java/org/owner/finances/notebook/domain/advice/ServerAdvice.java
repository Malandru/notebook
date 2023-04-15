package org.owner.finances.notebook.domain.advice;

import org.owner.finances.notebook.domain.utils.StringUtils;
import org.springframework.http.HttpStatus;

public class ServerAdvice
{
    private String title;
    private String details;
    private String uniqueID;
    private HttpStatus httpStatus;
    private boolean displayMessage;
    private String debugMessage;

    public ServerAdvice(
            String title,
            String details,
            String uniqueID,
            HttpStatus httpStatus,
            boolean displayMessage,
            String debugMessage)
    {
        this.title = title;
        this.details = details;
        this.uniqueID = uniqueID;
        this.httpStatus = httpStatus;
        this.displayMessage = displayMessage;
        this.debugMessage = debugMessage;
    }

    public ServerAdvice(String title, String details, HttpStatus httpStatus)
    {
        this(title, details, null, httpStatus, false, null);
    }

    public ServerAdvice(String title, String details, String uniqueID, HttpStatus httpStatus)
    {
        this(title, details, uniqueID, httpStatus, false, null);
    }

    public ServerAdvice(Exception e) {
        this(
                "Unhandled server exception",
                e.toString(),
                null,
                HttpStatus.INTERNAL_SERVER_ERROR,
                true,
                StringUtils.getStackTrace(e));
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getUniqueID()
    {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID)
    {
        this.uniqueID = uniqueID;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus)
    {
        this.httpStatus = httpStatus;
    }

    public boolean isDisplayMessage()
    {
        return displayMessage;
    }

    public void setDisplayMessage(boolean displayMessage)
    {
        this.displayMessage = displayMessage;
    }

    public String getDebugMessage()
    {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage)
    {
        this.debugMessage = debugMessage;
    }
}
