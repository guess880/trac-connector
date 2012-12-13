package org.guess880.trac_connector.object;

import java.util.HashMap;
import java.util.Map;

import org.guess880.trac_connector.object.converter.TrucStructGetResultReader;


public class TracStructTemplate extends TracObjectTemplate {

    private Map<String, Object> values;

    public TracStructTemplate() {
        super();
        setGetResultReader(new TrucStructGetResultReader());
    }

    protected Map<String, Object> getValues() {
        return values;
    }

    public TracObjectTemplate setValues(final Map<String, Object> values) {
        this.values = values;
        return this;
    }

    public Object getValue(final AbsTracAttribute attr) {
        return values == null ? null : values.get(attr.getName());
    }

    public TracObjectTemplate setValue(final AbsTracAttribute attr, final Object value) {
        if (values == null) {
            values = new HashMap<String, Object>();
        }
        values.put(attr.getName(), value);
        return this;
    }

}
