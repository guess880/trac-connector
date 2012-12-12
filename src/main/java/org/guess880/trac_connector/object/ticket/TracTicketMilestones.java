package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracTicketMilestones extends AbsTracObjects<TracTicketMilestone> {

    public TracTicketMilestones() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketMilestone newElement() {
        final TracTicketMilestone e = new TracTicketMilestone();
        add(e);
        return e;
    }

}
