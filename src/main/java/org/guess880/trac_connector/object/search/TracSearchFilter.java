package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracObject;

public class TracSearchFilter extends TracObject {

    private String name;

    private String description;

    public TracSearchFilter() {
        setAPIObjectReader(new DefaultAPIObjectReader());
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

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracSearchFilter filter = (TracSearchFilter) tracObj;
            final Object[] attrs = (Object[]) apiObj;
            filter.setName((String) attrs[0]);
            filter.setDescription((String) attrs[1]);
            return filter;
        }

    }

}
