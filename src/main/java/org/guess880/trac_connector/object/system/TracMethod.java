package org.guess880.trac_connector.object.system;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracMethod implements TracObject {

    private String name;

    private TracMethodHelp help;

    private TracMethodSignature signature;

    public TracMethod() {
        super();
    }

    public String getName() {
        return name;
    }

    public TracMethod setName(final String name) {
        this.name = name;
        return this;
    }

    public TracMethodHelp getHelp() {
        if (help == null) {
            help = new TracMethodHelp(getName());
        }
        return help;
    }

    public TracMethod setHelp(final TracMethodHelp help) {
        this.help = help;
        return this;
    }

    public TracMethodSignature getSignature() {
        if (signature == null) {
            signature = new TracMethodSignature(getName());
        }
        return signature;
    }

    public TracMethod setSignature(final TracMethodSignature signature) {
        this.signature = signature;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
