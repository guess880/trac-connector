package org.guess880.trac_connector.object;

import java.util.HashMap;
import java.util.Map;


public class TracStruct extends TracObject {

    private Map<String, Object> values;

    public TracStruct() {
        super();
        setGetResultReader(new TrucStructGetResultReader());
    }

    protected Map<String, Object> getValues() {
        return values;
    }

    protected TracObject setValues(final Map<String, Object> values) {
        this.values = values;
        return this;
    }

    public Object getValue(final AbsTracAttributes attr) {
        return values == null ? null : values.get(attr.getName());
    }

    public TracObject setValue(final AbsTracAttributes attr, final Object value) {
        if (values == null) {
            values = new HashMap<String, Object>();
        }
        values.put(attr.getName(), value);
        return this;
    }

}
