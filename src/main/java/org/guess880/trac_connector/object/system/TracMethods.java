package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracMethods extends AbsTracObjects<TracMethod> {

    public TracMethods() {
        super();
    }

    @Override
    protected TracMethod newElement() {
        return new TracMethod();
    }

}
