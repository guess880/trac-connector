package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracAPIObjectWriter;

public class TracTicketComponent extends TracTicketFieldStructTemplate {

    public TracTicketComponent() {
        super();
        setCreateParamWriter(new DefaultCreateParamWriter());
        setUpdateParamWriter(new DefaultUpdateParamWriter());
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
            TracTicketFieldStructTemplate.Attribute {

        public static final Attribute OWNER = new Attribute("owner");

        public static final Attribute DESCRIPTION = new Attribute("description");

        protected Attribute(final String name) {
            super(name);
        }

    }

    private static class DefaultCreateParamWriter implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketComponent component = (TracTicketComponent) tracObj;
            return new Object[] { component.getName(), component.getValues() };
        }

    }

    private static class DefaultUpdateParamWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketComponent component = (TracTicketComponent) tracObj;
            return new Object[] { component.getUpdateKey(), component.getValues() };
        }

    }

}
