package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public interface TracAPIResultReader<O extends TracObject> {

    O read(final O tracObj, final Object result);

}
