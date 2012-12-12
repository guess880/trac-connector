package org.guess880.trac_connector.object.ticket;

import java.util.Map;

import org.guess880.trac_connector.attr.TracTicketFiledAttributes;
import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracStruct;

public class TracTicketField extends TracStruct {

    public TracTicketField() {
        setAPIObjectReader(new DefaultAPIObjectReader());
    }

    public String getName() {
        return (String) getValue(TracTicketFiledAttributes.NAME);
    }

    public TracTicketField setName(final String name) {
        setValue(TracTicketFiledAttributes.NAME, name);
        return this;
    }

    public String getLabel() {
        return (String) getValue(TracTicketFiledAttributes.LABEL);
    }

    public TracTicketField setLabel(final String label) {
        setValue(TracTicketFiledAttributes.LABEL, label);
        return this;
    }

    public String getType() {
        return (String) getValue(TracTicketFiledAttributes.TYPE);
    }

    public TracTicketField setType(final String type) {
        setValue(TracTicketFiledAttributes.TYPE, type);
        return this;
    }

    public String getValue() {
        return (String) getValue(TracTicketFiledAttributes.VALUE);
    }

    public TracTicketField setValue(final String value) {
        setValue(TracTicketFiledAttributes.VALUE, value);
        return this;
    }

    public String[] getOptions() {
        return (String[]) getValue(TracTicketFiledAttributes.OPTIONS);
    }

    public TracTicketField setOptions(final String[] options) {
        setValue(TracTicketFiledAttributes.OPTIONS, options);
        return this;
    }

    public boolean isOptional() {
        return (Boolean) getValue(TracTicketFiledAttributes.OPTIONAL);
    }

    public TracTicketField setOptional(final boolean optional) {
        setValue(TracTicketFiledAttributes.OPTIONAL, optional);
        return this;
    }

    public int getOrder() {
        return (Integer) getValue(TracTicketFiledAttributes.ORDER);
    }

    public TracTicketField setOrder(final int order) {
        setValue(TracTicketFiledAttributes.ORDER, order);
        return this;
    }

    public String getFormat() {
        return (String) getValue(TracTicketFiledAttributes.FORMAT);
    }

    public TracTicketField setFormat(final String format) {
        setValue(TracTicketFiledAttributes.FORMAT, format);
        return this;
    }

    public boolean isCustom() {
        return (Boolean) getValue(TracTicketFiledAttributes.CUSTOM);
    }

    public TracTicketField setCustom(final boolean custom) {
        setValue(TracTicketFiledAttributes.CUSTOM, custom);
        return this;
    }

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @SuppressWarnings("unchecked")
        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracTicketField field = (TracTicketField) tracObj;
            field.setValues((Map<String, Object>) apiObj);
            return field;
        }

    }

}
