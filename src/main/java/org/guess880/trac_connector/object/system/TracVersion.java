package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectTemplate;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracVersion extends TracObjectTemplate {

    private int epoc;

    private int major;

    private int minor;

    public TracVersion() {
        setGetResultReader(new DefaultAPIObjectReader());
        setGetParamWriter(new TracEmptyAPIObjectWriter());
    }

    public int getEpoc() {
        return epoc;
    }

    public TracVersion setEpoc(final int epoc) {
        this.epoc = epoc;
        return this;
    }

    public int getMajor() {
        return major;
    }

    public TracVersion setMajor(final int major) {
        this.major = major;
        return this;
    }

    public int getMinor() {
        return minor;
    }

    public TracVersion setMinor(final int minor) {
        this.minor = minor;
        return this;
    }

    private static class DefaultAPIObjectReader implements TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracVersion version = (TracVersion) tracObj;
            final Object[] attrs = (Object[]) apiObj;
            version.setEpoc((Integer) attrs[0]);
            version.setMajor((Integer) attrs[1]);
            version.setMinor((Integer) attrs[2]);
            return version;
        }

    }

}
