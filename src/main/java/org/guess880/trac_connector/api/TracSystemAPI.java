package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.system.TracMethod;
import org.guess880.trac_connector.object.system.TracMethodHelp;
import org.guess880.trac_connector.object.system.TracMethodSignature;
import org.guess880.trac_connector.object.system.TracMethods;
import org.guess880.trac_connector.object.system.TracVersion;

public class TracSystemAPI extends TracAPIBase {

    private TracAPIResultReader listMethodsResultReader;

    private TracAPIParamWriter listMethodsParamWriter;

    private TracAPIResultReader methodHelpResultReader;

    private TracAPIParamWriter methodHelpParamWriter;

    private TracAPIResultReader methodSignatureResultReader;

    private TracAPIParamWriter methodSignatureParamWriter;

    private TracAPIResultReader getAPIVersionResultReader;

    private TracAPIParamWriter getAPIVersionParamWriter;

    public TracSystemAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        setUpConverter();
    }

    public TracSystemAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        setUpConverter();
    }

    private void setUpConverter() {
        listMethodsResultReader = new TracMultiResultReader()
                .setOneResultReader(new MethodResultReader());
        listMethodsParamWriter = new TracEmptyParamWriter();
        methodHelpResultReader = new MethodHelpResultReader();
        methodHelpParamWriter = new MethodHelpParamWriter();
        methodSignatureResultReader = new MethodSignatureResultReader();
        methodSignatureParamWriter = new MethodSignatureParamWriter();
        getAPIVersionResultReader = new GetAPIVersionResultReader();
        getAPIVersionParamWriter = new TracEmptyParamWriter();
    }

    public Object multicall() throws XmlRpcException {
        throw new UnsupportedOperationException(
                "system.multicall is not supported.");
    }

    public TracMethods listMethods(final TracMethods methods)
            throws XmlRpcException {
        listMethodsResultReader.read(
                methods,
                getRpcClient().execute("system.listMethods",
                        listMethodsParamWriter.write(methods)));
        return methods;
    }

    public TracMethods listMethods() throws XmlRpcException {
        return listMethods(new TracMethods());
    }

    public TracMethod methodHelp(final TracMethod method)
            throws XmlRpcException {
        final TracMethodHelp help = method.getHelp();
        methodHelpResultReader.read(
                help,
                getRpcClient().execute("system.methodHelp",
                        methodHelpParamWriter.write(help)));
        return method;
    }

    public TracMethod methodHelp(final String method) throws XmlRpcException {
        return methodHelp(new TracMethod().setName(method));
    }

    public TracMethod methodSignature(final TracMethod method)
            throws XmlRpcException {
        final TracMethodSignature signature = method.getSignature();
        methodSignatureResultReader.read(
                signature,
                getRpcClient().execute("system.methodSignature",
                        methodSignatureParamWriter.write(signature)));
        return method;
    }

    public TracMethod methodSignature(final String method)
            throws XmlRpcException {
        return methodSignature(new TracMethod().setName(method));
    }

    public TracVersion getAPIVersion(final TracVersion version)
            throws XmlRpcException {
        getAPIVersionResultReader.read(
                version,
                getRpcClient().execute("system.getAPIVersion",
                        getAPIVersionParamWriter.write(version)));
        return version;
    }

    public TracVersion getAPIVersion() throws XmlRpcException {
        return getAPIVersion(new TracVersion());
    }

    private static class MethodResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracMethod method = (TracMethod) tracObj;
            method.setName((String) result);
            return method;
        }

    }

    private static class MethodHelpResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracMethodHelp signature = (TracMethodHelp) tracObj;
            signature.setHelp((String) result);
            return signature;
        }

    }

    private static class MethodHelpParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodHelp) tracObj).getName() };
        }

    }

    private static class MethodSignatureResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final Object[] objAry = (Object[]) result;
            final TracMethodSignature signature = (TracMethodSignature) tracObj;
            signature.setReturnType((String) objAry[0]);
            signature.setParameterTypes((String) objAry[1]);
            return signature;
        }

    }

    private static class MethodSignatureParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodSignature) tracObj).getName() };
        }

    }

    private static class GetAPIVersionResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracVersion version = (TracVersion) tracObj;
            final Object[] attrs = (Object[]) result;
            version.setEpoc((Integer) attrs[0]);
            version.setMajor((Integer) attrs[1]);
            version.setMinor((Integer) attrs[2]);
            return version;
        }

    }

}
