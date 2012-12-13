package org.guess880.trac_connector.object.search;

import org.guess880.trac_connector.object.AbsTracObjects;

public class TracSearchResults extends AbsTracObjects<TracSearchResult> {

    private String query;

    private TracSearchFilters filters;

    public TracSearchResults() {
        super();
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

}
