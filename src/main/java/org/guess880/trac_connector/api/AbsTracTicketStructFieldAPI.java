package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.ticket.TracTicketStructFieldTemplate;

public abstract class AbsTracTicketStructFieldAPI<O extends TracTicketStructFieldTemplate, L extends AbsTracObjects<?>> extends TracAPITemplate {

    public AbsTracTicketStructFieldAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public AbsTracTicketStructFieldAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    public L getAll() throws XmlRpcException {
        final L fields = newFields();
        fields.readGetMultiResult(getRpcClient().execute(getAPIName("getAll"), fields.writeGetMultiParam()));
        return fields;
    }

    public O get(final O field)
            throws XmlRpcException {
        field.readGetResult(getRpcClient().execute(getAPIName("get"), field.writeGetParam()));
        return field;
    }

    public O get(final String name) throws XmlRpcException {
        final O field = newField();
        field.setName(name);
        return get(field);
    }

    public O delete(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"), field.writeDeleteParam());
        return field;
    }

    public O delete(final String name) throws XmlRpcException {
        final O field = newField();
        field.setName(name);
        return delete(field);
    }

    public O create(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"), field.writeCreateParam());
        return field;
    }

    public O update(final O field) throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"), field.writeUpdateParam());
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

}
