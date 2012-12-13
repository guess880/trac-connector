package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public class TracEmptyParamWriter<O extends TracObject> implements TracAPIParamWriter<O> {

    @Override
    public Object[] write(final O tracObj) {
        return new Object[] {};
    }

}
