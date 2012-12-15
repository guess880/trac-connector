package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;


public class TracTicketTypeAPI extends AbsTracTicketEnumFieldAPI {

    public TracTicketTypeAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketTypeAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected String getFieldName() {
        return "type";
    }

}
