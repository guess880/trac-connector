package org.guess880.trac_connector;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.TracTicket;
import org.guess880.trac_connector.object.TracTicketAttachment;
import org.guess880.trac_connector.object.TracTicketAttachments;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracConnectorTest {

    private static TracConnector connector;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connector = new TracConnector();
        connector.setUp(new TracConnectConfig()
                .setUrl("http://localhost/trac/SampleProject/login/xmlrpc")
                .setUsername("rpc").setPassword("rpc"));
    }

    @Test
    public void testTicket() throws XmlRpcException, IOException {
        final TracTicket t1 = new TracTicket();
        t1.setSummary("this is summary.");
        t1.setDescription("this is description.");
        connector.createTicket(t1);
        try {
            final TracTicket t2 = new TracTicket();
            t2.setId(t1.getId());
            connector.getTicket(t2);
            assertThat(t2.getSummary(), is(equalTo(t1.getSummary())));
            assertThat(t2.getDescription(), is(equalTo(t1.getDescription())));
            t1.setSummary("this is updated summary.");
            t1.setDescription("this is updated description.");
            t1.setUpdateComment("this is comment.");
            connector.updateTicket(t1);
            final TracTicket t3 = new TracTicket();
            t3.setId(t1.getId());
            connector.getTicket(t3);
            assertThat(t3.getSummary(), is(equalTo(t1.getSummary())));
            assertThat(t3.getDescription(), is(equalTo(t1.getDescription())));
        } finally {
            connector.deleteTicket(t1);
        }
    }

    @Test
    public void testAttachments() throws XmlRpcException, IOException {
        final TracTicket t1 = new TracTicket();
        t1.setSummary("this is summary.");
        t1.setDescription("this is description.");
        connector.createTicket(t1);
        try {
            final File f1 = new File("target/test-classes/create.txt");
            byte[] b1 = new byte[(int) f1.length()];
            final FileInputStream in1 = new FileInputStream(f1);
            try {
                in1.read(b1);
            } finally {
                in1.close();
            }
            final TracTicketAttachment a1 = t1.getAttachments().newAttachment()
                    .setFilename("create.txt")
                    .setDescription("this is description.")
                    .setData(b1);
            connector.putAttachment(a1);
            final TracTicket t2 = new TracTicket();
            t2.setId(t1.getId());
            connector.getTicket(t2);
            final TracTicketAttachments as = connector.listAttachments(t2
                    .getAttachments());
            for (TracTicketAttachment a : as) {
                connector.getAttachment(a);
                assertThat(a.getFilename(), is(equalTo(a1.getFilename())));
                assertThat(a.getDescription(), is(equalTo(a1.getDescription())));
                assertThat(a.getSize(), is(equalTo(a1.getSize())));
                assertThat(a.getTime(), is(not(nullValue())));
                assertThat(a.getAuthor(), is(not(nullValue())));
                assertThat(a.getData(), is(equalTo(b1)));
            }
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
            connector.putAttachment(a1);
            final TracTicket t3 = new TracTicket();
            t3.setId(t1.getId());
            connector.getTicket(t3);
            final TracTicketAttachments as2 = connector.listAttachments(t3
                    .getAttachments());
            for (TracTicketAttachment a : as2) {
                connector.getAttachment(a);
                assertThat(a.getFilename(), is(equalTo(a1.getFilename())));
                assertThat(a.getDescription(), is(equalTo(a1.getDescription())));
                assertThat(a.getSize(), is(equalTo(a1.getSize())));
                assertThat(a.getTime(), is(not(nullValue())));
                assertThat(a.getAuthor(), is(not(nullValue())));
                assertThat(a.getData(), is(equalTo(b2)));
            }
        } finally {
            connector.deleteTicket(t1);
        }
    }

}
