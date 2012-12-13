package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectTemplate;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracMethodSignature extends TracObjectTemplate {

    private final String name;

    private String returnType;

    private String parameterTypes;

    public TracMethodSignature(final String name) {
        this.name = name;
        setGetResultReader(new DefaultAPIObjectReader());
        setGetParamWriter(new DefaultAPIObjectWriter());
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

    private static class DefaultAPIObjectReader implements TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final Object[] objAry = (Object[]) apiObj;
            final TracMethodSignature signature = (TracMethodSignature) tracObj;
            signature.setReturnType((String) objAry[0]);
            signature.setParameterTypes((String) objAry[1]);
            return signature;
        }

    }

    private static class DefaultAPIObjectWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodSignature) tracObj).getName() };
        }

    }

}
