package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicketEnumField;
import org.guess880.trac_connector.object.ticket.TracTicketEnumFields;

abstract class AbsTracTicketEnumFieldAPI extends TracAPITemplate {

    protected AbsTracTicketEnumFieldAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    protected AbsTracTicketEnumFieldAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    public TracTicketEnumFields getAll(final TracTicketEnumFields fields) throws XmlRpcException {
        fields.readGetMultiResult(getRpcClient().execute(getAPIName("getAll"), fields.writeGetMultiParam()));
        return fields;
    }

    public TracTicketEnumFields getAll() throws XmlRpcException {
        return getAll(new TracTicketEnumFields());
    }

    public TracTicketEnumField get(final TracTicketEnumField field) throws XmlRpcException {
        field.readGetResult(getRpcClient().execute(getAPIName("get"), field.writeGetParam()));
        return field;
    }

    public TracTicketEnumField get(final String name) throws XmlRpcException {
        return get(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField delete(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"), field.writeDeleteParam());
        return field;
    }

    public TracTicketEnumField delete(final String name) throws XmlRpcException {
        return delete(new TracTicketEnumField().setName(name));
    }

    public TracTicketEnumField create(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"), field.writeCreateParam());
        return field;
    }

    public TracTicketEnumField update(final TracTicketEnumField field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"), field.writeUpdateParam());
        return field;
    }

    public TracTicketEnumField update(final String name, final String value) throws XmlRpcException {
        return update(new TracTicketEnumField().setName(name).setValue(value));
    }

    private String getAPIName(final String method) {
        return new StringBuilder("ticket.")
            .append(getEnumName())
            .append(".")
            .append(method)
            .toString();
    }

    protected abstract String getEnumName();

}
