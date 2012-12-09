package org.guess880.trac_connector.attr;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbsTracAttributes {

    private final String name;

    protected AbsTracAttributes(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbsTracAttributes)) {
            return false;
        }
        AbsTracAttributes other = (AbsTracAttributes) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
