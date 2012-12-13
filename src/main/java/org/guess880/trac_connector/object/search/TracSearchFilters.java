package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracSearchFilters extends AbsTracObjects<TracSearchFilter> {

    public TracSearchFilters() {
        super();
    }

    @Override
    protected TracSearchFilter newElement() {
        return new TracSearchFilter();
    }

}
