package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTicketChangeLogs extends AbsTracObjects<TracTicketChangeLog> {

    private final TracTicket ticket;

    public TracTicketChangeLogs(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setGetMultiParamWriter(new GetMultiParamWriter());
    }

    @Override
    protected TracTicketChangeLog newElement() {
        return new TracTicketChangeLog();
    }

    public TracTicket getTicket() {
        return ticket;
    }

    private static class GetMultiParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketChangeLogs) tracObj).getTicket().getId() };
        }

    }

}
