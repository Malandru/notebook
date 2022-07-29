package org.owner.notebook.domain.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.owner.notebook.domain.utils.StringUtils;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties({"message", "localizedMessage","cause", "stackTrace","suppressed"})
public class ServerError extends RuntimeException
{
    private String title;
    private String details;
    private HttpStatus httpStatus;
    private boolean displayMessage;
    private String debugMessage;

    public ServerError(
            String title,
            String details,
            HttpStatus httpStatus,
            boolean displayMessage,
            String debugMessage)
    {
        this.title = title;
        this.details = details;
        this.httpStatus = httpStatus;
        this.displayMessage = displayMessage;
        this.debugMessage = debugMessage;
    }

    public ServerError(String title, String details, HttpStatus httpStatus)
    {
        this(title, details, httpStatus, false, null);
    }

    public ServerError(Exception e) {
        this(
                "Unhandled server exception",
                e.toString(),
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
