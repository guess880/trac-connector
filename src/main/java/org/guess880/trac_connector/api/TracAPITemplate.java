package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.guess880.trac_connector.TracConnectConfig;

public class TracAPITemplate {

    private XmlRpcClient rpcClient;

    public TracAPITemplate(final XmlRpcClient rpcClient) {
        this.rpcClient = rpcClient;
    }

    public TracAPITemplate(final TracConnectConfig cfg) throws MalformedURLException {
        final XmlRpcClientConfigImpl rpcCfg = new XmlRpcClientConfigImpl();
        rpcCfg.setServerURL(new URL(cfg.getUrl()));
        rpcCfg.setBasicUserName(cfg.getUsername());
        rpcCfg.setBasicPassword(cfg.getPassword());
        rpcClient = new XmlRpcClient();
        rpcClient.setConfig(rpcCfg);
        rpcClient.setTransportFactory(new XmlRpcCommonsTransportFactory(rpcClient));
    }

    protected XmlRpcClient getRpcClient() {
        return rpcClient;
    }

}
