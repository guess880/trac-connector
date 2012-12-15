package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;

public class TracTicketSeverityAPI extends AbsTracTicketEnumFieldAPI {

    public TracTicketSeverityAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketSeverityAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected String getFieldName() {
        return "severity";
    }

}
