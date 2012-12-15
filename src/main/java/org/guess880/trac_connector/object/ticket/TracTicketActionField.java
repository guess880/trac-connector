package org.guess880.trac_connector.object.ticket;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketActionField implements TracObject {

    private String name;

    private String value;

    private Object[] options;

    public String getName() {
        return name;
    }

    public TracTicketActionField setName(final String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TracTicketActionField setValue(final String value) {
        this.value = value;
        return this;
    }

    public Object[] getOptions() {
        return options == null ? new Object[0] : Arrays.copyOf(options, options.length);
    }

    public TracTicketActionField setOptions(final Object[] options) {
        this.options = options == null ? null : Arrays.copyOf(options,
                options.length);
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
