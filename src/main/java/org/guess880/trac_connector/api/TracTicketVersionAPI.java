package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketVersionAPI extends TracAPITemplate {

    public TracTicketVersionAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketVersionAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
