package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketAttachments extends AbsTracObjects<TracTicketAttachment> {

    private final TracTicket ticket;

    public TracTicketAttachments(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setAPIObjectWriterForGet(new DefaultAPIObjectWriterForGet());
    }

    protected TracTicket getTicket() {
        return ticket;
    }

    public int getId() {
        return getTicket().getId();
    }

    @Override
    public TracTicketAttachment newElement() {
        final TracTicketAttachment attach = new TracTicketAttachment(getTicket());
        add(attach);
        return attach;
    }

    private static class DefaultAPIObjectWriterForGet implements TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketAttachments) tracObj).getId() };
        }
        
    }

}
