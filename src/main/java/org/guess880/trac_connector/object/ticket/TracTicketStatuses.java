package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracTicketStatuses extends AbsTracObjects<TracTicketStatus> {

    public TracTicketStatuses() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    protected TracTicketStatus newElement() {
        return new TracTicketStatus();
    }

}
