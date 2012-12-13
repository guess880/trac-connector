package org.guess880.trac_connector.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
        TracSearchAPITest.class, TracSystemAPITest.class,
        TracTicketAPITest.class, TracTicketComponentAPITest.class,
        TracTicketMilestoneAPITest.class, TracTicketPriorityAPITest.class,
        TracTicketResolutionAPITest.class, TracTicketSeverityAPITest.class,
        TracTicketStatusAPITest.class, TracTicketTypeAPITest.class,
        TracTicketVersionAPITest.class })
public class AllTests {

}
