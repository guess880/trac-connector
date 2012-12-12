package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.system.TracMethod;
import org.guess880.trac_connector.object.system.TracMethodSignature;
import org.guess880.trac_connector.object.system.TracMethods;
import org.guess880.trac_connector.object.system.TracVersion;

public class TracSystemAPI extends TracAPITemplate {

    public TracSystemAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracSystemAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    public Object multicall() throws XmlRpcException {
        throw new UnsupportedOperationException("system.multicall is not supported.");
    }

    public TracMethods listMethods(final TracMethods methods) throws XmlRpcException {
        methods.readGetMultiResult(getRpcClient().execute("system.listMethods", methods.writeGetMultiParam()));
        return methods;
    }

    public TracMethods listMethods() throws XmlRpcException {
        return listMethods(new TracMethods());
    }

    public TracMethod methodHelp(final TracMethod method) throws XmlRpcException {
        method.getHelp().readGetResult(getRpcClient().execute("system.methodHelp", method.getHelp().writeGetParam()));
        return method;
    }

    public TracMethod methodHelp(final String method) throws XmlRpcException {
        return methodHelp(new TracMethod().setName(method));
    }

    public TracMethod methodSignature(final TracMethod method) throws XmlRpcException {
        final TracMethodSignature signature = method.getSignature();
        signature.readGetResult(getRpcClient().execute("system.methodSignature", signature.writeGetParam()));
        return method;
    }

    public TracMethod methodSignature(final String method) throws XmlRpcException {
        return methodSignature(new TracMethod().setName(method));
    }

    public TracVersion getAPIVersion(final TracVersion version) throws XmlRpcException {
        version.readGetResult(getRpcClient().execute("system.getAPIVersion", version.writeGetParam()));
        return version;
    }

    public TracVersion getAPIVersion() throws XmlRpcException {
        return getAPIVersion(new TracVersion());
    }

}
