package org.guess880.trac_connector.object;

import java.util.Map;

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