package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicketComponent;
import org.guess880.trac_connector.object.ticket.TracTicketComponents;

public class TracTicketComponentAPI extends
        AbsTracTicketStructFieldAPI<TracTicketComponent, TracTicketComponents> {

    public TracTicketComponentAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketComponentAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected TracTicketComponents newFields() {
        return new TracTicketComponents();
    }

    @Override
    protected TracTicketComponent newField() {
        return new TracTicketComponent();
    }

    @Override
    protected String getFieldName() {
        return "component";
    }

}
