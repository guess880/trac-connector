package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketPriorityAPI extends TracAPITemplate {

    public TracTicketPriorityAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketPriorityAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
