package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketStatuses extends AbsTracObjects<TracTicketStatus> {

    public TracTicketStatuses() {
        super();
    }

    @Override
    protected TracTicketStatus newElement() {
        return new TracTicketStatus();
    }

}
