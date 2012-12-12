package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracTickets extends AbsTracObjects<TracTicket> {

    private TracAPIObjectWriter recentChangesWriter;

    private String queryStr;

    private Date since;

    public TracTickets() {
        super();
        setGetMultiParamWriter(new DefaultAPIObjectWriter());
        setAPIObjectWriterForRecentChanges(new APIObjectWriterForRecentChanges());
    }

    public TracTickets setAPIObjectWriterForRecentChanges(final TracAPIObjectWriter writer) {
        this.recentChangesWriter = writer;
        return this;
    }

    public Object[] writeAPIObjectForRecentChanges() {
        return recentChangesWriter.write(this);
    }

    @Override
    public TracTicket newElement() {
        final TracTicket e = new TracTicket();
        add(e);
        return e;
    }

    
    public String getQueryStr() {
        return queryStr;
    }

    
    public TracTickets setQueryStr(final String queryStr) {
        this.queryStr = queryStr;
        return this;
    }

    
    public Date getSince() {
        return since;
    }

    
    public TracTickets setSince(final Date since) {
        this.since = since;
        return this;
    }

    private static class DefaultAPIObjectWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getQueryStr() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getQueryStr() };
        }

    }

    private static class APIObjectWriterForRecentChanges implements TracAPIObjectWriter {

        @Override
        public Object[] write(final ITracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getSince() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getSince() };
        }

    }

}
