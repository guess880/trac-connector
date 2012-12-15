package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketActions extends AbsTracObjects<TracTicketAction> {

    private final TracTicket ticket;

    public TracTicketActions(final TracTicket ticket) {
        super();
        this.ticket = ticket;
    }

    public TracTicket getTicket() {
        return ticket;
    }

    @Override
    protected TracTicketAction newElement() {
        return new TracTicketAction();
    }

}
