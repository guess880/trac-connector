package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.util.Date;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.search.TracSearchFilter;
import org.guess880.trac_connector.object.search.TracSearchFilters;
import org.guess880.trac_connector.object.search.TracSearchResult;
import org.guess880.trac_connector.object.search.TracSearchResults;

public class TracSearchAPI extends TracAPIBase {

    private TracAPIResultReader getSearchFiltersResultReader;

    private TracAPIResultReader performSearchResultReader;

    private TracAPIParamWriter getSearchFiltersParamWriter;

    private TracAPIParamWriter performSearchParamWriter;

    public TracSearchAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        setUpConverter();
    }

    public TracSearchAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        setUpConverter();
    }

    private void setUpConverter() {
        getSearchFiltersResultReader = new TracMultiResultReader().setOneResultReader(new FilterResultReader());
        getSearchFiltersParamWriter = new TracEmptyParamWriter();
        performSearchResultReader = new TracMultiResultReader().setOneResultReader(new PerformSearchResultReader());
        performSearchParamWriter = new PerformSearchParamWriter();
    }

    public TracSearchFilters getSearchFilters(final TracSearchFilters filters) throws XmlRpcException {
        getSearchFiltersResultReader.read(filters, getRpcClient().execute("search.getSearchFilters", getSearchFiltersParamWriter.write(filters)));
        return filters;
    }

    public TracSearchFilters getSearchFilters() throws XmlRpcException {
        return getSearchFilters(new TracSearchFilters());
    }

    public TracSearchResults performSearch(final TracSearchResults results) throws XmlRpcException {
        performSearchResultReader.read(results, getRpcClient().execute("search.performSearch", performSearchParamWriter.write(results)));
        return results;
    }

    public TracSearchResults performSearch(final String query, final TracSearchFilters filters) throws XmlRpcException {
        return performSearch(new TracSearchResults().setQuery(query).setFilters(filters));
    }

    private static class FilterResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracSearchFilter filter = (TracSearchFilter) tracObj;
            final Object[] attrs = (Object[]) result;
            filter.setName((String) attrs[0]);
            filter.setDescription((String) attrs[1]);
            return filter;
        }
    }

    private static class PerformSearchResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracSearchResult searchResult = (TracSearchResult) tracObj;
            final Object[] attrs = (Object[]) result;
            searchResult.setHref((String) attrs[0]);
            searchResult.setTitle((String) attrs[1]);
            searchResult.setDate((Date) attrs[2]);
            searchResult.setAuthor((String) attrs[3]);
            searchResult.setExcerpt((String) attrs[4]);
            return searchResult;
        }

    }

    private static class PerformSearchParamWriter implements
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
