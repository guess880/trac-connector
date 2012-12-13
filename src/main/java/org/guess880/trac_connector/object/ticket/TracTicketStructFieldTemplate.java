package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracAttribute;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracStructTemplate;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTicketStructFieldTemplate extends TracStructTemplate {

    // TODO difficult to handle
    private String updateKey;

    public TracTicketStructFieldTemplate() {
        super();
        setGetMultiResultReader(new GetMultiResultReader());
        setGetParamWriter(new NameOnlyParamWriter());
        setDeleteParamWriter(new NameOnlyParamWriter());
        setCreateParamWriter(new CreateParamWriter());
        setUpdateParamWriter(new UpdateParamWriter());
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public TracTicketStructFieldTemplate setUpdateKey(final String updateKey) {
        this.updateKey = updateKey;
        return this;
    }

    public String getName() {
        return (String) getValue(Attribute.NAME);
    }

    public TracTicketStructFieldTemplate setName(final String name) {
        setValue(Attribute.NAME, name);
        return this;
    }

    protected static class Attribute extends AbsTracAttribute {

        public static final Attribute NAME = new Attribute("name");

        protected Attribute(final String name) {
            super(name);
        }

    }

    private static class NameOnlyParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketStructFieldTemplate) tracObj)
                    .getName() };
        }

    }

    private static class GetMultiResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            field.setName((String) result);
            return field;
        }

    }

    private static class CreateParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            return new Object[] { field.getName(), field.getValues() };
        }

    }

    private static class UpdateParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            return new Object[] { field.getUpdateKey(), field.getValues() };
        }

    }

}
