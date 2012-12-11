package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketComponentAPI extends TracAPITemplate {

    public TracTicketComponentAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketComponentAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
