package org.guess880.trac_connector.api;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.search.TracSearchFilters;
import org.guess880.trac_connector.object.search.TracSearchResults;

public class TracSearchAPI extends TracAPITemplate {

    public TracSearchAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
    }

    public TracSearchAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
    }

    public TracSearchFilters getSearchFilters(final TracSearchFilters filters) throws XmlRpcException {
        filters.readGetMultiResult(getRpcClient().execute("search.getSearchFilters", filters.writeGetMultiParam()));
        return filters;
    }

    public TracSearchFilters getSearchFilters() throws XmlRpcException {
        return getSearchFilters(new TracSearchFilters());
    }

    public TracSearchResults performSearch(final TracSearchResults results) throws XmlRpcException {
        results.readGetMultiResult(getRpcClient().execute("search.performSearch", results.writeGetMultiParam()));
        return results;
    }

    public TracSearchResults performSearch(final String query, final TracSearchFilters filters) throws XmlRpcException {
        return performSearch(new TracSearchResults().setQuery(query).setFilters(filters));
    }

}
