package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.TracTicket;
import org.guess880.trac_connector.object.TracTicketAttachment;
import org.guess880.trac_connector.object.TracTicketAttachments;

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

    public TracTicket getTicket(final TracTicket ticket) throws XmlRpcException {
        ticket.readAPIObject(getRpcClient().execute("ticket.get", ticket.writeAPIObjectForGet()));
        return ticket;
    }

    public TracTicket createTicket(final TracTicket ticket) throws XmlRpcException {
        return ticket.setId(((Integer) getRpcClient().execute("ticket.create", ticket.writeAPIObjectForCreate())).intValue());
    }

    public TracTicket deleteTicket(final TracTicket ticket) throws XmlRpcException {
        getRpcClient().execute("ticket.delete", ticket.writeAPIObjectForDelete());
        return ticket;
    }

    public TracTicket updateTicket(final TracTicket ticket) throws XmlRpcException {
        ticket.readAPIObject(getRpcClient().execute("ticket.update", ticket.writeAPIObjectForUpdate()));
        return ticket;
    }

    public TracTicketAttachments listAttachments(final TracTicketAttachments attachments) throws XmlRpcException {
        attachments.readAPIObject(getRpcClient().execute("ticket.listAttachments", attachments.writeAPIObjectForGet()));
        return attachments;
    }

    public TracTicketAttachment getAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        attachment.readAPIObject(getRpcClient().execute("ticket.getAttachment", attachment.writeAPIObjectForGet()));
        return attachment;
    }

    public TracTicketAttachment putAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        return attachment.setFilename((String) getRpcClient().execute("ticket.putAttachment", attachment.writeAPIObjectForUpdate()));
    }

}
