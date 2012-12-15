package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.util.Date;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.search.TracSearchFilter;
import org.guess880.trac_connector.object.search.TracSearchFilters;
import org.guess880.trac_connector.object.search.TracSearchResult;
import org.guess880.trac_connector.object.search.TracSearchResults;

public class TracSearchAPI extends TracAPIBase {

    private TracMultiResultReader<TracSearchFilter, TracSearchFilters> getSearchFiltersResultReader;

    private TracMultiResultReader<TracSearchResult, TracSearchResults> performSearchResultReader;

    private TracAPIParamWriter<TracSearchFilters> getSearchFiltersParamWriter;

    private TracAPIParamWriter<TracSearchResults> performSearchParamWriter;

    public TracSearchAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        setUpConverter();
    }

    public TracSearchAPI(final TracAPIConfig cfg)
            throws MalformedURLException {
        super(cfg);
        setUpConverter();
    }

    private void setUpConverter() {
        getSearchFiltersResultReader = new TracMultiResultReader<TracSearchFilter, TracSearchFilters>()
                .setOneResultReader(new FilterResultReader());
        getSearchFiltersParamWriter = new TracEmptyParamWriter<TracSearchFilters>();
        performSearchResultReader = new TracMultiResultReader<TracSearchResult, TracSearchResults>()
                .setOneResultReader(new PerformSearchResultReader());
        performSearchParamWriter = new PerformSearchParamWriter();
    }

    protected TracMultiResultReader<TracSearchFilter, TracSearchFilters> getGetSearchFiltersResultReader() {
        return getSearchFiltersResultReader;
    }

    public TracSearchAPI setGetSearchFiltersResultReader(
            final TracMultiResultReader<TracSearchFilter, TracSearchFilters> getSearchFiltersResultReader) {
        this.getSearchFiltersResultReader = getSearchFiltersResultReader;
        return this;
    }

    protected TracMultiResultReader<TracSearchResult, TracSearchResults> getPerformSearchResultReader() {
        return performSearchResultReader;
    }

    public TracSearchAPI setPerformSearchResultReader(
            final TracMultiResultReader<TracSearchResult, TracSearchResults> performSearchResultReader) {
        this.performSearchResultReader = performSearchResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracSearchFilters> getGetSearchFiltersParamWriter() {
        return getSearchFiltersParamWriter;
    }

    public TracSearchAPI setGetSearchFiltersParamWriter(
            final TracAPIParamWriter<TracSearchFilters> getSearchFiltersParamWriter) {
        this.getSearchFiltersParamWriter = getSearchFiltersParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracSearchResults> getPerformSearchParamWriter() {
        return performSearchParamWriter;
    }

    public TracSearchAPI setPerformSearchParamWriter(
            final TracAPIParamWriter<TracSearchResults> performSearchParamWriter) {
        this.performSearchParamWriter = performSearchParamWriter;
        return this;
    }

    public TracSearchFilters getSearchFilters(final TracSearchFilters filters)
            throws XmlRpcException {
        return getSearchFiltersResultReader.read(
                filters,
                getRpcClient().execute("search.getSearchFilters",
                        getSearchFiltersParamWriter.write(filters)));
    }

    public TracSearchFilters getSearchFilters() throws XmlRpcException {
        return getSearchFilters(new TracSearchFilters());
    }

    public TracSearchResults performSearch(final TracSearchResults results)
            throws XmlRpcException {
        return performSearchResultReader.read(
                results,
                getRpcClient().execute("search.performSearch",
                        performSearchParamWriter.write(results)));
    }

    public TracSearchResults performSearch(final String query,
            final TracSearchFilters filters) throws XmlRpcException {
        return performSearch(new TracSearchResults().setQuery(query)
                .setFilters(filters));
    }

    private static class FilterResultReader implements
            TracAPIResultReader<TracSearchFilter> {

        @Override
        public TracSearchFilter read(final TracSearchFilter tracObj,
                final Object result) {
            final Object[] attrs = (Object[]) result;
            return tracObj.setName((String) attrs[0]).setDescription(
                    (String) attrs[1]);
        }
    }

    private static class PerformSearchResultReader implements
            TracAPIResultReader<TracSearchResult> {

        @Override
        public TracSearchResult read(final TracSearchResult tracObj,
                final Object result) {
            final Object[] attrs = (Object[]) result;
            return tracObj.setHref((String) attrs[0])
                    .setTitle((String) attrs[1]).setDate((Date) attrs[2])
                    .setAuthor((String) attrs[3]).setExcerpt((String) attrs[4]);
        }

    }

    private static class PerformSearchParamWriter implements
            TracAPIParamWriter<TracSearchResults> {

        @Override
        public Object[] write(final TracSearchResults tracObj) {
            return tracObj.getFilters() == null ? new Object[] { tracObj
                    .getQuery() } : new Object[] { tracObj.getQuery(),
                    tracObj.getFilters() };
        }

    }

}
