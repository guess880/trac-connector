package org.guess880.trac_connector.api;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.search.TracSearchFilter;
import org.guess880.trac_connector.object.search.TracSearchFilters;
import org.guess880.trac_connector.object.search.TracSearchResult;
import org.guess880.trac_connector.object.search.TracSearchResults;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracSearchAPITest {

    private static TracSearchAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracSearchAPI(TracAPITestUtils.getTestConfig());
    }

    // FIXME no assertion
    @Test
    public void testGetSearchFilters() throws XmlRpcException {
        final TracSearchFilters filters = api.getSearchFilters(new TracSearchFilters());
        for (final TracSearchFilter filter : filters) {
            System.out.println(filter);
        }
    }

    // FIXME no assertion
    @Test
    public void testPerformSearch() throws XmlRpcException {
        final TracSearchResults results = api.performSearch("create.txt", null);
        for (final TracSearchResult result : results) {
            System.out.println(result);
        }
    }

}
