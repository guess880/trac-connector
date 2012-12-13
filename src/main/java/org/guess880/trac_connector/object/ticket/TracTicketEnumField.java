package org.guess880.trac_connector.object.ticket;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketEnumField implements TracObject {

    private String name;

    private String value;

    public TracTicketEnumField() {
        super();
    }

    public String getName() {
        return name;
    }

    public TracTicketEnumField setName(final String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TracTicketEnumField setValue(final String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
