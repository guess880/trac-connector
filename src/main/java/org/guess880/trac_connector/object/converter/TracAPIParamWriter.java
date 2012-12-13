package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public interface TracAPIParamWriter<O extends TracObject> {

    Object[] write(final O tracObj);

}
