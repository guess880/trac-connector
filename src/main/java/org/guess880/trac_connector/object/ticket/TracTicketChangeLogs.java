package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketChangeLogs extends AbsTracObjects<TracTicketChangeLog> {

    private final TracTicket ticket;

    public TracTicketChangeLogs(final TracTicket ticket) {
        super();
        this.ticket = ticket;
    }

    @Override
    protected TracTicketChangeLog newElement() {
        return new TracTicketChangeLog();
    }

    public TracTicket getTicket() {
        return ticket;
    }

}
