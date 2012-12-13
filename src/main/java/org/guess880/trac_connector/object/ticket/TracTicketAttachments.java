package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTicketAttachments extends AbsTracObjects<TracTicketAttachment> {

    private final TracTicket ticket;

    public TracTicketAttachments(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setGetMultiParamWriter(new GetMultiParamWriter());
    }

    public TracTicket getTicket() {
        return ticket;
    }

    @Override
    protected TracTicketAttachment newElement() {
        return new TracTicketAttachment(getTicket());
    }

    private static class GetMultiParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketAttachments) tracObj).getTicket().getId() };
        }
        
    }

}
