package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.util.Date;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicket;
import org.guess880.trac_connector.object.ticket.TracTicketAttachment;
import org.guess880.trac_connector.object.ticket.TracTicketAttachments;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLogs;
import org.guess880.trac_connector.object.ticket.TracTicketFields;
import org.guess880.trac_connector.object.ticket.TracTickets;

public class TracTicketAPI extends TracAPITemplate {

    private TracTicketComponentAPI component;

    private TracTicketMilestoneAPI milestone;

    private TracTicketPriorityAPI priority;

    private TracTicketResolutionAPI resolution;

    private TracTicketSeverityAPI severity;

    private TracTicketStatusAPI status;

    private TracTicketTypeAPI type;

    private TracTicketVersionAPI version;

    public TracTicketAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        newMemberAPI();
    }

    public TracTicketAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        newMemberAPI();
    }

    private void newMemberAPI() {
        component = new TracTicketComponentAPI(getRpcClient());
        milestone = new TracTicketMilestoneAPI(getRpcClient());
        priority = new TracTicketPriorityAPI(getRpcClient());
        resolution = new TracTicketResolutionAPI(getRpcClient());
        severity = new TracTicketSeverityAPI(getRpcClient());
        status = new TracTicketStatusAPI(getRpcClient());
        type = new TracTicketTypeAPI(getRpcClient());
        version = new TracTicketVersionAPI(getRpcClient());
    }

    public TracTicketComponentAPI component() {
        return component;
    }

    public TracTicketMilestoneAPI milestone() {
        return milestone;
    }

    public TracTicketPriorityAPI priority() {
        return priority;
    }

    public TracTicketResolutionAPI resolution() {
        return resolution;
    }

    public TracTicketSeverityAPI severity() {
        return severity;
    }

    public TracTicketStatusAPI status() {
        return status;
    }

    public TracTicketTypeAPI type() {
        return type;
    }

    public TracTicketVersionAPI version() {
        return version;
    }

    public TracTickets query(final TracTickets tickets) throws XmlRpcException {
        tickets.readGetMultiResult(getRpcClient().execute("ticket.query", tickets.writeGetMultiParam()));
        return tickets;
    }

    public TracTickets query(final String qstr) throws XmlRpcException {
        return query(new TracTickets().setQueryStr(qstr));
    }

    public TracTickets getRecentChanges(final TracTickets tickets) throws XmlRpcException {
        tickets.readGetMultiResult(getRpcClient().execute("ticket.getRecentChanges", tickets.writeAPIObjectForRecentChanges()));
        return tickets;
    }

    public TracTickets getRecentChanges(final Date since) throws XmlRpcException {
        return getRecentChanges(new TracTickets().setSince(since));
    }

    /**
     * 
     * @param id
     * @return
     * @throws XmlRpcException
     * @Deprecated will be removed. Replaced by getActions().
     */
    // FIXME not implement
    @Deprecated
    public Object getAvailableActions(final int id) throws XmlRpcException {
        return getRpcClient().execute("ticket.getAvailableActions", new Object[] { id });
    }

    // FIXME not implement
    public Object getActions(final int id) throws XmlRpcException {
        return getRpcClient().execute("ticket.getActions", new Object[] { id });
    }

    public TracTicket get(final TracTicket ticket) throws XmlRpcException {
        ticket.readGetResult(getRpcClient().execute("ticket.get", ticket.writeGetParam()));
        return ticket;
    }

    public TracTicket get(final int id) throws XmlRpcException {
        return get(new TracTicket().setId(id));
    }

    public TracTicket create(final TracTicket ticket) throws XmlRpcException {
        ticket.readCreateAPIObject(getRpcClient().execute("ticket.create", ticket.writeCreateParam()));
        return ticket;
    }

    public TracTicket create() throws XmlRpcException {
        return create(new TracTicket());
    }

    public TracTicket update(final TracTicket ticket) throws XmlRpcException {
        ticket.readGetResult(getRpcClient().execute("ticket.update", ticket.writeUpdateParam()));
        return ticket;
    }

    public TracTicket delete(final TracTicket ticket) throws XmlRpcException {
        getRpcClient().execute("ticket.delete", ticket.writeDeleteParam());
        return ticket;
    }

    public TracTicket delete(final int id) throws XmlRpcException {
        return delete(new TracTicket().setId(id));
    }

    public TracTicketChangeLogs changeLog(final TracTicket ticket) throws XmlRpcException {
        final TracTicketChangeLogs changelogs = ticket.getChangelogs();
        changelogs.readGetMultiResult(getRpcClient().execute("ticket.changeLog", changelogs.writeGetMultiParam()));
        return changelogs;
    }

    public TracTicketChangeLogs changeLog(final int id) throws XmlRpcException {
        return changeLog(new TracTicket().setId(id));
    }

    public TracTicketAttachments listAttachments(final TracTicket ticket) throws XmlRpcException {
        final TracTicketAttachments attachments = ticket.getAttachments();
        attachments.readGetMultiResult(getRpcClient().execute("ticket.listAttachments", attachments.writeGetMultiParam()));
        return attachments;
    }

    public TracTicketAttachments listAttachments(final int ticket) throws XmlRpcException {
        return listAttachments(new TracTicket().setId(ticket));
    }

    public TracTicketAttachment getAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        attachment.readGetResult(getRpcClient().execute("ticket.getAttachment", attachment.writeGetParam()));
        return attachment;
    }

    public TracTicketAttachment getAttachment(final int ticket, final String filename) throws XmlRpcException {
        return getAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketAttachment putAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        return attachment.setFilename((String) getRpcClient().execute("ticket.putAttachment", attachment.writeUpdateParam()));
    }

    public TracTicketAttachment putAttachment(final int ticket, final String filename, final String description, final byte[] data) throws XmlRpcException {
        return putAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename).setData(data));
    }

    public TracTicketAttachment deleteAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        getRpcClient().execute("ticket.deleteAttachment", attachment.writeDeleteParam());
        return attachment;
    }

    public TracTicketAttachment deleteAttachment(final int ticket, String filename) throws XmlRpcException {
        return deleteAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketFields getTicketFields(final TracTicketFields fields) throws XmlRpcException {
        fields.readGetMultiResult(getRpcClient().execute("ticket.getTicketFields", fields.writeGetMultiParam()));
        return fields;
    }

    public TracTicketFields getTicketFields() throws XmlRpcException {
        return getTicketFields(new TracTicketFields());
    }

}
