package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTicketEnumField extends TracObjectBase {

    private String name;

    private String value;

    public TracTicketEnumField() {
        super();
        setGetMultiResultReader(new GetMultiResultReader());
        setGetResultReader(new GetResultReader());
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

    private static class GetMultiResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            return ((TracTicketEnumField) tracObj).setName((String) result);
        }
        
    }

    private static class GetResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            return ((TracTicketEnumField) tracObj).setValue((String) result);
        }
        
    }

    private static class NameOnlyParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketEnumField) tracObj).getName() };
        }
        
    }

    private static class NameAndValueParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketEnumField field = (TracTicketEnumField) tracObj;
            return new Object[] { field.getName(), field.getValue() };
        }

    }

}
