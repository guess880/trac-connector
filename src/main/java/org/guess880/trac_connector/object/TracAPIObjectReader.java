package org.guess880.trac_connector.object;

public interface TracAPIObjectReader {

    ITracObject read(final ITracObject tracObj, final Object apiObj);

}
