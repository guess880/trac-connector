package org.guess880.trac_connector.api;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.ticket.TracTicketStatus;
import org.guess880.trac_connector.object.ticket.TracTicketStatuses;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracTicketStatusAPITest {

    private static TracTicketStatusAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketStatusAPI(TracAPITestUtils.getTestConfig());
    }

    // FIXME no assertion
    @Test
    public void testGetAll() throws XmlRpcException {
        final TracTicketStatuses statuses = api.getAll();
        for (final TracTicketStatus status : statuses) {
            System.out.println(status);
        }
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testGetTracTicketStatus() throws XmlRpcException {
        api.get(new TracTicketStatus());
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testGetString() throws XmlRpcException {
        api.get("new");
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteTracTicketStatus() throws XmlRpcException {
        final TracTicketStatus status = new TracTicketStatus();
        status.setName("new");
        api.delete(status);
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteString() throws XmlRpcException {
        api.delete("new");
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testCreateTracTicketStatus() throws XmlRpcException {
        final TracTicketStatus status = new TracTicketStatus();
        status.setName("test");
        api.create(status);
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateTracTicketStatus() throws XmlRpcException {
        final TracTicketStatus status = new TracTicketStatus();
        status.setName("test");
        api.update(status);
    }

    @SuppressWarnings("deprecation")
    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateStringTracTicketStatus() throws XmlRpcException {
        final TracTicketStatus status = new TracTicketStatus();
        status.setName("new");
        api.update("test", status);
    }

}
