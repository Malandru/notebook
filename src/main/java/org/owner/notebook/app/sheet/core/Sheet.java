package org.owner.notebook.app.sheet.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.owner.notebook.app.user.core.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "sheets")
public class Sheet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sheet")
    private Long sheetID;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "sheet_name", nullable = false)
    private String sheetName;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
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
        return user.getUsername();
    }

    @JsonIgnore
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
