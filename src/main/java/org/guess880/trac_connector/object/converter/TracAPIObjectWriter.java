package org.guess880.trac_connector.object.converter;

import org.guess880.trac_connector.object.ITracObject;

public interface TracAPIObjectWriter {

    Object[] write(final ITracObject tracObj);

}
