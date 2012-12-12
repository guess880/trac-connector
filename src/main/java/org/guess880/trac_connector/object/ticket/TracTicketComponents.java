package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracTicketComponents extends AbsTracObjects<TracTicketComponent> {

    public TracTicketComponents() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketComponent newElement() {
        final TracTicketComponent e = new TracTicketComponent();
        add(e);
        return e;
    }

}
