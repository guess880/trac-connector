package org.guess880.trac_connector.object;

public interface TracAPIObjectReader {

    TracObject read(final TracObject tracObj, final Object apiObj);

}
