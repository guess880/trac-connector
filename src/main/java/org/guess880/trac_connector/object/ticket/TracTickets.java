package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracTickets extends AbsTracObjects<TracTicket> {

    private String queryStr;

    private Date since;

    public TracTickets() {
        super();
    }

    @Override
    protected TracTicket newElement() {
        return new TracTicket();
    }

    
    public String getQueryStr() {
        return queryStr;
    }

    
    public TracTickets setQueryStr(final String queryStr) {
        this.queryStr = queryStr;
        return this;
    }

    
    public Date getSince() {
        return since == null ? null : (Date) since.clone();
    }

    
    public TracTickets setSince(final Date since) {
        this.since = since == null ? null : (Date) since.clone();
        return this;
    }

}
