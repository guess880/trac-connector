package org.guess880.trac_connector.object.converter;

import java.util.Map;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracStructTemplate;

public class TrucStructGetResultReader implements
        TracAPIResultReader {

    @SuppressWarnings("unchecked")
    @Override
    public TracObject read(final TracObject tracObj, final Object result) {
        final TracStructTemplate struct = (TracStructTemplate) tracObj;
        struct.setValues((Map<String, Object>) result);
        return struct;
    }

}