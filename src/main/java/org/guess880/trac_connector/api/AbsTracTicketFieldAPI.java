package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;

public abstract class AbsTracTicketFieldAPI<O, L> extends TracAPITemplate {

    public AbsTracTicketFieldAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public AbsTracTicketFieldAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

//    public L getAll() {
//        
//    }

}
