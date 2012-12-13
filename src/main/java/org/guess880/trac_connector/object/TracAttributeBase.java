package org.guess880.trac_connector.object;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TracAttributeBase {

    private final String name;

    protected TracAttributeBase(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TracAttributeBase)) {
            return false;
        }
        final TracAttributeBase other = (TracAttributeBase) obj;
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
        return 31 + ((name == null) ? 0 : name.hashCode());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
