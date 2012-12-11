package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketAttachment extends TracObject {

    private final TracTicket ticket;

    private String filename;

    private String description;

    private int size;

    private Date time;

    private String author;

    private byte[] data;

    public TracTicketAttachment(final TracTicket ticket) {
        this.ticket = ticket;
        setAPIObjectReader(new DefaultAPIObjectReader());
        setAPIObjectWriterForGet(new DefaultAPIObjectWriterForGet());
        setAPIObjectWriterForUpdate(new DefaultAPIObjectWriterForUpdate());
    }

    protected TracTicket getTicket() {
        return ticket;
    }

    public int getId() {
        return getTicket().getId();
    }

    public String getFilename() {
        return filename;
    }

    public TracTicketAttachment setFilename(final String filename) {
        this.filename = filename;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TracTicketAttachment setDescription(final String description) {
        this.description = description;
        return this;
    }

    public int getSize() {
        return size;
    }

    public TracTicketAttachment setSize(final int size) {
        this.size = size;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public TracTicketAttachment setTime(final Date time) {
        this.time = time;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public TracTicketAttachment setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public byte[] getData() {
        return data;
    }

    public TracTicketAttachment setData(final byte[] data) {
        this.data = data;
        return setSize(data.length);
    }

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            if (apiObj instanceof Object[]) {
                final Object[] attrs = (Object[]) apiObj;
                attach.setFilename((String) attrs[0]);
                attach.setDescription((String) attrs[1]);
                attach.setSize((Integer) attrs[2]);
                attach.setTime((Date) attrs[3]);
                attach.setAuthor((String) attrs[4]);
            } else {
                attach.setData((byte[]) apiObj);
            }
            return attach;
        }
    }

    private static class DefaultAPIObjectWriterForGet implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

    private static class DefaultAPIObjectWriterForUpdate implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename(), attach.getDescription(), attach.getData() };
        }

    }

}
