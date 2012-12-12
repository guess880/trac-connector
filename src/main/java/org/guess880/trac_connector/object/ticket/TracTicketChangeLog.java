package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketChangeLog extends TracObject {

    private Date time;

    private String author;

    private String field;

    private String oldvalue;

    private String newvalue;

    private int permanent;

    public TracTicketChangeLog() {
        setAPIObjectReader(new DefaultAPIObjectReader());
    }

    public Date getTime() {
        return time;
    }

    public TracTicketChangeLog setTime(final Date time) {
        this.time = time;
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

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final Object[] aryObj = (Object[]) apiObj;
            final TracTicketChangeLog changelog = (TracTicketChangeLog) tracObj;
            changelog.setTime((Date) aryObj[0]);
            changelog.setAuthor((String) aryObj[1]);
            changelog.setField((String) aryObj[2]);
            changelog.setOldvalue((String) aryObj[3]);
            changelog.setNewvalue((String) aryObj[4]);
            changelog.setPermanent((Integer) aryObj[5]);
            return changelog;
        }

    }

}
