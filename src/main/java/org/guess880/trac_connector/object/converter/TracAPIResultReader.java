package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public interface TracAPIResultReader {

    TracObject read(final TracObject tracObj, final Object result);

}
