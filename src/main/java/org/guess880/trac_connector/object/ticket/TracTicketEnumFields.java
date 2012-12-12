package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracEmptyAPIObjectWriter;

public class TracTicketEnumFields extends AbsTracObjects<TracTicketEnumField> {

    public TracTicketEnumFields() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketEnumField newElement() {
        final TracTicketEnumField e = new TracTicketEnumField();
        add(e);
        return e;
    }

}
