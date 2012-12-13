package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketFields extends AbsTracObjects<TracTicketField> {

    public TracTicketFields() {
        super();
    }

    @Override
    protected TracTicketField newElement() {
        return new TracTicketField();
    }

}
