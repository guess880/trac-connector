package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTicketVersions extends AbsTracObjects<TracTicketVersion> {

    public TracTicketVersions() {
        super();
    }

    @Override
    protected TracTicketVersion newElement() {
        return new TracTicketVersion();
    }

}
