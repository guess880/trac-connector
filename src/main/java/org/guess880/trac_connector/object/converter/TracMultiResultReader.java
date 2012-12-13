package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;

public class TracMultiResultReader<O extends TracObject, L extends AbsTracObjects<O>> implements
        TracAPIResultReader<L> {

    private TracAPIResultReader<O> oneResultReader;

    public TracMultiResultReader<O, L> setOneResultReader(
            final TracAPIResultReader<O> reader) {
        this.oneResultReader = reader;
        return this;
    }

    @Override
    public L read(final L tracObj, Object result) {
        tracObj.clear();
        final Object[] objAry = (Object[]) result;
        for (final Object obj : objAry) {
            oneResultReader.read(tracObj.addNewElement(), obj);
        }
        return tracObj;
    }

}
