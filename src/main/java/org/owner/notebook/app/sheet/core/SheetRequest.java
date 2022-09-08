package org.owner.notebook.app.sheet.core;

import java.util.Date;

public class SheetRequest
{
    private Long sheetID;
    private String username;
    private String sheetName;
    private Date startDate;
    private Date endDate;

    public Long getSheetID()
    {
        return sheetID;
    }

    public void setSheetID(Long sheetID)
    {
        this.sheetID = sheetID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getSheetName()
    {
        return sheetName;
    }

    public void setSheetName(String sheetName)
    {
        this.sheetName = sheetName;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}
