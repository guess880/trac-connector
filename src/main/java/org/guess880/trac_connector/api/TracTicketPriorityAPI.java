package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;

public class TracTicketPriorityAPI extends AbsTracTicketEnumFieldAPI {

    public TracTicketPriorityAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketPriorityAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected String getEnumName() {
        return "priority";
    }

}
