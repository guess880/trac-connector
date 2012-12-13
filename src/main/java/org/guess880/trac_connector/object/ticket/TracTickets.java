package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracTickets extends AbsTracObjects<TracTicket> {

    private TracAPIParamWriter recentChangesWriter;

    private String queryStr;

    private Date since;

    public TracTickets() {
        super();
        setGetMultiParamWriter(new GetMultiParamWriter());
        setRecentChangesParamWriter(new RecentChangesParamWriter());
    }

    public TracTickets setRecentChangesParamWriter(final TracAPIParamWriter writer) {
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

    private static class GetMultiParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getQueryStr() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getQueryStr() };
        }

    }

    private static class RecentChangesParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getSince() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getSince() };
        }

    }

}
