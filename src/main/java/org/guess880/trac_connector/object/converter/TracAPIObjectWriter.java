package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.TracObject;

public interface TracAPIObjectWriter {

    Object[] write(final TracObject tracObj);

}
