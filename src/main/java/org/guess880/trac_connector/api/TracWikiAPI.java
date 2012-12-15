package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;


public class TracWikiAPI extends TracAPIBase {

    public TracWikiAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracWikiAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

}
