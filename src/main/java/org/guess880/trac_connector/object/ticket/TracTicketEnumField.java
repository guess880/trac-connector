package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracTicketEnumField extends TracObject {

    private String name;

    private String value;

    public TracTicketEnumField() {
        super();
        setGetMultiResultReader(new DefaultGetMultiResultReader());
        setGetResultReader(new DefaultGetResultReader());
        setGetParamWriter(new NameOnlyParamWriter());
        setDeleteParamWriter(new NameOnlyParamWriter());
        setCreateParamWriter(new NameAndValueParamWriter());
        setUpdateParamWriter(new NameAndValueParamWriter());
    }

    public String getName() {
        return name;
    }

    public TracTicketEnumField setName(final String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TracTicketEnumField setValue(final String value) {
        this.value = value;
        return this;
    }

    private static class DefaultGetMultiResultReader implements TracAPIObjectReader {

        @Override
        public ITracObject read(final ITracObject tracObj, final Object apiObj) {
            return ((TracTicketEnumField) tracObj).setName((String) apiObj);
        }
        
    }

    private static class DefaultGetResultReader implements TracAPIObjectReader {

        @Override
        public ITracObject read(final ITracObject tracObj, final Object apiObj) {
            return ((TracTicketEnumField) tracObj).setValue((String) apiObj);
        }
        
    }

    private static class NameOnlyParamWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            return new Object[] { ((TracTicketEnumField) tracObj).getName() };
        }
        
    }

    private static class NameAndValueParamWriter implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketEnumField field = (TracTicketEnumField) tracObj;
            return new Object[] { field.getName(), field.getValue() };
        }

    }

}
