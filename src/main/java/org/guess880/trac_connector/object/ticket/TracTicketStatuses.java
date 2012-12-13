package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracTicketStatuses extends AbsTracObjects<TracTicketStatus> {

    public TracTicketStatuses() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketStatus newElement() {
        final TracTicketStatus e = new TracTicketStatus();
        add(e);
        return e;
    }

}
