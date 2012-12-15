package org.guess880.trac_connector;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.api.TracAPIBase;
import org.guess880.trac_connector.api.TracAPIConfig;
import org.guess880.trac_connector.api.TracSearchAPI;
import org.guess880.trac_connector.api.TracSystemAPI;
import org.guess880.trac_connector.api.TracTicketAPI;
import org.guess880.trac_connector.api.TracWikiAPI;

public class TracConnector extends TracAPIBase {

    private TracSearchAPI search;

    private TracSystemAPI system;

    private TracTicketAPI ticket;

    private TracWikiAPI wiki;

    public TracConnector(final XmlRpcClient rpcClient) {
        super(rpcClient);
        newMemberAPI();
    }

    public TracConnector(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
        newMemberAPI();
    }

    private void newMemberAPI() {
        search = new TracSearchAPI(getRpcClient());
        system = new TracSystemAPI(getRpcClient());
        ticket = new TracTicketAPI(getRpcClient());
        wiki = new TracWikiAPI(getRpcClient());
    }

    public TracSearchAPI search() {
        return search;
    }

    public TracSystemAPI system() {
        return system;
    }

    public TracTicketAPI ticket() {
        return ticket;
    }

    public TracWikiAPI wiki() {
        return wiki;
    }

}
