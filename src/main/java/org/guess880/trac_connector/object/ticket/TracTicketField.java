package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracAttribute;
import org.guess880.trac_connector.object.TracStruct;
import org.guess880.trac_connector.object.TrucStructGetResultReader;

public class TracTicketField extends TracStruct {

    public TracTicketField() {
        super();
        setGetMultiResultReader(new TrucStructGetResultReader());
    }

    public String getName() {
        return (String) getValue(Attribute.NAME);
    }

    public TracTicketField setName(final String name) {
        setValue(Attribute.NAME, name);
        return this;
    }

    public String getLabel() {
        return (String) getValue(Attribute.LABEL);
    }

    public TracTicketField setLabel(final String label) {
        setValue(Attribute.LABEL, label);
        return this;
    }

    public String getType() {
        return (String) getValue(Attribute.TYPE);
    }

    public TracTicketField setType(final String type) {
        setValue(Attribute.TYPE, type);
        return this;
    }

    public String getValue() {
        return (String) getValue(Attribute.VALUE);
    }

    public TracTicketField setValue(final String value) {
        setValue(Attribute.VALUE, value);
        return this;
    }

    public String[] getOptions() {
        return (String[]) getValue(Attribute.OPTIONS);
    }

    public TracTicketField setOptions(final String[] options) {
        setValue(Attribute.OPTIONS, options);
        return this;
    }

    public boolean isOptional() {
        return (Boolean) getValue(Attribute.OPTIONAL);
    }

    public TracTicketField setOptional(final boolean optional) {
        setValue(Attribute.OPTIONAL, optional);
        return this;
    }

    public int getOrder() {
        return (Integer) getValue(Attribute.ORDER);
    }

    public TracTicketField setOrder(final int order) {
        setValue(Attribute.ORDER, order);
        return this;
    }

    public String getFormat() {
        return (String) getValue(Attribute.FORMAT);
    }

    public TracTicketField setFormat(final String format) {
        setValue(Attribute.FORMAT, format);
        return this;
    }

    public boolean isCustom() {
        return (Boolean) getValue(Attribute.CUSTOM);
    }

    public TracTicketField setCustom(final boolean custom) {
        setValue(Attribute.CUSTOM, custom);
        return this;
    }

    protected static class Attribute extends AbsTracAttribute {

        public static final Attribute NAME = new Attribute("name");

        public static final Attribute LABEL = new Attribute("label");

        public static final Attribute TYPE = new Attribute("type");

        public static final Attribute VALUE = new Attribute("value");

        public static final Attribute OPTIONS = new Attribute("options");

        public static final Attribute OPTIONAL = new Attribute("optional");

        public static final Attribute ORDER = new Attribute("order");

        public static final Attribute FORMAT = new Attribute("format");

        public static final Attribute CUSTOM = new Attribute("custom");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
