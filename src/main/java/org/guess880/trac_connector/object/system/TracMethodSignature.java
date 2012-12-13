package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracMethodSignature extends TracObjectBase {

    private final String name;

    private String returnType;

    private String parameterTypes;

    public TracMethodSignature(final String name) {
        super();
        this.name = name;
        setGetResultReader(new GetResultReader());
        setGetParamWriter(new GetParamWriter());
    }

    public String getName() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public TracMethodSignature setReturnType(final String returnType) {
        this.returnType = returnType;
        return this;
    }

    public String getParameterTypes() {
        return parameterTypes;
    }

    public TracMethodSignature setParameterTypes(final String parameterTypes) {
        this.parameterTypes = parameterTypes;
        return this;
    }

    private static class GetResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final Object[] objAry = (Object[]) result;
            final TracMethodSignature signature = (TracMethodSignature) tracObj;
            signature.setReturnType((String) objAry[0]);
            signature.setParameterTypes((String) objAry[1]);
            return signature;
        }

    }

    private static class GetParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodSignature) tracObj).getName() };
        }

    }

}
