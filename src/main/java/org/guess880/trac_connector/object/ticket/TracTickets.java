package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracTickets extends AbsTracObjects<TracTicket> {

    private TracAPIObjectReader recentChangesReader;

    private TracAPIObjectWriter recentChangesWriter;

    private String queryStr;

    private Date since;

    public TracTickets() {
        setAPIObjectReader(new DefaultAPIObjectReader());
        setAPIObjectReaderForRecentChanges(new DefaultAPIObjectReader());
        setAPIObjectWriterForGet(new DefaultAPIObjectWriter());
        setAPIObjectWriterForRecentChanges(new APIObjectWriterForRecentChanges());
    }

    public TracObject setAPIObjectReaderForRecentChanges(final TracAPIObjectReader reader) {
        this.recentChangesReader = reader;
        return this;
    }

    public TracObject readAPIObjectForRecentChanges(final Object apiObj) {
        return recentChangesReader.read(this, apiObj);
    }

    public TracObject setAPIObjectWriterForRecentChanges(final TracAPIObjectWriter writer) {
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
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getQueryStr() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getQueryStr() };
        }

    }

    private static class APIObjectWriterForRecentChanges implements TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getSince() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getSince() };
        }

    }

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            tickets.clear();
            final Object[] objAry = (Object[]) apiObj;
            for (final Object obj : objAry) {
                tickets.newElement().readQueryAPIObject(obj);
            }
            return tickets;
        }

    }

}
