package org.guess880.trac_connector.object.converter;

import java.util.Map;

import org.guess880.trac_connector.object.ITracObject;
import org.guess880.trac_connector.object.TracStruct;

public class TrucStructGetResultReader implements
        TracAPIObjectReader {

    @SuppressWarnings("unchecked")
    @Override
    public ITracObject read(final ITracObject tracObj, final Object apiObj) {
        final TracStruct field = (TracStruct) tracObj;
        field.setValues((Map<String, Object>) apiObj);
        return field;
    }

}