package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracTicketFields extends AbsTracObjects<TracTicketField> {

    public TracTicketFields() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    public TracTicketField newElement() {
        final TracTicketField e = new TracTicketField();
        add(e);
        return e;
    }

}
