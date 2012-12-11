package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketStatusAPI extends TracAPITemplate {

    public TracTicketStatusAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketStatusAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
