package org.owner.finances.notebook.app.budget.core;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PeriodType
{
    MONTHLY("Every month"),
    YEARLY("Every year");

    private String name;

    PeriodType(String name)
    {
        this.name = name;
    }

    @JsonValue
    public String getName()
    {
        return this.name;
    }
}
