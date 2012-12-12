package org.guess880.trac_connector.api;

import org.junit.BeforeClass;

public class TracTicketPriorityAPITest extends
        AbsTracTicketEnumFieldAPITestBase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketPriorityAPI(TracAPITestUtils.getTestConfig());
    }

}
