package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public class TracEmptyAPIObjectWriter implements TracAPIObjectWriter {

    @Override
    public Object[] write(final TracObject tracObj) {
        return new Object[] {};
    }

}
