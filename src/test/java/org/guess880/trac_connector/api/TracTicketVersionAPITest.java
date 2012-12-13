package org.guess880.trac_connector.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.ticket.TracTicketVersion;
import org.guess880.trac_connector.object.ticket.TracTicketVersions;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracTicketVersionAPITest {

    private static TracTicketVersionAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketVersionAPI(TracAPITestUtils.getTestConfig());
    }

    // FIXME no assertion
    @Test
    public void testGetAll() throws XmlRpcException {
        final TracTicketVersions versions = api.getAll();
        for (final TracTicketVersion version : versions) {
            System.out.println(version);
        }
    }

    @Test
    public void testOperation() throws Exception {
        // create
        final TracTicketVersion c1 = new TracTicketVersion();
        c1.setName("this is name");
        c1.setDescription("this is description.");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2012,11,11);
        c1.setTime(cal.getTime());
        api.create(c1);
        try {
            final TracTicketVersion g1 = api.get("this is name");
            assertThat(g1.getName(), is(equalTo(c1.getName())));
            assertThat(g1.getDescription(), is(equalTo(c1.getDescription())));
            assertThat(g1.getTime(), is(equalTo(c1.getTime())));
        } catch (Exception e) {
            api.delete("this is name");
            throw e;
        }
        // update
        c1.setName("this is new name");
        c1.setDescription("this is new description.");
        cal.set(2012,11,31);
        c1.setTime(cal.getTime());
        api.update("this is name", c1);
        try {
            final TracTicketVersion g2 = api.get("this is new name");
            assertThat(g2.getName(), is(equalTo(c1.getName())));
            assertThat(g2.getDescription(), is(equalTo(c1.getDescription())));
            assertThat(g2.getTime(), is(equalTo(c1.getTime())));
        } finally {
            api.delete("this is new name");
        }
        try {
            api.get("this is new name");
            fail();
        } catch (XmlRpcException e) {
        }
    }

}
