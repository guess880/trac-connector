package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;

public class TracMultiResultReader implements TracAPIResultReader {

    private TracAPIResultReader oneResultReader;

    public TracMultiResultReader setOneResultReader(
            final TracAPIResultReader reader) {
        this.oneResultReader = reader;
        return this;
    }

    @Override
    public TracObject read(final TracObject tracObj, Object result) {
        final AbsTracObjects<?> objects = (AbsTracObjects<?>) tracObj;
        objects.clear();
        final Object[] objAry = (Object[]) result;
        for (final Object obj : objAry) {
            oneResultReader.read(objects.addNewElement(), obj);
        }
        return objects;
    }

}
