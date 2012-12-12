package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketChangeLogs extends AbsTracObjects<TracTicketChangeLog> {

    private final TracTicket ticket;

    public TracTicketChangeLogs(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setAPIObjectWriterForGet(new DefaultAPIObjectWriter());
    }

    @Override
    public TracTicketChangeLog newElement() {
        final TracTicketChangeLog e = new TracTicketChangeLog();
        add(e);
        return e;
    }

    public TracTicket getTicket() {
        return ticket;
    }

    private static class DefaultAPIObjectWriter implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketChangeLogs) tracObj).getTicket().getId() };
        }

    }

}
