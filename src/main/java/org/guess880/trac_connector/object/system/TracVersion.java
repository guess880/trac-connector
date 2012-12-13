package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracVersion extends TracObjectBase {

    private int epoc;

    private int major;

    private int minor;

    public TracVersion() {
        super();
        setGetResultReader(new GetMultiResultReader());
        setGetParamWriter(new TracEmptyParamWriter());
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

    private static class GetMultiResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracVersion version = (TracVersion) tracObj;
            final Object[] attrs = (Object[]) result;
            version.setEpoc((Integer) attrs[0]);
            version.setMajor((Integer) attrs[1]);
            version.setMinor((Integer) attrs[2]);
            return version;
        }

    }

}
