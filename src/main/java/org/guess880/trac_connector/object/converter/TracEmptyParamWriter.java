package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public class TracEmptyParamWriter implements TracAPIParamWriter {

    @Override
    public Object[] write(final TracObject tracObj) {
        return new Object[] {};
    }

}
