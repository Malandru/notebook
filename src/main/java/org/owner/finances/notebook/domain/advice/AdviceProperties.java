package org.owner.finances.notebook.domain.advice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AdviceProperties
{
    private String notFoundMessage;
    private String notAllowedMessage;

    public String getNotFoundMessage()
    {
        return notFoundMessage;
    }

    public void setNotFoundMessage(String notFoundMessage)
    {
        this.notFoundMessage = notFoundMessage;
    }

    public String getNotAllowedMessage()
    {
        return notAllowedMessage;
    }

    public void setNotAllowedMessage(String notAllowedMessage)
    {
        this.notAllowedMessage = notAllowedMessage;
    }
}
