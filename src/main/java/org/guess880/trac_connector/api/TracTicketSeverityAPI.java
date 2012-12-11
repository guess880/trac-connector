package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketSeverityAPI extends TracAPITemplate {

    public TracTicketSeverityAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketSeverityAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
