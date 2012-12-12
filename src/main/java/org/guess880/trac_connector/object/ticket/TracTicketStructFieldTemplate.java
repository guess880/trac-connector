package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracAttribute;
import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracStruct;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracTicketStructFieldTemplate extends TracStruct {

    // TODO difficult to handle
    private String updateKey;

    public TracTicketStructFieldTemplate() {
        super();
        setGetMultiResultReader(new DefaultGetMultiResultReader());
        setGetParamWriter(new NameOnlyParamWriter());
        setDeleteParamWriter(new NameOnlyParamWriter());
        setCreateParamWriter(new DefaultCreateParamWriter());
        setUpdateParamWriter(new DefaultUpdateParamWriter());
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

    private static class NameOnlyParamWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            return new Object[] { ((TracTicketStructFieldTemplate) tracObj)
                    .getName() };
        }

    }

    private static class DefaultGetMultiResultReader implements
            TracAPIObjectReader {

        @Override
        public ITracObject read(final ITracObject tracObj, final Object apiObj) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            field.setName((String) apiObj);
            return field;
        }

    }

    private static class DefaultCreateParamWriter implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            return new Object[] { field.getName(), field.getValues() };
        }

    }

    private static class DefaultUpdateParamWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketStructFieldTemplate field = (TracTicketStructFieldTemplate) tracObj;
            return new Object[] { field.getUpdateKey(), field.getValues() };
        }

    }

}
