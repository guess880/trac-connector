package org.guess880.trac_connector.api;

import org.junit.BeforeClass;

public class TracTicketTypeAPITest extends
        AbsTracTicketEnumFieldAPITestBase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketTypeAPI(TracAPITestUtils.getTestConfig());
    }

}
