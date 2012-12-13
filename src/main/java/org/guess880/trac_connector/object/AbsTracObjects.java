package org.guess880.trac_connector.object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbsTracObjects<E extends TracObject> implements
        TracObject, Iterable<E> {

    private final List<E> list;

    public AbsTracObjects() {
        this.list = new ArrayList<E>();
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

    public E addNewElement() {
        final E e = newElement();
        add(e);
        return e;
    }

    protected abstract E newElement();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
