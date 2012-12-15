package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.object.ticket.TracTicketMilestone;
import org.guess880.trac_connector.object.ticket.TracTicketMilestones;

public class TracTicketMilestoneAPI extends
        AbsTracTicketStructFieldAPI<TracTicketMilestone, TracTicketMilestones> {

    public TracTicketMilestoneAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketMilestoneAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    @Override
    protected TracTicketMilestones newFields() {
        return new TracTicketMilestones();
    }

    @Override
    protected TracTicketMilestone newField() {
        return new TracTicketMilestone();
    }

    @Override
    protected String getFieldName() {
        return "milestone";
    }

}
