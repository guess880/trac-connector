package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicketVersion;
import org.guess880.trac_connector.object.ticket.TracTicketVersions;

public class TracTicketVersionAPI extends
        AbsTracTicketStructFieldAPI<TracTicketVersion, TracTicketVersions> {

    public TracTicketVersionAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketVersionAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected TracTicketVersions newFields() {
        return new TracTicketVersions();
    }

    @Override
    protected TracTicketVersion newField() {
        return new TracTicketVersion();
    }

    @Override
    protected String getFieldName() {
        return "version";
    }

}
