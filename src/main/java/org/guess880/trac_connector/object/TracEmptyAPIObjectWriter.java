package org.guess880.trac_connector.object;

public class TracEmptyAPIObjectWriter implements TracAPIObjectWriter {

    @Override
    public Object[] write(final ITracObject tracObj) {
        return new Object[] {};
    }

}
