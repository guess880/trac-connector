package org.guess880.trac_connector.object.system;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracMethodHelp implements TracObject {

    private final String name;

    private String help;

    public TracMethodHelp(final String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

    public TracMethodHelp setHelp(final String help) {
        this.help = help;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
