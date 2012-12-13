package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracMethods extends AbsTracObjects<TracMethod> {

    public TracMethods() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    public TracMethod newElement() {
        final TracMethod e = new TracMethod();
        add(e);
        return e;
    }

}
