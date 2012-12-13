package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.TracAttributeBase;
import org.guess880.trac_connector.object.TracStructBase;

public class TracTicketStructFieldBase extends TracStructBase {

    // TODO difficult to handle
    private String updateKey;

    protected TracTicketStructFieldBase() {
        super();
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public TracTicketStructFieldBase setUpdateKey(final String updateKey) {
        this.updateKey = updateKey;
        return this;
    }

    public String getName() {
        return (String) getValue(Attribute.NAME);
    }

    public TracTicketStructFieldBase setName(final String name) {
        setValue(Attribute.NAME, name);
        return this;
    }

    protected static class Attribute extends TracAttributeBase {

        public static final Attribute NAME = new Attribute("name");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
