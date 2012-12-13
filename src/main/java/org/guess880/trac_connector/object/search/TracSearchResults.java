package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.AbsTracObjects;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracSearchResults extends AbsTracObjects<TracSearchResult> {

    private String query;

    private TracSearchFilters filters;

    public TracSearchResults() {
        super();
        setGetMultiParamWriter(new GetMultiParamWriter());
    }

    @Override
    protected TracSearchResult newElement() {
        return new TracSearchResult();
    }

    public String getQuery() {
        return query;
    }

    public TracSearchResults setQuery(final String query) {
        this.query = query;
        return this;
    }

    public TracSearchFilters getFilters() {
        return filters;
    }

    public TracSearchResults setFilters(final TracSearchFilters filters) {
        this.filters = filters;
        return this;
    }

    private static class GetMultiParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracSearchResults results = (TracSearchResults) tracObj;
            return results.getFilters() == null
                    ? new Object[] { results.getQuery() }
                    : new Object[] { results.getQuery(), results.getFilters() };
        }

    }

}
