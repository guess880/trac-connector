package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;

public class TracAPI extends TracAPIBase {

    private TracSearchAPI search;

    private TracSystemAPI system;

    private TracTicketAPI ticket;

    private TracWikiAPI wiki;

    public TracAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        newMemberAPI();
    }

    public TracAPI(final TracAPIConfig cfg)
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
