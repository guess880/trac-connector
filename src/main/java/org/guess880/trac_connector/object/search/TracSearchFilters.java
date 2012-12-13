package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;

public class TracSearchFilters extends AbsTracObjects<TracSearchFilter> {

    public TracSearchFilters() {
        super();
        setGetMultiParamWriter(new TracEmptyParamWriter());
    }

    @Override
    protected TracSearchFilter newElement() {
        return new TracSearchFilter();
    }

}
