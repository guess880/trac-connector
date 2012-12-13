package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public interface TracAPIObjectReader {

    TracObject read(final TracObject tracObj, final Object apiObj);

}
