package org.guess880.trac_connector.object.ticket;

import java.util.Date;

public class TracTicketMilestone extends TracTicketStructFieldTemplate {

    public TracTicketMilestone() {
        super();
    }

    public Date getDue() {
        return (Date) getValue(Attribute.DUE);
    }

    public TracTicketMilestone setDue(final Date due) {
        setValue(Attribute.DUE, due);
        return this;
    }

    public Date getCompleted() {
        return (Date) getValue(Attribute.COMPLETED);
    }

    public TracTicketMilestone setCompleted(final Date completed) {
        setValue(Attribute.COMPLETED, completed);
        return this;
    }

    public String getDescription() {
        return (String) getValue(Attribute.DESCRIPTION);
    }

    public TracTicketMilestone setDescription(final String description) {
        setValue(Attribute.DESCRIPTION, description);
        return this;
    }

    protected static class Attribute extends
            TracTicketStructFieldTemplate.Attribute {

        public static final Attribute DUE = new Attribute("due");

        public static final Attribute COMPLETED = new Attribute("completed");

        public static final Attribute DESCRIPTION = new Attribute("description");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
