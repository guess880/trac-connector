package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.ticket.TracTicketComponent;
import org.guess880.trac_connector.object.ticket.TracTicketComponents;

public class TracTicketComponentAPI extends TracAPITemplate {

    public TracTicketComponentAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracTicketComponentAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    public TracTicketComponents getAll() throws XmlRpcException {
        final TracTicketComponents components = new TracTicketComponents();
        components.readGetMultiResult(getRpcClient().execute("ticket.component.getAll", components.writeGetMultiParam()));
        return components;
    }

    public TracTicketComponent get(final TracTicketComponent component)
            throws XmlRpcException {
        component.readGetResult(getRpcClient().execute("ticket.component.get", component.writeGetParam()));
        return component;
    }

    public TracTicketComponent get(final String name) throws XmlRpcException {
        final TracTicketComponent component = new TracTicketComponent();
        component.setName(name);
        return get(component);
    }

    public TracTicketComponent delete(final TracTicketComponent component) throws XmlRpcException {
        getRpcClient().execute("ticket.component.delete", component.writeDeleteParam());
        return component;
    }

    public TracTicketComponent delete(final String name) throws XmlRpcException {
        final TracTicketComponent component = new TracTicketComponent();
        component.setName(name);
        return delete(component);
    }

    public TracTicketComponent create(final TracTicketComponent component) throws XmlRpcException {
        getRpcClient().execute("ticket.component.create", component.writeCreateParam());
        return component;
    }

    public TracTicketComponent update(final TracTicketComponent component) throws XmlRpcException {
        getRpcClient().execute("ticket.component.update", component.writeUpdateParam());
        return component;
    }

    public TracTicketComponent update(final String name, final TracTicketComponent component) throws XmlRpcException {
        component.setUpdateKey(name);
        return update(component);
    }

}
