package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracEmptyAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracMethods extends AbsTracObjects<TracMethod> {

    public TracMethods() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracObject newElement() {
        final TracMethod e = new TracMethod();
        add(e);
        return e;
    }

}
