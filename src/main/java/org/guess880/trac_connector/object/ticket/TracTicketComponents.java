package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketComponents extends AbsTracObjects<TracTicketComponent> {

    public TracTicketComponents() {
        super();
    }

    @Override
    protected TracTicketComponent newElement() {
        return new TracTicketComponent();
    }

}
