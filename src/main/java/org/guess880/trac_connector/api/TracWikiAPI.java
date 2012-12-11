package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;


public class TracWikiAPI extends TracAPITemplate {

    public TracWikiAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracWikiAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
