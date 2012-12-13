package org.guess880.trac_connector.object.converter;

import java.util.Map;

import org.guess880.trac_connector.object.TracStructBase;

public class TracStructGetResultReader<O extends TracStructBase> implements
        TracAPIResultReader<O> {

    @SuppressWarnings("unchecked")
    @Override
    public O read(final O tracObj, final Object result) {
        tracObj.setValues((Map<String, Object>) result);
        return tracObj;
    }

}