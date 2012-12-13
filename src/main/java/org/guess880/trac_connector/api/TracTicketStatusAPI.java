package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicketStatus;
import org.guess880.trac_connector.object.ticket.TracTicketStatuses;

public class TracTicketStatusAPI extends
        AbsTracTicketStructFieldAPI<TracTicketStatus, TracTicketStatuses> {

    public TracTicketStatusAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketStatusAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected TracTicketStatuses newFields() {
        return new TracTicketStatuses();
    }

    @Override
    protected TracTicketStatus newField() {
        return new TracTicketStatus();
    }

    @Override
    protected String getFieldName() {
        return "status";
    }

    @Override
    @Deprecated
    public TracTicketStatus get(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus get(final String name) throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus delete(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus delete(final String name) throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus create(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus update(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

    @Override
    @Deprecated
    public TracTicketStatus update(final String name,
            final TracTicketStatus field) throws XmlRpcException {
        throw new UnsupportedOperationException(
                "Deprecated no-op method. Do not use.");
    }

}
