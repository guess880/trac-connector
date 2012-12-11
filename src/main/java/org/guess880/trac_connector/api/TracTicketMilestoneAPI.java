package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracTicketMilestoneAPI extends TracAPITemplate {

    public TracTicketMilestoneAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketMilestoneAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
