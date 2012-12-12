package org.guess880.trac_connector.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.ticket.TracTicketComponent;
import org.guess880.trac_connector.object.ticket.TracTicketComponents;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracTicketComponentAPITest {

    private static TracTicketComponentAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketComponentAPI(TracAPITestUtils.getTestConfig());
    }

    @Test
    public void testGetAll() throws XmlRpcException {
        final TracTicketComponents components = api.getAll();
        for (final TracTicketComponent component : components) {
            System.out.println(component);
        }
    }

    @Test
    public void testOperation() throws XmlRpcException {
        // create
        final TracTicketComponent c1 = new TracTicketComponent();
        c1.setName("this is name");
        c1.setDescription("this is description.");
        c1.setOwner("this is owner");
        api.create(c1);
        try {
            final TracTicketComponent g1 = api.get("this is name");
            assertThat(g1.getName(), is(equalTo(c1.getName())));
            assertThat(g1.getDescription(), is(equalTo(c1.getDescription())));
            assertThat(g1.getOwner(), is(equalTo(c1.getOwner())));
            // update
            c1.setName("this is new name");
            c1.setDescription("this is new description.");
            c1.setOwner("this is new owner");
            api.update("this is name", c1);
            final TracTicketComponent g2 = api.get("this is new name");
            assertThat(g2.getName(), is(equalTo(c1.getName())));
            assertThat(g2.getDescription(), is(equalTo(c1.getDescription())));
            assertThat(g2.getOwner(), is(equalTo(c1.getOwner())));
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
