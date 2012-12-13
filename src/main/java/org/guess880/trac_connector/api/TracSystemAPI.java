package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
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

    private TracMultiResultReader<TracMethod, TracMethods> listMethodsResultReader;

    private TracAPIParamWriter<TracMethods> listMethodsParamWriter;

    private TracAPIResultReader<TracMethodHelp> methodHelpResultReader;

    private TracAPIParamWriter<TracMethodHelp> methodHelpParamWriter;

    private TracAPIResultReader<TracMethodSignature> methodSignatureResultReader;

    private TracAPIParamWriter<TracMethodSignature> methodSignatureParamWriter;

    private TracAPIResultReader<TracVersion> getAPIVersionResultReader;

    private TracAPIParamWriter<TracVersion> getAPIVersionParamWriter;

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
        listMethodsResultReader = new TracMultiResultReader<TracMethod, TracMethods>()
                .setOneResultReader(new MethodResultReader());
        listMethodsParamWriter = new TracEmptyParamWriter<TracMethods>();
        methodHelpResultReader = new MethodHelpResultReader();
        methodHelpParamWriter = new MethodHelpParamWriter();
        methodSignatureResultReader = new MethodSignatureResultReader();
        methodSignatureParamWriter = new MethodSignatureParamWriter();
        getAPIVersionResultReader = new GetAPIVersionResultReader();
        getAPIVersionParamWriter = new TracEmptyParamWriter<TracVersion>();
    }

    protected TracMultiResultReader<TracMethod, TracMethods> getListMethodsResultReader() {
        return listMethodsResultReader;
    }

    public TracSystemAPI setListMethodsResultReader(
            final TracMultiResultReader<TracMethod, TracMethods> listMethodsResultReader) {
        this.listMethodsResultReader = listMethodsResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracMethods> getListMethodsParamWriter() {
        return listMethodsParamWriter;
    }

    public TracSystemAPI setListMethodsParamWriter(
            final TracAPIParamWriter<TracMethods> listMethodsParamWriter) {
        this.listMethodsParamWriter = listMethodsParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracMethodHelp> getMethodHelpResultReader() {
        return methodHelpResultReader;
    }

    public TracSystemAPI setMethodHelpResultReader(
            final TracAPIResultReader<TracMethodHelp> methodHelpResultReader) {
        this.methodHelpResultReader = methodHelpResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracMethodHelp> getMethodHelpParamWriter() {
        return methodHelpParamWriter;
    }

    public TracSystemAPI setMethodHelpParamWriter(
            final TracAPIParamWriter<TracMethodHelp> methodHelpParamWriter) {
        this.methodHelpParamWriter = methodHelpParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracMethodSignature> getMethodSignatureResultReader() {
        return methodSignatureResultReader;
    }

    public TracSystemAPI setMethodSignatureResultReader(
            final TracAPIResultReader<TracMethodSignature> methodSignatureResultReader) {
        this.methodSignatureResultReader = methodSignatureResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracMethodSignature> getMethodSignatureParamWriter() {
        return methodSignatureParamWriter;
    }

    public TracSystemAPI setMethodSignatureParamWriter(
            final TracAPIParamWriter<TracMethodSignature> methodSignatureParamWriter) {
        this.methodSignatureParamWriter = methodSignatureParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracVersion> getGetAPIVersionResultReader() {
        return getAPIVersionResultReader;
    }

    public TracSystemAPI setGetAPIVersionResultReader(
            final TracAPIResultReader<TracVersion> getAPIVersionResultReader) {
        this.getAPIVersionResultReader = getAPIVersionResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracVersion> getGetAPIVersionParamWriter() {
        return getAPIVersionParamWriter;
    }

    public TracSystemAPI setGetAPIVersionParamWriter(
            final TracAPIParamWriter<TracVersion> getAPIVersionParamWriter) {
        this.getAPIVersionParamWriter = getAPIVersionParamWriter;
        return this;
    }

    public Object multicall() throws XmlRpcException {
        throw new UnsupportedOperationException(
                "system.multicall is not supported.");
    }

    public TracMethods listMethods(final TracMethods methods)
            throws XmlRpcException {
        return listMethodsResultReader.read(
                methods,
                getRpcClient().execute("system.listMethods",
                        listMethodsParamWriter.write(methods)));
    }

    public TracMethods listMethods() throws XmlRpcException {
        return listMethods(new TracMethods());
    }

    public TracMethodHelp methodHelp(final TracMethod method)
            throws XmlRpcException {
        final TracMethodHelp help = method.getHelp();
        return methodHelpResultReader.read(
                help,
                getRpcClient().execute("system.methodHelp",
                        methodHelpParamWriter.write(help)));
    }

    public TracMethodHelp methodHelp(final String method)
            throws XmlRpcException {
        return methodHelp(new TracMethod().setName(method));
    }

    public TracMethodSignature methodSignature(final TracMethod method)
            throws XmlRpcException {
        final TracMethodSignature signature = method.getSignature();
        return methodSignatureResultReader.read(
                signature,
                getRpcClient().execute("system.methodSignature",
                        methodSignatureParamWriter.write(signature)));
    }

    public TracMethodSignature methodSignature(final String method)
            throws XmlRpcException {
        return methodSignature(new TracMethod().setName(method));
    }

    public TracVersion getAPIVersion(final TracVersion version)
            throws XmlRpcException {
        return getAPIVersionResultReader.read(
                version,
                getRpcClient().execute("system.getAPIVersion",
                        getAPIVersionParamWriter.write(version)));
    }

    public TracVersion getAPIVersion() throws XmlRpcException {
        return getAPIVersion(new TracVersion());
    }

    private static class MethodResultReader implements
            TracAPIResultReader<TracMethod> {

        @Override
        public TracMethod read(final TracMethod tracObj, final Object result) {
            return tracObj.setName((String) result);
        }

    }

    private static class MethodHelpResultReader implements
            TracAPIResultReader<TracMethodHelp> {

        @Override
        public TracMethodHelp read(final TracMethodHelp tracObj,
                final Object result) {
            return tracObj.setHelp((String) result);
        }

    }

    private static class MethodHelpParamWriter implements
            TracAPIParamWriter<TracMethodHelp> {

        @Override
        public Object[] write(final TracMethodHelp tracObj) {
            return new Object[] { tracObj.getName() };
        }

    }

    private static class MethodSignatureResultReader implements
            TracAPIResultReader<TracMethodSignature> {

        @Override
        public TracMethodSignature read(final TracMethodSignature tracObj,
                final Object result) {
            final Object[] objAry = (Object[]) result;
            return tracObj.setReturnType((String) objAry[0]).setParameterTypes(
                    (String) objAry[1]);
        }

    }

    private static class MethodSignatureParamWriter implements
            TracAPIParamWriter<TracMethodSignature> {

        @Override
        public Object[] write(final TracMethodSignature tracObj) {
            return new Object[] { tracObj.getName() };
        }

    }

    private static class GetAPIVersionResultReader implements
            TracAPIResultReader<TracVersion> {

        @Override
        public TracVersion read(final TracVersion tracObj, final Object result) {
            final Object[] attrs = (Object[]) result;
            return tracObj.setEpoc((Integer) attrs[0])
                    .setMajor((Integer) attrs[1]).setMinor((Integer) attrs[2]);
        }

    }

}
