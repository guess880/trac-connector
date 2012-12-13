package org.guess880.trac_connector.object.search;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracSearchFilter implements TracObject {

    private String name;

    private String description;

    public TracSearchFilter() {
        super();
    }

    public String getName() {
        return name;
    }

    public TracSearchFilter setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TracSearchFilter setDescription(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
