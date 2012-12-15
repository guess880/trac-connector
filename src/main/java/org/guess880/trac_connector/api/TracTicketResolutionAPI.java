package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;

public class TracTicketResolutionAPI extends AbsTracTicketEnumFieldAPI {

    public TracTicketResolutionAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketResolutionAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected String getFieldName() {
        return "resolution";
    }

}
