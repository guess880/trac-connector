package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

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
        setGetMultiResultReader(new AttributesAPIObjectReader());
        setGetResultReader(new DataAPIObjectReader());
        setGetParamWriter(new DefaultAPIObjectWriterForGet());
        setUpdateParamWriter(new DefaultAPIObjectWriterForUpdate());
        setDeleteParamWriter(new DefaultAPIObjectWriterForDelete());
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

    private static class AttributesAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public ITracObject read(final ITracObject tracObj, final Object apiObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            final Object[] attrs = (Object[]) apiObj;
            attach.setFilename((String) attrs[0]);
            attach.setDescription((String) attrs[1]);
            attach.setSize((Integer) attrs[2]);
            attach.setTime((Date) attrs[3]);
            attach.setAuthor((String) attrs[4]);
            return attach;
        }
    }

    private static class DataAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final ITracObject tracObj, final Object apiObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            attach.setData((byte[]) apiObj);
            return attach;
        }
    }

    private static class DefaultAPIObjectWriterForGet implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

    private static class DefaultAPIObjectWriterForUpdate implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename(), attach.getDescription(), attach.getData() };
        }

    }

    private static class DefaultAPIObjectWriterForDelete implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

}
