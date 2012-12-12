package org.guess880.trac_connector.api;

import org.junit.BeforeClass;

public class TracTicketResolutionAPITest extends
        AbsTracTicketEnumFieldAPITestBase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketResolutionAPI(TracAPITestUtils.getTestConfig());
    }

}
