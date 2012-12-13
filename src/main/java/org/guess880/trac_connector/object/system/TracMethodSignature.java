package org.guess880.trac_connector.object.system;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracMethodSignature implements TracObject {

    private final String name;

    private String returnType;

    private String parameterTypes;

    public TracMethodSignature(final String name) {
        super();
        this.name = name;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
