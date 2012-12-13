package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketMilestones extends AbsTracObjects<TracTicketMilestone> {

    public TracTicketMilestones() {
        super();
    }

    @Override
    protected TracTicketMilestone newElement() {
        return new TracTicketMilestone();
    }

}
