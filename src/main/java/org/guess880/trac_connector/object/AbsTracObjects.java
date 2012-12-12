package org.guess880.trac_connector.object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public abstract class AbsTracObjects<E extends TracObject> implements
        ITracObject, Iterable<E> {

    private TracAPIObjectReader getMultiResultReader;

    private TracAPIObjectWriter getMultiParamWriter;

    private final List<E> list;

    public AbsTracObjects() {
        this.list = new ArrayList<E>();
        setGetMultiResultReader(new DefaultAPIObjectReader());
    }

    public AbsTracObjects<E> setGetMultiResultReader(final TracAPIObjectReader reader) {
        this.getMultiResultReader = reader;
        return this;
    }

    public AbsTracObjects<E> setGetMultiParamWriter(final TracAPIObjectWriter writer) {
        this.getMultiParamWriter = writer;
        return this;
    }

    public AbsTracObjects<E> readGetMultiResult(final Object apiObj) {
        getMultiResultReader.read(this, apiObj);
        return this;
    }

    public Object[] writeGetMultiParam() {
        return getMultiParamWriter.write(this);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    public boolean add(final E e) {
        return list.add(e);
    }

    public boolean remove(final E e) {
        return list.remove(e);
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public abstract E newElement();

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public ITracObject read(final ITracObject tracObj, final Object apiObj) {
            final AbsTracObjects<?> objects = (AbsTracObjects<?>) tracObj;
            objects.clear();
            final Object[] objAry = (Object[]) apiObj;
            for (final Object obj : objAry) {
                objects.newElement().readGetMultiResult(obj);
            }
            return objects;
        }

    }

}
