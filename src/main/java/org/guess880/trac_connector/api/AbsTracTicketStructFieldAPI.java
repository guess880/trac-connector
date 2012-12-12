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

    public O get(final O milestone)
            throws XmlRpcException {
        milestone.readGetResult(getRpcClient().execute(getAPIName("get"), milestone.writeGetParam()));
        return milestone;
    }

    public O get(final String name) throws XmlRpcException {
        final O milestone = newField();
        milestone.setName(name);
        return get(milestone);
    }

    public O delete(final O milestone) throws XmlRpcException {
        getRpcClient().execute(getAPIName("delete"), milestone.writeDeleteParam());
        return milestone;
    }

    public O delete(final String name) throws XmlRpcException {
        final O milestone = newField();
        milestone.setName(name);
        return delete(milestone);
    }

    public O create(final O milestone) throws XmlRpcException {
        getRpcClient().execute(getAPIName("create"), milestone.writeCreateParam());
        return milestone;
    }

    public O update(final O milestone) throws XmlRpcException {
        getRpcClient().execute(getAPIName("update"), milestone.writeUpdateParam());
        return milestone;
    }

    public O update(final String name, final O milestone) throws XmlRpcException {
        milestone.setUpdateKey(name);
        return update(milestone);
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
