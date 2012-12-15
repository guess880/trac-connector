package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketActionFields extends
        AbsTracObjects<TracTicketActionField> {

    public TracTicketActionFields() {
        super();
    }

    @Override
    protected TracTicketActionField newElement() {
        return new TracTicketActionField();
    }

}
