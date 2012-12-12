package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracAPIObjectWriter;

public class TracTicketAttachments extends AbsTracObjects<TracTicketAttachment> {

    private final TracTicket ticket;

    public TracTicketAttachments(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setGetMultiParamWriter(new DefaultAPIObjectWriterForGet());
    }

    public TracTicket getTicket() {
        return ticket;
    }

    @Override
    public TracTicketAttachment newElement() {
        final TracTicketAttachment attach = new TracTicketAttachment(getTicket());
        add(attach);
        return attach;
    }

    private static class DefaultAPIObjectWriterForGet implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            return new Object[] { ((TracTicketAttachments) tracObj).getTicket().getId() };
        }
        
    }

}
