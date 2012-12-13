package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;

public class TracSearchFilter extends TracObjectBase {

    private String name;

    private String description;

    public TracSearchFilter() {
        setGetMultiResultReader(new GetMultiResultReader());
    }

    public String getName() {
        return name;
    }

    public TracSearchFilter setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TracSearchFilter setDescription(final String description) {
        this.description = description;
        return this;
    }

    private static class GetMultiResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracSearchFilter filter = (TracSearchFilter) tracObj;
            final Object[] attrs = (Object[]) result;
            filter.setName((String) attrs[0]);
            filter.setDescription((String) attrs[1]);
            return filter;
        }

    }

}
