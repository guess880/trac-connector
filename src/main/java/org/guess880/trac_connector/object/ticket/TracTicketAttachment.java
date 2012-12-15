package org.guess880.trac_connector.object.ticket;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketAttachment implements TracObject {

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
        return data == null ? new byte[0] : Arrays.copyOf(data, data.length);
    }

    public TracTicketAttachment setData(final byte[] data) {
        this.data = data == null ? null : Arrays.copyOf(data, data.length);
        return setSize(data == null ? 0 : data.length);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
