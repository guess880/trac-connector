package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.ticket.TracTicketEnumField;
import org.guess880.trac_connector.object.ticket.TracTicketEnumFields;

public abstract class AbsTracTicketEnumFieldAPI extends TracAPIBase {

    private TracMultiResultReader<TracTicketEnumField, TracTicketEnumFields> getAllResultReader;

    private TracAPIParamWriter<TracTicketEnumFields> getAllParamWriter;

    private TracAPIResultReader<TracTicketEnumField> getResultReader;

    private TracAPIParamWriter<TracTicketEnumField> getParamWriter;

    private TracAPIParamWriter<TracTicketEnumField> deleteParamWriter;

    private TracAPIParamWriter<TracTicketEnumField> createParamWriter;

    private TracAPIParamWriter<TracTicketEnumField> updateParamWriter;

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
        getAllResultReader = new TracMultiResultReader<TracTicketEnumField, TracTicketEnumFields>()
                .setOneResultReader(new GetAllResultReader());
        getAllParamWriter = new TracEmptyParamWriter<TracTicketEnumFields>();
        getResultReader = new GetResultReader();
        getParamWriter = new NameOnlyParamWriter();
        deleteParamWriter = new NameOnlyParamWriter();
        createParamWriter = new NameAndValueParamWriter();
        updateParamWriter = new NameAndValueParamWriter();
    }

    protected TracMultiResultReader<TracTicketEnumField, TracTicketEnumFields> getGetAllResultReader() {
        return getAllResultReader;
    }

    public AbsTracTicketEnumFieldAPI setGetAllResultReader(
            final TracMultiResultReader<TracTicketEnumField, TracTicketEnumFields> getAllResultReader) {
        this.getAllResultReader = getAllResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketEnumFields> getGetAllParamWriter() {
        return getAllParamWriter;
    }

    public AbsTracTicketEnumFieldAPI setGetAllParamWriter(
            final TracAPIParamWriter<TracTicketEnumFields> getAllParamWriter) {
        this.getAllParamWriter = getAllParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicketEnumField> getGetResultReader() {
        return getResultReader;
    }

    public AbsTracTicketEnumFieldAPI setGetResultReader(
            final TracAPIResultReader<TracTicketEnumField> getResultReader) {
        this.getResultReader = getResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketEnumField> getGetParamWriter() {
        return getParamWriter;
    }

    public AbsTracTicketEnumFieldAPI setGetParamWriter(
            final TracAPIParamWriter<TracTicketEnumField> getParamWriter) {
        this.getParamWriter = getParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracTicketEnumField> getDeleteParamWriter() {
        return deleteParamWriter;
    }

    public AbsTracTicketEnumFieldAPI setDeleteParamWriter(
            final TracAPIParamWriter<TracTicketEnumField> deleteParamWriter) {
        this.deleteParamWriter = deleteParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracTicketEnumField> getCreateParamWriter() {
        return createParamWriter;
    }

    public AbsTracTicketEnumFieldAPI setCreateParamWriter(
            final TracAPIParamWriter<TracTicketEnumField> createParamWriter) {
        this.createParamWriter = createParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracTicketEnumField> getUpdateParamWriter() {
        return updateParamWriter;
    }

    public AbsTracTicketEnumFieldAPI setUpdateParamWriter(
            final TracAPIParamWriter<TracTicketEnumField> updateParamWriter) {
        this.updateParamWriter = updateParamWriter;
        return this;
    }

    public TracTicketEnumFields getAll(final TracTicketEnumFields fields)
            throws XmlRpcException {
        getAllResultReader.read(
                fields,
                getRpcClient().execute(getAPIName("getAll"),
                        getAllParamWriter.write(fields)));
        return fields;
    }

    public TracTicketEnumFields getAll() throws XmlRpcException {
        return getAll(new TracTicketEnumFields());
    }

    public TracTicketEnumField get(final TracTicketEnumField field)
            throws XmlRpcException {
        return getResultReader.read(
                field,
                getRpcClient().execute(getAPIName("get"),
                        getParamWriter.write(field)));
    }

    public TracTicketEnumField get(final String name) throws XmlRpcException {
        return get(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField delete(final TracTicketEnumField field)
            throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"),
                deleteParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField delete(final String name) throws XmlRpcException {
        return delete(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField create(final TracTicketEnumField field)
            throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"),
                createParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField update(final TracTicketEnumField field)
            throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"),
                updateParamWriter.write(field));
        return field;
    }

    public TracTicketEnumField update(final String name, final String value)
            throws XmlRpcException {
        return update(new TracTicketEnumField().setName(name).setValue(value));
    }

    protected String getAPIName(final String method) {
        return new StringBuilder("ticket.").append(getFieldName()).append(".")
                .append(method).toString();
    }

    protected abstract String getFieldName();

    private static class GetAllResultReader implements
            TracAPIResultReader<TracTicketEnumField> {

        @Override
        public TracTicketEnumField read(final TracTicketEnumField tracObj,
                final Object result) {
            return tracObj.setName((String) result);
        }

    }

    private static class GetResultReader implements
            TracAPIResultReader<TracTicketEnumField> {

        @Override
        public TracTicketEnumField read(final TracTicketEnumField tracObj,
                final Object result) {
            return tracObj.setValue((String) result);
        }

    }

    private static class NameOnlyParamWriter implements
            TracAPIParamWriter<TracTicketEnumField> {

        @Override
        public Object[] write(final TracTicketEnumField tracObj) {
            return new Object[] { tracObj.getName() };
        }

    }

    private static class NameAndValueParamWriter implements
            TracAPIParamWriter<TracTicketEnumField> {

        @Override
        public Object[] write(final TracTicketEnumField tracObj) {
            return new Object[] { tracObj.getName(), tracObj.getValue() };
        }

    }

}
