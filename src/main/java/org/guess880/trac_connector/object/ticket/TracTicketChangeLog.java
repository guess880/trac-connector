package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketChangeLog implements TracObject {

    private Date time;

    private String author;

    private String field;

    private String oldvalue;

    private String newvalue;

    private int permanent;

    public TracTicketChangeLog() {
        super();
    }

    public Date getTime() {
        return time == null ? null : (Date) time.clone();
    }

    public TracTicketChangeLog setTime(final Date time) {
        this.time = time == null ? null : (Date) time.clone();
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public TracTicketChangeLog setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public String getField() {
        return field;
    }

    public TracTicketChangeLog setField(final String field) {
        this.field = field;
        return this;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public TracTicketChangeLog setOldvalue(final String oldvalue) {
        this.oldvalue = oldvalue;
        return this;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public TracTicketChangeLog setNewvalue(final String newvalue) {
        this.newvalue = newvalue;
        return this;
    }

    public int getPermanent() {
        return permanent;
    }

    public TracTicketChangeLog setPermanent(final int permanent) {
        this.permanent = permanent;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
