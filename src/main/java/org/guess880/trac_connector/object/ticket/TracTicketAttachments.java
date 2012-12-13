package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketAttachments extends AbsTracObjects<TracTicketAttachment> {

    private final TracTicket ticket;

    public TracTicketAttachments(final TracTicket ticket) {
        super();
        this.ticket = ticket;
    }

    public TracTicket getTicket() {
        return ticket;
    }

    @Override
    protected TracTicketAttachment newElement() {
        return new TracTicketAttachment(getTicket());
    }

}
