package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.converter.TracStructGetResultReader;
import org.guess880.trac_connector.object.ticket.TracTicketStructFieldBase;

public abstract class AbsTracTicketStructFieldAPI<O extends TracTicketStructFieldBase, L extends AbsTracObjects<O>>
        extends TracAPIBase {

    private TracMultiResultReader<O, L> getAllResultReader;

    private TracAPIParamWriter<L> getAllParamWriter;

    private TracStructGetResultReader<O> getResultReader;

    private TracAPIParamWriter<O> getParamWriter;

    private TracAPIParamWriter<O> deleteParamWriter;

    private TracAPIParamWriter<O> createParamWriter;

    private TracAPIParamWriter<O> updateParamWriter;

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
        getAllResultReader = new TracMultiResultReader<O, L>()
                .setOneResultReader(new GetAllResultReader());
        getAllParamWriter = new TracEmptyParamWriter<L>();
        getResultReader = new TracStructGetResultReader<O>();
        getParamWriter = new NameOnlyParamWriter();
        deleteParamWriter = new NameOnlyParamWriter();
        createParamWriter = new CreateParamWriter();
        updateParamWriter = new UpdateParamWriter();
    }

    public L getAll() throws XmlRpcException {
        final L fields = newFields();
        return getAllResultReader.read(
                fields,
                getRpcClient().execute(getAPIName("getAll"),
                        getAllParamWriter.write(fields)));
    }

    public O get(final O field) throws XmlRpcException {
        return getResultReader.read(
                field,
                getRpcClient().execute(getAPIName("get"),
                        getParamWriter.write(field)));
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
        return new StringBuilder("ticket.").append(getFieldName()).append(".")
                .append(method).toString();
    }

    protected abstract String getFieldName();

    private class NameOnlyParamWriter implements TracAPIParamWriter<O> {

        @Override
        public Object[] write(final O tracObj) {
            return new Object[] { tracObj.getName() };
        }

    }

    private class GetAllResultReader implements TracAPIResultReader<O> {

        @Override
        public O read(final O tracObj, final Object result) {
            tracObj.setName((String) result);
            return tracObj;
        }

    }

    private class CreateParamWriter implements TracAPIParamWriter<O> {

        @Override
        public Object[] write(final O tracObj) {
            return new Object[] { tracObj.getName(), tracObj.getValues() };
        }

    }

    private class UpdateParamWriter implements TracAPIParamWriter<O> {

        @Override
        public Object[] write(final O tracObj) {
            return new Object[] { tracObj.getUpdateKey(), tracObj.getValues() };
        }

    }

}
