package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracTicketVersions extends AbsTracObjects<TracTicketVersion> {

    public TracTicketVersions() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketVersion newElement() {
        final TracTicketVersion e = new TracTicketVersion();
        add(e);
        return e;
    }

}
