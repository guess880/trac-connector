package org.guess880.trac_connector.object.ticket;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracEmptyAPIObjectWriter;

public class TracTicketFields extends AbsTracObjects<TracTicketField> {

    public TracTicketFields() {
        super();
        setAPIObjectWriterForGet(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracTicketField newElement() {
        final TracTicketField e = new TracTicketField();
        add(e);
        return e;
    }

}
