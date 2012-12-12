package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketResolutionAPI extends TracAPITemplate {

    public TracTicketResolutionAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketResolutionAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}