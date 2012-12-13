package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.ticket.TracTicketEnumField;
import org.guess880.trac_connector.object.ticket.TracTicketEnumFields;

abstract class AbsTracTicketEnumFieldAPI extends TracAPIBase {

    private TracAPIResultReader getAllResultReader;

    private TracAPIParamWriter getAllParamWriter;

    private TracAPIResultReader getResultReader;

    private TracAPIParamWriter getParamWriter;

    private TracAPIParamWriter deleteParamWriter;

    private TracAPIParamWriter createParamWriter;

    private TracAPIParamWriter updateParamWriter;

    protected AbsTracTicketEnumFieldAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        setUpConverter();
    }

    protected AbsTracTicketEnumFieldAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        setUpConverter();
    }

    private void setUpConverter() {
        getAllResultReader = new TracMultiResultReader()
                .setOneResultReader(new GetAllResultReader());
        getAllParamWriter = new TracEmptyParamWriter();
        getResultReader = new GetResultReader();
        getParamWriter = new NameOnlyParamWriter();
        deleteParamWriter = new NameOnlyParamWriter();
        createParamWriter = new NameAndValueParamWriter();
        updateParamWriter = new NameAndValueParamWriter();
    }

    public TracTicketEnumFields getAll(final TracTicketEnumFields fields) throws XmlRpcException {
        getAllResultReader.read(
                fields,
                getRpcClient().execute(getAPIName("getAll"),
                        getAllParamWriter.write(fields)));
        return fields;
    }

    public TracTicketEnumFields getAll() throws XmlRpcException {
        return getAll(new TracTicketEnumFields());
    }

    public TracTicketEnumField get(final TracTicketEnumField field) throws XmlRpcException {
        getResultReader.read(
                field,
                getRpcClient().execute(getAPIName("get"),
                        getParamWriter.write(field)));
        return field;
    }

    public TracTicketEnumField get(final String name) throws XmlRpcException {
        return get(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField delete(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"),
                deleteParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField delete(final String name) throws XmlRpcException {
        return delete(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField create(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"),
                createParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField update(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"),
                updateParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField update(final String name, final String value) throws XmlRpcException {
        return update(new TracTicketEnumField().setName(name).setValue(value));
    }

    protected String getAPIName(final String method) {
        return new StringBuilder("ticket.")
            .append(getFieldName())
            .append(".")
            .append(method)
            .toString();
    }

    protected abstract String getFieldName();

    private static class GetAllResultReader implements TracAPIResultReader {

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
