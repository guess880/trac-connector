package org.guess880.trac_connector.object;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TracStructBase implements TracObject {

    private Map<String, Object> values;

    protected TracStructBase() {
        super();
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public TracStructBase setValues(final Map<String, Object> values) {
        this.values = values;
        return this;
    }

    public Object getValue(final TracAttributeBase attr) {
        return values == null ? null : values.get(attr.getName());
    }

    public TracStructBase setValue(final TracAttributeBase attr, final Object value) {
        if (values == null) {
            values = new HashMap<String, Object>();
        }
        values.put(attr.getName(), value);
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
