package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracTicketEnumFields extends AbsTracObjects<TracTicketEnumField> {

    public TracTicketEnumFields() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    public TracTicketEnumField newElement() {
        final TracTicketEnumField e = new TracTicketEnumField();
        add(e);
        return e;
    }

}
