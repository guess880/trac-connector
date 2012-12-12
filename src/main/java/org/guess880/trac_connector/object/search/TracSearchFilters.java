package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyAPIObjectWriter;

public class TracSearchFilters extends AbsTracObjects<TracSearchFilter> {

    public TracSearchFilters() {
        super();
        setGetMultiParamWriter(new TracEmptyAPIObjectWriter());
    }

    @Override
    public TracSearchFilter newElement() {
        final TracSearchFilter filter = new TracSearchFilter();
        add(filter);
        return filter;
    }

}
