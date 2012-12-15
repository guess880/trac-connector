package org.guess880.trac_connector.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.ticket.TracTicket;
import org.guess880.trac_connector.object.ticket.TracTicketAction;
import org.guess880.trac_connector.object.ticket.TracTicketActions;
import org.guess880.trac_connector.object.ticket.TracTicketAttachment;
import org.guess880.trac_connector.object.ticket.TracTicketAttachments;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLog;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLogs;
import org.guess880.trac_connector.object.ticket.TracTicketField;
import org.guess880.trac_connector.object.ticket.TracTicketFields;
import org.guess880.trac_connector.object.ticket.TracTickets;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracTicketAPITest {

    private static TracTicketAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracTicketAPI(TracAPITestUtils.getTestConfig());
    }

    // FIXME no assertion
    @Test
    public void testQuery() throws XmlRpcException {
        final TracTickets tickets = api.query("status!=closed");
        for (TracTicket ticket : tickets) {
            System.out.println(ticket.getId());
        }
    }

    // FIXME no assertion
    @Test
    public void testGetRecentChanges() throws XmlRpcException {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2012, 1, 1);
        final TracTickets tickets = api.getRecentChanges(cal.getTime());
        for (TracTicket ticket : tickets) {
            System.out.println(ticket.getId());
        }
    }

    // FIXME no assertion
    @SuppressWarnings("deprecation")
    @Test
    public void testGetAvailableActions() throws XmlRpcException {
        final Object obj = api.getAvailableActions(1);
        TracAPITestUtils.sysOutArray(obj);
    }

    // FIXME no assertion
    @Test
    public void testGetActions() throws XmlRpcException {
        final TracTicketActions actions = api.getActions(1);
        for (final TracTicketAction action : actions) {
            System.out.println(action);
        }
    }

    @Test
    public void testTicket() throws XmlRpcException, IOException {
        final TracTicket t1 = new TracTicket();
        t1.setSummary("this is summary.");
        t1.setDescription("this is description.");
        api.create(t1);
        try {
            final TracTicket t2 = new TracTicket();
            t2.setId(t1.getId());
            api.get(t2);
            assertThat(t2.getSummary(), is(equalTo(t1.getSummary())));
            assertThat(t2.getDescription(), is(equalTo(t1.getDescription())));
            t1.setSummary("this is updated summary.");
            t1.setDescription("this is updated description.");
            t1.setUpdateComment("this is comment.");
            api.update(t1);
            final TracTicket t3 = new TracTicket();
            t3.setId(t1.getId());
            api.get(t3);
            assertThat(t3.getSummary(), is(equalTo(t1.getSummary())));
            assertThat(t3.getDescription(), is(equalTo(t1.getDescription())));
        } finally {
            api.delete(t1);
        }
    }

    @Test
    public void testAttachments() throws XmlRpcException, IOException {
        final TracTicket t1 = new TracTicket();
        t1.setSummary("this is summary.");
        t1.setDescription("this is description.");
        api.create(t1);
        try {
            // create test
            final File f1 = new File("target/test-classes/create.txt");
            byte[] b1 = new byte[(int) f1.length()];
            final FileInputStream in1 = new FileInputStream(f1);
            try {
                in1.read(b1);
            } finally {
                in1.close();
            }
            final TracTicketAttachment a1 = t1.getAttachments().addNewElement()
                    .setFilename("create.txt")
                    .setDescription("this is description.")
                    .setData(b1);
            api.putAttachment(a1);
            final TracTicket t2 = new TracTicket();
            t2.setId(t1.getId());
            api.get(t2);
            final TracTicketAttachments as = api.listAttachments(t2);
            for (TracTicketAttachment a : as) {
                api.getAttachment(a);
                assertThat(a.getFilename(), is(equalTo(a1.getFilename())));
                assertThat(a.getDescription(), is(equalTo(a1.getDescription())));
                assertThat(a.getSize(), is(equalTo(a1.getSize())));
                assertThat(a.getTime(), is(not(nullValue())));
                assertThat(a.getAuthor(), is(not(nullValue())));
                assertThat(a.getData(), is(equalTo(b1)));
            }
            // update test
            final File f2 = new File("target/test-classes/update.txt");
            byte[] b2 = new byte[(int) f2.length()];
            final FileInputStream in2 = new FileInputStream(f2);
            try {
                in2.read(b2);
            } finally {
                in2.close();
            }
            a1.setDescription("this is updated description.");
            a1.setData(b2);
            api.putAttachment(a1);
            final TracTicket t3 = new TracTicket();
            t3.setId(t1.getId());
            api.get(t3);
            final TracTicketAttachments as2 = api.listAttachments(t3);
            for (TracTicketAttachment a : as2) {
                api.getAttachment(a);
                assertThat(a.getFilename(), is(equalTo(a1.getFilename())));
                assertThat(a.getDescription(), is(equalTo(a1.getDescription())));
                assertThat(a.getSize(), is(equalTo(a1.getSize())));
                assertThat(a.getTime(), is(not(nullValue())));
                assertThat(a.getAuthor(), is(not(nullValue())));
                assertThat(a.getData(), is(equalTo(b2)));
            }
            // delete test
            api.deleteAttachment(a1);
            final TracTicketAttachments as3 = api.listAttachments(t1);
            assertThat(as3.isEmpty(), is(equalTo(true)));
        } finally {
            api.delete(t1);
        }
    }

    // FIXME no assertion
    @Test
    public void testChangeLog() throws XmlRpcException {
        final TracTicketChangeLogs logs = api.changeLog(13);
        for (final TracTicketChangeLog log : logs) {
            System.out.println(log);
        }
    }

    // FIXME no assertion
    @Test
    public void testGetTicketFields() throws XmlRpcException {
        final TracTicketFields fields = api.getTicketFields();
        for (final TracTicketField field : fields) {
            System.out.println(field);
        }
    }

}
