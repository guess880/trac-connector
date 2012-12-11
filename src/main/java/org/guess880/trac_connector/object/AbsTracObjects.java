package org.guess880.trac_connector.object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbsTracObjects<E extends TracObject> extends TracObject implements
        Iterable<E> {

    private final List<E> list;

    public AbsTracObjects() {
        this.list = new ArrayList<E>();
        setAPIObjectReader(new DefaultAPIObjectReader());
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

    public abstract TracObject newElement();

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final AbsTracObjects<?> objects = (AbsTracObjects<?>) tracObj;
            objects.clear();
            final Object[] objAry = (Object[]) apiObj;
            for (final Object obj : objAry) {
                objects.newElement().readAPIObject(obj);
            }
            return objects;
        }

    }

}
