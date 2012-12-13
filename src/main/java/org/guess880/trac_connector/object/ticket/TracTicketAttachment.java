package org.guess880.trac_connector.object.ticket;

import java.util.Arrays;
import java.util.Date;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTicketAttachment extends TracObjectBase {

    private final TracTicket ticket;

    private String filename;

    private String description;

    private int size;

    private Date time;

    private String author;

    private byte[] data;

    public TracTicketAttachment(final TracTicket ticket) {
        super();
        this.ticket = ticket;
        setGetMultiResultReader(new GetMultiResultReader());
        setGetResultReader(new GetResultReader());
        setGetParamWriter(new GetParamWriter());
        setUpdateParamWriter(new UpdateParamWriter());
        setDeleteParamWriter(new DeleteParamWriter());
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
        return time == null ? null : (Date) time.clone();
    }

    public TracTicketAttachment setTime(final Date time) {
        this.time = time == null ? null : (Date) time.clone();
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
        return data == null ? null : Arrays.copyOf(data, data.length);
    }

    public TracTicketAttachment setData(final byte[] data) {
        this.data = data == null ? null : Arrays.copyOf(data, data.length);
        return setSize(data == null ? 0 : data.length);
    }

    private static class GetMultiResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            final Object[] attrs = (Object[]) result;
            attach.setFilename((String) attrs[0]);
            attach.setDescription((String) attrs[1]);
            attach.setSize((Integer) attrs[2]);
            attach.setTime((Date) attrs[3]);
            attach.setAuthor((String) attrs[4]);
            return attach;
        }
    }

    private static class GetResultReader implements
            TracAPIResultReader {

        @Override
        public TracObjectBase read(final TracObject tracObj, final Object result) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            attach.setData((byte[]) result);
            return attach;
        }
    }

    private static class GetParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

    private static class UpdateParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename(), attach.getDescription(), attach.getData() };
        }

    }

    private static class DeleteParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

}
