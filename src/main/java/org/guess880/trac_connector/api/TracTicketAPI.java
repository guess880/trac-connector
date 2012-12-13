package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.converter.TrucStructGetResultReader;
import org.guess880.trac_connector.object.ticket.TracTicket;
import org.guess880.trac_connector.object.ticket.TracTicket.Attribute;
import org.guess880.trac_connector.object.ticket.TracTicketAttachment;
import org.guess880.trac_connector.object.ticket.TracTicketAttachments;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLog;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLogs;
import org.guess880.trac_connector.object.ticket.TracTicketFields;
import org.guess880.trac_connector.object.ticket.TracTickets;

public class TracTicketAPI extends TracAPIBase {

    private TracTicketComponentAPI component;

    private TracTicketMilestoneAPI milestone;

    private TracTicketPriorityAPI priority;

    private TracTicketResolutionAPI resolution;

    private TracTicketSeverityAPI severity;

    private TracTicketStatusAPI status;

    private TracTicketTypeAPI type;

    private TracTicketVersionAPI version;

    private TracAPIResultReader queryResultReader;

    private TracAPIParamWriter queryParamWriter;

    private TracAPIResultReader getRecentChangesResultReader;

    private TracAPIParamWriter getRecentChangesParamWriter;

    private TracAPIResultReader getResultReader;

    private TracAPIParamWriter getParamWriter;

    private TracAPIResultReader createResultReader;

    private TracAPIParamWriter createParamWriter;

    private TracAPIParamWriter deleteParamWriter;

    private TracAPIResultReader updateResultReader;

    private TracAPIParamWriter updateParamWriter;

    private TracAPIResultReader changeLogResultReader;

    private TracAPIParamWriter changeLogParamWriter;

    private TracAPIResultReader listAttachmentsResultReader;

    private TracAPIParamWriter listAttachmentsParamWriter;

    private TracAPIResultReader getAttachmentResultReader;

    private TracAPIParamWriter getAttachmentParamWriter;

    private TracAPIResultReader putAttachmentResultReader;

    private TracAPIParamWriter putAttachmentParamWriter;

    private TracAPIParamWriter deleteAttachmentParamWriter;

    private TracAPIResultReader getTicketFieldsResultReader;

    private TracAPIParamWriter getTicketFieldsParamWriter;

    public TracTicketAPI(final XmlRpcClient rpcClient) {
        super(rpcClient);
        newMemberAPI();
        setUpConverter();
    }

    public TracTicketAPI(final TracConnectConfig cfg)
            throws MalformedURLException {
        super(cfg);
        newMemberAPI();
        setUpConverter();
    }

    private void newMemberAPI() {
        component = new TracTicketComponentAPI(getRpcClient());
        milestone = new TracTicketMilestoneAPI(getRpcClient());
        priority = new TracTicketPriorityAPI(getRpcClient());
        resolution = new TracTicketResolutionAPI(getRpcClient());
        severity = new TracTicketSeverityAPI(getRpcClient());
        status = new TracTicketStatusAPI(getRpcClient());
        type = new TracTicketTypeAPI(getRpcClient());
        version = new TracTicketVersionAPI(getRpcClient());
    }

    private void setUpConverter() {
        queryResultReader = new TracMultiResultReader()
                .setOneResultReader(new IdOnlyResultReader());
        queryParamWriter = new QueryParamWriter();
        getRecentChangesResultReader = new TracMultiResultReader()
                .setOneResultReader(new IdOnlyResultReader());
        getRecentChangesParamWriter = new GetRecentChangesParamWriter();
        getResultReader = new GetResultReader();
        getParamWriter = new IdOnlyParamWriter();
        createResultReader = new IdOnlyResultReader();
        createParamWriter = new CreateParamWriter();
        deleteParamWriter = new IdOnlyParamWriter();
        updateResultReader = new GetResultReader();
        updateParamWriter = new UpdateParamWriter();
        changeLogResultReader = new TracMultiResultReader()
                .setOneResultReader(new ChangeLogResultReader());
        changeLogParamWriter = new ChangeLogParamWriter();
        listAttachmentsResultReader = new TracMultiResultReader()
                .setOneResultReader(new ListAttachmentsResultReader());
        listAttachmentsParamWriter = new ListAttachmentsParamWriter();
        getAttachmentResultReader = new GetAttachmentResultReader();
        getAttachmentParamWriter = new GetAttachmentParamWriter();
        putAttachmentResultReader = new PutAttachmentResultReader();
        putAttachmentParamWriter = new PutAttachmentParamWriter();
        deleteAttachmentParamWriter = new DeleteAttachmentParamWriter();
        getTicketFieldsResultReader = new TracMultiResultReader()
                .setOneResultReader(new TrucStructGetResultReader());
        getTicketFieldsParamWriter = new TracEmptyParamWriter();
    }

    public TracTicketComponentAPI component() {
        return component;
    }

    public TracTicketMilestoneAPI milestone() {
        return milestone;
    }

    public TracTicketPriorityAPI priority() {
        return priority;
    }

    public TracTicketResolutionAPI resolution() {
        return resolution;
    }

    public TracTicketSeverityAPI severity() {
        return severity;
    }

    public TracTicketStatusAPI status() {
        return status;
    }

    public TracTicketTypeAPI type() {
        return type;
    }

    public TracTicketVersionAPI version() {
        return version;
    }

    public TracTickets query(final TracTickets tickets) throws XmlRpcException {
        queryResultReader.read(
                tickets,
                getRpcClient().execute("ticket.query",
                        queryParamWriter.write(tickets)));
        return tickets;
    }

    public TracTickets query(final String qstr) throws XmlRpcException {
        return query(new TracTickets().setQueryStr(qstr));
    }

    public TracTickets getRecentChanges(final TracTickets tickets) throws XmlRpcException {
        getRecentChangesResultReader.read(
                tickets,
                getRpcClient().execute("ticket.getRecentChanges",
                        getRecentChangesParamWriter.write(tickets)));
        return tickets;
    }

    public TracTickets getRecentChanges(final Date since) throws XmlRpcException {
        return getRecentChanges(new TracTickets().setSince(since));
    }

    /**
     * 
     * @param id
     * @return
     * @throws XmlRpcException
     * @Deprecated will be removed. Replaced by getActions().
     */
    // FIXME not implement
    @Deprecated
    public Object getAvailableActions(final int id) throws XmlRpcException {
        return getRpcClient().execute("ticket.getAvailableActions", new Object[] { id });
    }

    // FIXME not implement
    public Object getActions(final int id) throws XmlRpcException {
        return getRpcClient().execute("ticket.getActions", new Object[] { id });
    }

    public TracTicket get(final TracTicket ticket) throws XmlRpcException {
        getResultReader.read(
                ticket,
                getRpcClient().execute("ticket.get",
                        getParamWriter.write(ticket)));
        return ticket;
    }

    public TracTicket get(final int id) throws XmlRpcException {
        return get(new TracTicket().setId(id));
    }

    public TracTicket create(final TracTicket ticket) throws XmlRpcException {
        createResultReader.read(
                ticket,
                getRpcClient().execute("ticket.create",
                        createParamWriter.write(ticket)));
        return ticket;
    }

    public TracTicket create() throws XmlRpcException {
        return create(new TracTicket());
    }

    public TracTicket update(final TracTicket ticket) throws XmlRpcException {
        updateResultReader.read(
                ticket,
                getRpcClient().execute("ticket.update",
                        updateParamWriter.write(ticket)));
        return ticket;
    }

    public TracTicket delete(final TracTicket ticket) throws XmlRpcException {
        getRpcClient().execute("ticket.delete",
                deleteParamWriter.write(ticket));
        return ticket;
    }

    public TracTicket delete(final int id) throws XmlRpcException {
        return delete(new TracTicket().setId(id));
    }

    public TracTicketChangeLogs changeLog(final TracTicket ticket) throws XmlRpcException {
        final TracTicketChangeLogs changelogs = ticket.getChangelogs();
        changeLogResultReader.read(
                changelogs,
                getRpcClient().execute("ticket.changeLog",
                        changeLogParamWriter.write(changelogs)));
        return changelogs;
    }

    public TracTicketChangeLogs changeLog(final int id) throws XmlRpcException {
        return changeLog(new TracTicket().setId(id));
    }

    public TracTicketAttachments listAttachments(final TracTicket ticket) throws XmlRpcException {
        final TracTicketAttachments attachments = ticket.getAttachments();
        listAttachmentsResultReader.read(
                attachments,
                getRpcClient().execute("ticket.listAttachments",
                        listAttachmentsParamWriter.write(attachments)));
        return attachments;
    }

    public TracTicketAttachments listAttachments(final int ticket) throws XmlRpcException {
        return listAttachments(new TracTicket().setId(ticket));
    }

    public TracTicketAttachment getAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        getAttachmentResultReader.read(
                attachment,
                getRpcClient().execute("ticket.getAttachment",
                        getAttachmentParamWriter.write(attachment)));
        return attachment;
    }

    public TracTicketAttachment getAttachment(final int ticket, final String filename) throws XmlRpcException {
        return getAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketAttachment putAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        putAttachmentResultReader.read(
                attachment,
                getRpcClient().execute("ticket.putAttachment",
                        putAttachmentParamWriter.write(attachment)));
        return attachment;
    }

    public TracTicketAttachment putAttachment(final int ticket, final String filename, final String description, final byte[] data) throws XmlRpcException {
        return putAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename).setData(data));
    }

    public TracTicketAttachment deleteAttachment(final TracTicketAttachment attachment) throws XmlRpcException {
        getRpcClient().execute("ticket.deleteAttachment",
                deleteAttachmentParamWriter.write(attachment));
        return attachment;
    }

    public TracTicketAttachment deleteAttachment(final int ticket, final String filename) throws XmlRpcException {
        return deleteAttachment(new TracTicketAttachment(new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketFields getTicketFields(final TracTicketFields fields) throws XmlRpcException {
        getTicketFieldsResultReader.read(
                fields,
                getRpcClient().execute("ticket.getTicketFields",
                        getTicketFieldsParamWriter.write(fields)));
        return fields;
    }

    public TracTicketFields getTicketFields() throws XmlRpcException {
        return getTicketFields(new TracTicketFields());
    }

    private static class IdOnlyResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicket ticket = (TracTicket) tracObj;
            ticket.setId((Integer) result);
            return ticket;
        }

    }

    private static class QueryParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getQueryStr() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getQueryStr() };
        }

    }

    private static class GetRecentChangesParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTickets tickets = (TracTickets) tracObj;
            return tickets.getSince() == null
                    ? new Object[] {}
                    : new Object[] { tickets.getSince() };
        }

    }

    private static class GetResultReader implements
            TracAPIResultReader {

        @SuppressWarnings("unchecked")
        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final Object[] objAry = (Object[]) result;
            final TracTicket ticket = (TracTicket) tracObj;
            ticket.setId(((Integer) objAry[0]).intValue());
            ticket.setValues((Map<String, Object>) objAry[3]);
            return ticket;
        }

    }

    private static class IdOnlyParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicket) tracObj).getId() };
        }
        
    }

    private static class CreateParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicket ticket = (TracTicket) tracObj;
            final Map<String, Object> attrs = new HashMap<String, Object>(ticket.getValues());
            attrs.remove(Attribute.TIME.getName());
            attrs.remove(Attribute.CHANGETIME.getName());
            return new Object[] { ticket.getSummary(), ticket.getDescription(), attrs };
        }
        
    }

    private static class UpdateParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicket ticket = (TracTicket) tracObj;
            final Map<String, Object> attrs = new HashMap<String, Object>(ticket.getValues());
            attrs.remove(Attribute.TIME.getName());
            attrs.remove(Attribute.CHANGETIME.getName());
            return new Object[] { ticket.getId(), ticket.getUpdateComment(), attrs };
        }
        
    }

    private static class ChangeLogParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketChangeLogs) tracObj).getTicket().getId() };
        }

    }

    private static class ChangeLogResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final Object[] aryObj = (Object[]) result;
            final TracTicketChangeLog changelog = (TracTicketChangeLog) tracObj;
            changelog.setTime((Date) aryObj[0]);
            changelog.setAuthor((String) aryObj[1]);
            changelog.setField((String) aryObj[2]);
            changelog.setOldvalue((String) aryObj[3]);
            changelog.setNewvalue((String) aryObj[4]);
            changelog.setPermanent((Integer) aryObj[5]);
            return changelog;
        }

    }

    private static class ListAttachmentsResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            final Object[] attrs = (Object[]) result;
            attach.setFilename((String) attrs[0]);
            attach.setDescription((String) attrs[1]);
            attach.setSize((Integer) attrs[2]);
            attach.setTime((Date) attrs[3]);
            attach.setAuthor((String) attrs[4]);
            return attach;
        }
    }

    private static class ListAttachmentsParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicketAttachments) tracObj).getTicket().getId() };
        }
        
    }

    private static class GetAttachmentResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            attach.setData((byte[]) result);
            return attach;
        }
    }

    private static class GetAttachmentParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

    private static class PutAttachmentResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            attach.setFilename((String) result);
            return attach;
        }
    }

    private static class PutAttachmentParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename(), attach.getDescription(), attach.getData() };
        }

    }

    private static class DeleteAttachmentParamWriter implements
            TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicketAttachment attach = (TracTicketAttachment) tracObj;
            return new Object[] { attach.getId(), attach.getFilename() };
        }

    }

}
