package org.guess880.trac_connector.object.converter;

import java.util.Map;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracStructTemplate;

public class TrucStructGetResultReader implements
        TracAPIObjectReader {

    @SuppressWarnings("unchecked")
    @Override
    public TracObject read(final TracObject tracObj, final Object apiObj) {
        final TracStructTemplate field = (TracStructTemplate) tracObj;
        field.setValues((Map<String, Object>) apiObj);
        return field;
    }

}