package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketEnumFields extends AbsTracObjects<TracTicketEnumField> {

    public TracTicketEnumFields() {
        super();
    }

    @Override
    protected TracTicketEnumField newElement() {
        return new TracTicketEnumField();
    }

}
