package org.guess880.trac_connector.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.ticket.TracTicketEnumField;
import org.guess880.trac_connector.object.ticket.TracTicketEnumFields;
import org.junit.Test;

public class AbsTracTicketEnumFieldAPITestBase {

    protected static AbsTracTicketEnumFieldAPI api;

    // FIXME no assertion
    @Test
    public void testGetAll() throws XmlRpcException {
        final TracTicketEnumFields fields = api.getAll();
        for (final TracTicketEnumField field : fields) {
            System.out.println(field);
        }
    }

    @Test
    public void testOperation() throws XmlRpcException {
        // create
        final TracTicketEnumField c1 = new TracTicketEnumField();
        c1.setName("this is name");
        c1.setValue("this is value");
        api.create(c1);
        try {
            final TracTicketEnumField g1 = api.get("this is name");
            assertThat(g1.getName(), is(equalTo(c1.getName())));
            assertThat(g1.getValue(), is(equalTo(c1.getValue())));
            // update
            api.update("this is name", "this is new value");
            final TracTicketEnumField g2 = api.get("this is name");
            assertThat(g2.getValue(), is(equalTo("this is new value")));
            // update2
            c1.setName("this is new name");
            c1.setValue("this is new value");
            try {
                api.update(c1);
                fail();
            } catch (XmlRpcException e) {
            }
        } finally {
            api.delete("this is name");
        }
        try {
            api.get("this is name");
            fail();
        } catch (XmlRpcException e) {
        }
    }

}
