package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.ITracObject;

public interface TracAPIObjectReader {

    ITracObject read(final ITracObject tracObj, final Object apiObj);

}
