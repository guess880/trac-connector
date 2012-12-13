package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.converter.TracStructGetResultReader;
import org.guess880.trac_connector.object.ticket.TracTicketStructFieldBase;

public abstract class AbsTracTicketStructFieldAPI<O extends TracTicketStructFieldBase, L extends AbsTracObjects<?>> extends TracAPIBase {

    private TracAPIResultReader getAllResultReader;

    private TracAPIParamWriter getAllParamWriter;

    private TracAPIResultReader getResultReader;

    private TracAPIParamWriter getParamWriter;

    private TracAPIParamWriter deleteParamWriter;

    private TracAPIParamWriter createParamWriter;

    private TracAPIParamWriter updateParamWriter;

    public AbsTracTicketStructFieldAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        setUpConverter();
    }

    public AbsTracTicketStructFieldAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        setUpConverter();
    }

    private void setUpConverter() {
        getAllResultReader = new TracMultiResultReader()
                .setOneResultReader(new GetAllResultReader());
        getAllParamWriter = new TracEmptyParamWriter();
        getResultReader = new TracStructGetResultReader();
        getParamWriter = new NameOnlyParamWriter();
        deleteParamWriter = new NameOnlyParamWriter();
        createParamWriter = new CreateParamWriter();
        updateParamWriter = new UpdateParamWriter();
    }

    public L getAll() throws XmlRpcException {
        final L fields = newFields();
        getAllResultReader.read(
                fields,
                getRpcClient().execute(getAPIName("getAll"),
                        getAllParamWriter.write(fields)));
        return fields;
    }

    public O get(final O field)
            throws XmlRpcException {
        getResultReader.read(
                    field,
                    getRpcClient().execute(getAPIName("get"),
                            getParamWriter.write(field)));
        return field;
    }

    public O get(final String name) throws XmlRpcException {
        final O field = newField();
        field.setName(name);
        return get(field);
    }

    public O delete(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"),
                deleteParamWriter.write(field));
        return field;
    }

    public O delete(final String name) throws XmlRpcException {
        final O field = newField();
        field.setName(name);
        return delete(field);
    }

    public O create(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"),
                createParamWriter.write(field));
        return field;
    }

    public O update(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"),
                updateParamWriter.write(field));
        return field;
    }

    public O update(final String name, final O field) throws XmlRpcException {
        field.setUpdateKey(name);
        return update(field);
    }

    protected abstract L newFields();

    protected abstract O newField();

    protected String getAPIName(final String method) {
        return new StringBuilder("ticket.")
            .append(getFieldName())
            .append(".")
            .append(method)
            .toString();
    }

    protected abstract String getFieldName();

    private static class NameOnlyParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketStructFieldBase) tracObj)
                    .getName() };
        }

    }

    private static class GetAllResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketStructFieldBase field = (TracTicketStructFieldBase) tracObj;
            field.setName((String) result);
            return field;
        }

    }

    private static class CreateParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketStructFieldBase field = (TracTicketStructFieldBase) tracObj;
            return new Object[] { field.getName(), field.getValues() };
        }

    }

    private static class UpdateParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketStructFieldBase field = (TracTicketStructFieldBase) tracObj;
            return new Object[] { field.getUpdateKey(), field.getValues() };
        }

    }

}
