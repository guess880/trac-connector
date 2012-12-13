package org.guess880.trac_connector.object.system;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracVersion implements TracObject {

    private int epoc;

    private int major;

    private int minor;

    public TracVersion() {
        super();
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
