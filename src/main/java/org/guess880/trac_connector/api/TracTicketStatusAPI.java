package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.object.ticket.TracTicketStatus;
import org.guess880.trac_connector.object.ticket.TracTicketStatuses;

public class TracTicketStatusAPI extends
        AbsTracTicketStructFieldAPI<TracTicketStatus, TracTicketStatuses> {

    private static final String DEPRECATED_MESSAGE = "Deprecated no-op method. Do not use.";

    public TracTicketStatusAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketStatusAPI(final TracAPIConfig cfg)
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
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus get(final String name) throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus delete(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus delete(final String name) throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus create(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus update(final TracTicketStatus field)
            throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

    @Override
    @Deprecated
    public TracTicketStatus update(final String name,
            final TracTicketStatus field) throws XmlRpcException {
        throw new UnsupportedOperationException(DEPRECATED_MESSAGE);
    }

}
