package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracTicketVersions extends AbsTracObjects<TracTicketVersion> {

    public TracTicketVersions() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    protected TracTicketVersion newElement() {
        return new TracTicketVersion();
    }

}
