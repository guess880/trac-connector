package org.guess880.trac_connector;

import java.net.MalformedURLException;
import java.net.URL;


import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.guess880.trac_connector.object.TracTicket;
import org.guess880.trac_connector.object.TracTicketAttachment;
import org.guess880.trac_connector.object.TracTicketAttachments;

public class TracConnector {

    private XmlRpcClient rpcClient;

    public void setUp(final TracConnectConfig cfg) throws MalformedURLException,
            XmlRpcException {
        final XmlRpcClientConfigImpl rpcCfg = new XmlRpcClientConfigImpl();
        rpcCfg.setServerURL(new URL(cfg.getUrl()));
        rpcCfg.setBasicUserName(cfg.getUsername());
        rpcCfg.setBasicPassword(cfg.getPassword());
        rpcClient = new XmlRpcClient();
        rpcClient.setConfig(rpcCfg);
    }

    public TracTicket getTicket(final TracTicket ticket) throws XmlRpcException {
        ticket.readAPIObject(rpcClient.execute("ticket.get", ticket.writeAPIObjectForGet()));
        return ticket;
    }

    public TracTicket createTicket(final TracTicket ticket) throws XmlRpcException {
        return ticket.setId(((Integer) rpcClient.execute("ticket.create", ticket.writeAPIObjectForCreate())).intValue());
    }

    public TracTicket deleteTicket(final TracTicket ticket) throws XmlRpcException {
        rpcClient.execute("ticket.delete", ticket.writeAPIObjectForDelete());
        return ticket;
    }

    public TracTicket updateTicket(final TracTicket ticket) throws XmlRpcException {
        ticket.readAPIObject(rpcClient.execute("ticket.update", ticket.writeAPIObjectForUpdate()));
        return ticket;
    }

    public TracTicketAttachments listAttachments(final TracTicketAttachments attachments) throws XmlRpcException {
        attachments.readAPIObject(rpcClient.execute("ticket.listAttachments", attachments.writeAPIObjectForGet()));
        return attachments;
    }

    public TracTicketAttachment getAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        attachment.readAPIObject(rpcClient.execute("ticket.getAttachment", attachment.writeAPIObjectForGet()));
        return attachment;
    }

    public TracTicketAttachment putAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        return attachment.setFilename((String) rpcClient.execute("ticket.putAttachment", attachment.writeAPIObjectForUpdate()));
    }

}
