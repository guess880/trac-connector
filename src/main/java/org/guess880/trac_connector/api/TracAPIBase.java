package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

public class TracAPIBase {

    private final XmlRpcClient rpcClient;

    protected TracAPIBase(final XmlRpcClient rpcClient) {
        this.rpcClient = rpcClient;
    }

    protected TracAPIBase(final TracAPIConfig cfg) throws MalformedURLException {
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
