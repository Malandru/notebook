package org.owner.finances.notebook.domain.error;

import java.util.UUID;


public class NotFoundException extends RuntimeException
{
    private String classDetails;
    private String targetID;

    public <T> NotFoundException(Class<T> clazz, String targetID)
    {
        this.classDetails = clazz.getName();
        this.targetID = targetID;
    }

    public <T> NotFoundException(Class<T> clazz, UUID targetID)
    {
        this(clazz, targetID.toString());
    }

    public String getClassDetails()
    {
        return classDetails;
    }

    public void setClassDetails(String classDetails)
    {
        this.classDetails = classDetails;
    }

    public String getTargetID()
    {
        return targetID;
    }

    public void setTargetID(String targetID)
    {
        this.targetID = targetID;
    }
}
