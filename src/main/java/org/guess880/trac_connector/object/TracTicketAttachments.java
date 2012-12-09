package org.guess880.trac_connector.object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TracTicketAttachments extends TracObject implements Iterable<TracTicketAttachment> {

    private final TracTicket ticket;

    private final List<TracTicketAttachment> list;

    public TracTicketAttachments(final TracTicket ticket) {
        this.ticket = ticket;
        this.list = new ArrayList<TracTicketAttachment>();
        setAPIObjectReader(new TracTicketAttachmentsAPIObjectReader());
        setAPIObjectWriterForGet(new TracTicketAttachmentsAPIObjectWriter());
    }

    public int getId() {
        return ticket.getId();
    }

    public TracTicketAttachment newAttachment() {
        final TracTicketAttachment attach = new TracTicketAttachment(ticket);
        list.add(attach);
        return attach;
    }

    public boolean remove(final TracTicketAttachment attachment) {
        return list.remove(attachment);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<TracTicketAttachment> iterator() {
        return list.iterator();
    }

    private static class TracTicketAttachmentsAPIObjectReader implements TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracTicketAttachments attaches = (TracTicketAttachments) tracObj;
            attaches.clear();
            final Object[] objAry = (Object[]) apiObj;
            for (Object obj : objAry) {
                attaches.newAttachment().readAPIObject(obj);
            }
            return attaches;
        }
        
    }

    private static class TracTicketAttachmentsAPIObjectWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketAttachments) tracObj).getId() };
        }
        
    }

}
