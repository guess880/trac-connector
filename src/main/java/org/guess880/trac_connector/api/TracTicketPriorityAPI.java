package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;

public class TracTicketPriorityAPI extends AbsTracTicketEnumFieldAPI {

    public TracTicketPriorityAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketPriorityAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected String getFieldName() {
        return "priority";
    }

}
