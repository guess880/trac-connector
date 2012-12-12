package org.guess880.trac_connector.object.ticket;

public class TracTicketComponent extends TracTicketStructFieldTemplate {

    public TracTicketComponent() {
        super();
    }

    public String getOwner() {
        return (String) getValue(Attribute.OWNER);
    }

    public TracTicketComponent setOwner(final String owner) {
        setValue(Attribute.OWNER, owner);
        return this;
    }

    public String getDescription() {
        return (String) getValue(Attribute.DESCRIPTION);
    }

    public TracTicketComponent setDescription(final String description) {
        setValue(Attribute.DESCRIPTION, description);
        return this;
    }

    protected static class Attribute extends
            TracTicketStructFieldTemplate.Attribute {

        public static final Attribute OWNER = new Attribute("owner");

        public static final Attribute DESCRIPTION = new Attribute("description");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
