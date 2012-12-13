package org.guess880.trac_connector.object.ticket;

import java.util.Date;

public class TracTicketVersion extends TracTicketStructFieldTemplate {

    public TracTicketVersion() {
        super();
    }

    public Date getTime() {
        return (Date) getValue(Attribute.TIME);
    }

    public TracTicketVersion setTime(final Date time) {
        setValue(Attribute.TIME, time);
        return this;
    }

    public String getDescription() {
        return (String) getValue(Attribute.DESCRIPTION);
    }

    public TracTicketVersion setDescription(final String description) {
        setValue(Attribute.DESCRIPTION, description);
        return this;
    }

    protected static class Attribute extends
            TracTicketStructFieldTemplate.Attribute {

        public static final Attribute TIME = new Attribute("time");

        public static final Attribute DESCRIPTION = new Attribute("description");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
