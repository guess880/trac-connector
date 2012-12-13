package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracTicketMilestones extends AbsTracObjects<TracTicketMilestone> {

    public TracTicketMilestones() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    protected TracTicketMilestone newElement() {
        return new TracTicketMilestone();
    }

}
