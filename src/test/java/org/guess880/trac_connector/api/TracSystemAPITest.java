package org.guess880.trac_connector.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.xmlrpc.XmlRpcException;
import org.guess880.trac_connector.object.system.TracMethod;
import org.guess880.trac_connector.object.system.TracMethods;
import org.guess880.trac_connector.object.system.TracVersion;
import org.junit.BeforeClass;
import org.junit.Test;

public class TracSystemAPITest {

    private static TracSystemAPI api;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new TracSystemAPI(TracAPITestUtils.getTestConfig());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMulticall() throws XmlRpcException {
        api.multicall();
    }

    private static final String[] EXPECTED_METHODS = new String[] {
            "system.multicall", "system.listMethods", "system.methodHelp",
            "system.methodSignature", "system.getAPIVersion", "ticket.query",
            "ticket.getRecentChanges", "ticket.getAvailableActions",
            "ticket.getActions", "ticket.get", "ticket.create",
            "ticket.update", "ticket.delete", "ticket.changeLog",
            "ticket.listAttachments", "ticket.getAttachment",
            "ticket.putAttachment", "ticket.deleteAttachment",
            "ticket.getTicketFields", "ticket.status.getAll",
            "ticket.status.get", "ticket.status.delete",
            "ticket.status.create", "ticket.status.update",
            "ticket.component.getAll", "ticket.component.get",
            "ticket.component.delete", "ticket.component.create",
            "ticket.component.update", "ticket.version.getAll",
            "ticket.version.get", "ticket.version.delete",
            "ticket.version.create", "ticket.version.update",
            "ticket.milestone.getAll", "ticket.milestone.get",
            "ticket.milestone.delete", "ticket.milestone.create",
            "ticket.milestone.update", "ticket.type.getAll", "ticket.type.get",
            "ticket.type.delete", "ticket.type.create", "ticket.type.update",
            "ticket.resolution.getAll", "ticket.resolution.get",
            "ticket.resolution.delete", "ticket.resolution.create",
            "ticket.resolution.update", "ticket.priority.getAll",
            "ticket.priority.get", "ticket.priority.delete",
            "ticket.priority.create", "ticket.priority.update",
            "ticket.severity.getAll", "ticket.severity.get",
            "ticket.severity.delete", "ticket.severity.create",
            "ticket.severity.update", "wiki.getRecentChanges",
            "wiki.getRPCVersionSupported", "wiki.getPage",
            "wiki.getPageVersion", "wiki.getPageHTML",
            "wiki.getPageHTMLVersion", "wiki.getAllPages", "wiki.getPageInfo",
            "wiki.getPageInfoVersion", "wiki.putPage", "wiki.listAttachments",
            "wiki.getAttachment", "wiki.putAttachment", "wiki.putAttachmentEx",
            "wiki.deletePage", "wiki.deleteAttachment", "wiki.listLinks",
            "wiki.wikiToHtml", "search.getSearchFilters",
            "search.performSearch" };

    @Test
    public void testListMethods() throws XmlRpcException {
        final TracMethods methods = api.listMethods();
        int index = 0;
        for (final TracMethod method : methods) {
            assertThat(method.getName(), is(equalTo(EXPECTED_METHODS[index])));
            index++;
        }
    }

    @Test
    public void testMethodHelp() throws XmlRpcException {
        final TracMethod method = api.methodHelp("ticket.delete");
        assertThat(method.getHelp().getHelp(), is(equalTo("int ticket.delete(int id)\n\nDelete ticket with the given id. ")));
    }

    @Test
    public void testMethodSignature() throws XmlRpcException {
        final TracMethod method = api.methodSignature("ticket.query");
        assertThat(method.getSignature().getReturnType(), is(equalTo("array")));
        assertThat(method.getSignature().getParameterTypes(), is(equalTo("array,string")));
    }

    @Test
    public void testGetAPIVersion() throws XmlRpcException {
        final TracVersion version = api.getAPIVersion();
        assertThat(version.getEpoc(), is(equalTo(1)));
        assertThat(version.getMajor(), is(equalTo(1)));
        assertThat(version.getMinor(), is(equalTo(2)));
    }

}
