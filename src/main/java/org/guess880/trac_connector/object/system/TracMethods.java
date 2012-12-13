package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracMethods extends AbsTracObjects<TracMethod> {

    public TracMethods() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    protected TracMethod newElement() {
        return new TracMethod();
    }

}
