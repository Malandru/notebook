package org.owner.notebook.app.movement.core;

import javax.persistence.*;

@Entity(name = "tags")
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long tagID;

    @Column(nullable = false)
    private String value;

    public Long getTagID()
    {
        return tagID;
    }

    public void setTagID(Long tagID)
    {
        this.tagID = tagID;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
