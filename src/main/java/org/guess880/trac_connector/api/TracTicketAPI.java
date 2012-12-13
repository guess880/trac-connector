package org.guess880.trac_connector.api;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.guess880.trac_connector.TracConnectConfig;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracEmptyParamWriter;
import org.guess880.trac_connector.object.converter.TracMultiResultReader;
import org.guess880.trac_connector.object.converter.TracStructGetResultReader;
import org.guess880.trac_connector.object.ticket.TracTicket;
import org.guess880.trac_connector.object.ticket.TracTicket.Attribute;
import org.guess880.trac_connector.object.ticket.TracTicketAttachment;
import org.guess880.trac_connector.object.ticket.TracTicketAttachments;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLog;
import org.guess880.trac_connector.object.ticket.TracTicketChangeLogs;
import org.guess880.trac_connector.object.ticket.TracTicketField;
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

    private TracMultiResultReader<TracTicket, TracTickets> queryResultReader;

    private TracAPIParamWriter<TracTickets> queryParamWriter;

    private TracMultiResultReader<TracTicket, TracTickets> getRecentChangesResultReader;

    private TracAPIParamWriter<TracTickets> getRecentChangesParamWriter;

    private TracAPIResultReader<TracTicket> getResultReader;

    private TracAPIParamWriter<TracTicket> getParamWriter;

    private TracAPIResultReader<TracTicket> createResultReader;

    private TracAPIParamWriter<TracTicket> createParamWriter;

    private TracAPIParamWriter<TracTicket> deleteParamWriter;

    private TracAPIResultReader<TracTicket> updateResultReader;

    private TracAPIParamWriter<TracTicket> updateParamWriter;

    private TracMultiResultReader<TracTicketChangeLog, TracTicketChangeLogs> changeLogResultReader;

    private TracAPIParamWriter<TracTicketChangeLogs> changeLogParamWriter;

    private TracMultiResultReader<TracTicketAttachment, TracTicketAttachments> listAttachmentsResultReader;

    private TracAPIParamWriter<TracTicketAttachments> listAttachmentsParamWriter;

    private TracAPIResultReader<TracTicketAttachment> getAttachmentResultReader;

    private TracAPIParamWriter<TracTicketAttachment> getAttachmentParamWriter;

    private TracAPIResultReader<TracTicketAttachment> putAttachmentResultReader;

    private TracAPIParamWriter<TracTicketAttachment> putAttachmentParamWriter;

    private TracAPIParamWriter<TracTicketAttachment> deleteAttachmentParamWriter;

    private TracMultiResultReader<TracTicketField, TracTicketFields> getTicketFieldsResultReader;

    private TracAPIParamWriter<TracTicketFields> getTicketFieldsParamWriter;

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
        queryResultReader = new TracMultiResultReader<TracTicket, TracTickets>()
                .setOneResultReader(new IdOnlyResultReader());
        queryParamWriter = new QueryParamWriter();
        getRecentChangesResultReader = new TracMultiResultReader<TracTicket, TracTickets>()
                .setOneResultReader(new IdOnlyResultReader());
        getRecentChangesParamWriter = new GetRecentChangesParamWriter();
        getResultReader = new GetResultReader();
        getParamWriter = new IdOnlyParamWriter();
        createResultReader = new IdOnlyResultReader();
        createParamWriter = new CreateParamWriter();
        deleteParamWriter = new IdOnlyParamWriter();
        updateResultReader = new GetResultReader();
        updateParamWriter = new UpdateParamWriter();
        changeLogResultReader = new TracMultiResultReader<TracTicketChangeLog, TracTicketChangeLogs>()
                .setOneResultReader(new ChangeLogResultReader());
        changeLogParamWriter = new ChangeLogParamWriter();
        listAttachmentsResultReader = new TracMultiResultReader<TracTicketAttachment, TracTicketAttachments>()
                .setOneResultReader(new ListAttachmentsResultReader());
        listAttachmentsParamWriter = new ListAttachmentsParamWriter();
        getAttachmentResultReader = new GetAttachmentResultReader();
        getAttachmentParamWriter = new GetAttachmentParamWriter();
        putAttachmentResultReader = new PutAttachmentResultReader();
        putAttachmentParamWriter = new PutAttachmentParamWriter();
        deleteAttachmentParamWriter = new DeleteAttachmentParamWriter();
        getTicketFieldsResultReader = new TracMultiResultReader<TracTicketField, TracTicketFields>()
                .setOneResultReader(new TracStructGetResultReader<TracTicketField>());
        getTicketFieldsParamWriter = new TracEmptyParamWriter<TracTicketFields>();
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

    protected TracMultiResultReader<TracTicket, TracTickets> getQueryResultReader() {
        return queryResultReader;
    }

    public TracTicketAPI setQueryResultReader(
            final TracMultiResultReader<TracTicket, TracTickets> queryResultReader) {
        this.queryResultReader = queryResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTickets> getQueryParamWriter() {
        return queryParamWriter;
    }

    public TracTicketAPI setQueryParamWriter(
            final TracAPIParamWriter<TracTickets> queryParamWriter) {
        this.queryParamWriter = queryParamWriter;
        return this;
    }

    protected TracMultiResultReader<TracTicket, TracTickets> getGetRecentChangesResultReader() {
        return getRecentChangesResultReader;
    }

    public TracTicketAPI setGetRecentChangesResultReader(
            final TracMultiResultReader<TracTicket, TracTickets> getRecentChangesResultReader) {
        this.getRecentChangesResultReader = getRecentChangesResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTickets> getGetRecentChangesParamWriter() {
        return getRecentChangesParamWriter;
    }

    public TracTicketAPI setGetRecentChangesParamWriter(
            final TracAPIParamWriter<TracTickets> getRecentChangesParamWriter) {
        this.getRecentChangesParamWriter = getRecentChangesParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicket> getGetResultReader() {
        return getResultReader;
    }

    public TracTicketAPI setGetResultReader(
            final TracAPIResultReader<TracTicket> getResultReader) {
        this.getResultReader = getResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicket> getGetParamWriter() {
        return getParamWriter;
    }

    public TracTicketAPI setGetParamWriter(
            final TracAPIParamWriter<TracTicket> getParamWriter) {
        this.getParamWriter = getParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicket> getCreateResultReader() {
        return createResultReader;
    }

    public TracTicketAPI setCreateResultReader(
            final TracAPIResultReader<TracTicket> createResultReader) {
        this.createResultReader = createResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicket> getCreateParamWriter() {
        return createParamWriter;
    }

    public TracTicketAPI setCreateParamWriter(
            final TracAPIParamWriter<TracTicket> createParamWriter) {
        this.createParamWriter = createParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracTicket> getDeleteParamWriter() {
        return deleteParamWriter;
    }

    public TracTicketAPI setDeleteParamWriter(
            final TracAPIParamWriter<TracTicket> deleteParamWriter) {
        this.deleteParamWriter = deleteParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicket> getUpdateResultReader() {
        return updateResultReader;
    }

    public TracTicketAPI setUpdateResultReader(
            final TracAPIResultReader<TracTicket> updateResultReader) {
        this.updateResultReader = updateResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicket> getUpdateParamWriter() {
        return updateParamWriter;
    }

    public TracTicketAPI setUpdateParamWriter(
            final TracAPIParamWriter<TracTicket> updateParamWriter) {
        this.updateParamWriter = updateParamWriter;
        return this;
    }

    protected TracMultiResultReader<TracTicketChangeLog, TracTicketChangeLogs> getChangeLogResultReader() {
        return changeLogResultReader;
    }

    public TracTicketAPI setChangeLogResultReader(
            final TracMultiResultReader<TracTicketChangeLog, TracTicketChangeLogs> changeLogResultReader) {
        this.changeLogResultReader = changeLogResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketChangeLogs> getChangeLogParamWriter() {
        return changeLogParamWriter;
    }

    public TracTicketAPI setChangeLogParamWriter(
            final TracAPIParamWriter<TracTicketChangeLogs> changeLogParamWriter) {
        this.changeLogParamWriter = changeLogParamWriter;
        return this;
    }

    protected TracMultiResultReader<TracTicketAttachment, TracTicketAttachments> getListAttachmentsResultReader() {
        return listAttachmentsResultReader;
    }

    public TracTicketAPI setListAttachmentsResultReader(
            final TracMultiResultReader<TracTicketAttachment, TracTicketAttachments> listAttachmentsResultReader) {
        this.listAttachmentsResultReader = listAttachmentsResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketAttachments> getListAttachmentsParamWriter() {
        return listAttachmentsParamWriter;
    }

    public TracTicketAPI setListAttachmentsParamWriter(
            final TracAPIParamWriter<TracTicketAttachments> listAttachmentsParamWriter) {
        this.listAttachmentsParamWriter = listAttachmentsParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicketAttachment> getGetAttachmentResultReader() {
        return getAttachmentResultReader;
    }

    public TracTicketAPI setGetAttachmentResultReader(
            final TracAPIResultReader<TracTicketAttachment> getAttachmentResultReader) {
        this.getAttachmentResultReader = getAttachmentResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketAttachment> getGetAttachmentParamWriter() {
        return getAttachmentParamWriter;
    }

    public TracTicketAPI setGetAttachmentParamWriter(
            final TracAPIParamWriter<TracTicketAttachment> getAttachmentParamWriter) {
        this.getAttachmentParamWriter = getAttachmentParamWriter;
        return this;
    }

    protected TracAPIResultReader<TracTicketAttachment> getPutAttachmentResultReader() {
        return putAttachmentResultReader;
    }

    public TracTicketAPI setPutAttachmentResultReader(
            final TracAPIResultReader<TracTicketAttachment> putAttachmentResultReader) {
        this.putAttachmentResultReader = putAttachmentResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketAttachment> getPutAttachmentParamWriter() {
        return putAttachmentParamWriter;
    }

    public TracTicketAPI setPutAttachmentParamWriter(
            final TracAPIParamWriter<TracTicketAttachment> putAttachmentParamWriter) {
        this.putAttachmentParamWriter = putAttachmentParamWriter;
        return this;
    }

    protected TracAPIParamWriter<TracTicketAttachment> getDeleteAttachmentParamWriter() {
        return deleteAttachmentParamWriter;
    }

    public TracTicketAPI setDeleteAttachmentParamWriter(
            final TracAPIParamWriter<TracTicketAttachment> deleteAttachmentParamWriter) {
        this.deleteAttachmentParamWriter = deleteAttachmentParamWriter;
        return this;
    }

    protected TracMultiResultReader<TracTicketField, TracTicketFields> getGetTicketFieldsResultReader() {
        return getTicketFieldsResultReader;
    }

    public TracTicketAPI setGetTicketFieldsResultReader(
            final TracMultiResultReader<TracTicketField, TracTicketFields> getTicketFieldsResultReader) {
        this.getTicketFieldsResultReader = getTicketFieldsResultReader;
        return this;
    }

    protected TracAPIParamWriter<TracTicketFields> getGetTicketFieldsParamWriter() {
        return getTicketFieldsParamWriter;
    }

    public TracTicketAPI setGetTicketFieldsParamWriter(
            final TracAPIParamWriter<TracTicketFields> getTicketFieldsParamWriter) {
        this.getTicketFieldsParamWriter = getTicketFieldsParamWriter;
        return this;
    }

    public TracTickets query(final TracTickets tickets) throws XmlRpcException {
        return queryResultReader.read(
                tickets,
                getRpcClient().execute("ticket.query",
                        queryParamWriter.write(tickets)));
    }

    public TracTickets query(final String qstr) throws XmlRpcException {
        return query(new TracTickets().setQueryStr(qstr));
    }

    public TracTickets getRecentChanges(final TracTickets tickets)
            throws XmlRpcException {
        return getRecentChangesResultReader.read(
                tickets,
                getRpcClient().execute("ticket.getRecentChanges",
                        getRecentChangesParamWriter.write(tickets)));
    }

    public TracTickets getRecentChanges(final Date since)
            throws XmlRpcException {
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
        return getRpcClient().execute("ticket.getAvailableActions",
                new Object[] { id });
    }

    // FIXME not implement
    public Object getActions(final int id) throws XmlRpcException {
        return getRpcClient().execute("ticket.getActions", new Object[] { id });
    }

    public TracTicket get(final TracTicket ticket) throws XmlRpcException {
        return getResultReader.read(
                ticket,
                getRpcClient().execute("ticket.get",
                        getParamWriter.write(ticket)));
    }

    public TracTicket get(final int id) throws XmlRpcException {
        return get(new TracTicket().setId(id));
    }

    public TracTicket create(final TracTicket ticket) throws XmlRpcException {
        return createResultReader.read(
                ticket,
                getRpcClient().execute("ticket.create",
                        createParamWriter.write(ticket)));
    }

    public TracTicket create() throws XmlRpcException {
        return create(new TracTicket());
    }

    public TracTicket update(final TracTicket ticket) throws XmlRpcException {
        return updateResultReader.read(
                ticket,
                getRpcClient().execute("ticket.update",
                        updateParamWriter.write(ticket)));
    }

    public TracTicket delete(final TracTicket ticket) throws XmlRpcException {
        getRpcClient()
                .execute("ticket.delete", deleteParamWriter.write(ticket));
        return ticket;
    }

    public TracTicket delete(final int id) throws XmlRpcException {
        return delete(new TracTicket().setId(id));
    }

    public TracTicketChangeLogs changeLog(final TracTicket ticket)
            throws XmlRpcException {
        final TracTicketChangeLogs changelogs = ticket.getChangelogs();
        return changeLogResultReader.read(
                changelogs,
                getRpcClient().execute("ticket.changeLog",
                        changeLogParamWriter.write(changelogs)));
    }

    public TracTicketChangeLogs changeLog(final int id) throws XmlRpcException {
        return changeLog(new TracTicket().setId(id));
    }

    public TracTicketAttachments listAttachments(final TracTicket ticket)
            throws XmlRpcException {
        final TracTicketAttachments attachments = ticket.getAttachments();
        return listAttachmentsResultReader.read(
                attachments,
                getRpcClient().execute("ticket.listAttachments",
                        listAttachmentsParamWriter.write(attachments)));
    }

    public TracTicketAttachments listAttachments(final int ticket)
            throws XmlRpcException {
        return listAttachments(new TracTicket().setId(ticket));
    }

    public TracTicketAttachment getAttachment(
            final TracTicketAttachment attachment) throws XmlRpcException {
        return getAttachmentResultReader.read(
                attachment,
                getRpcClient().execute("ticket.getAttachment",
                        getAttachmentParamWriter.write(attachment)));
    }

    public TracTicketAttachment getAttachment(final int ticket,
            final String filename) throws XmlRpcException {
        return getAttachment(new TracTicketAttachment(
                new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketAttachment putAttachment(
            final TracTicketAttachment attachment) throws XmlRpcException {
        return putAttachmentResultReader.read(
                attachment,
                getRpcClient().execute("ticket.putAttachment",
                        putAttachmentParamWriter.write(attachment)));
    }

    public TracTicketAttachment putAttachment(final int ticket,
            final String filename, final String description, final byte[] data)
            throws XmlRpcException {
        return putAttachment(new TracTicketAttachment(
                new TracTicket().setId(ticket)).setFilename(filename).setData(
                data));
    }

    public TracTicketAttachment deleteAttachment(
            final TracTicketAttachment attachment) throws XmlRpcException {
        getRpcClient().execute("ticket.deleteAttachment",
                deleteAttachmentParamWriter.write(attachment));
        return attachment;
    }

    public TracTicketAttachment deleteAttachment(final int ticket,
            final String filename) throws XmlRpcException {
        return deleteAttachment(new TracTicketAttachment(
                new TracTicket().setId(ticket)).setFilename(filename));
    }

    public TracTicketFields getTicketFields(final TracTicketFields fields)
            throws XmlRpcException {
        return getTicketFieldsResultReader.read(
                fields,
                getRpcClient().execute("ticket.getTicketFields",
                        getTicketFieldsParamWriter.write(fields)));
    }

    public TracTicketFields getTicketFields() throws XmlRpcException {
        return getTicketFields(new TracTicketFields());
    }

    private static class IdOnlyResultReader implements
            TracAPIResultReader<TracTicket> {

        @Override
        public TracTicket read(final TracTicket tracObj, final Object result) {
            return tracObj.setId((Integer) result);
        }

    }

    private static class QueryParamWriter implements
            TracAPIParamWriter<TracTickets> {

        @Override
        public Object[] write(final TracTickets tracObj) {
            return tracObj.getQueryStr() == null ? new Object[] {}
                    : new Object[] { tracObj.getQueryStr() };
        }

    }

    private static class GetRecentChangesParamWriter implements
            TracAPIParamWriter<TracTickets> {

        @Override
        public Object[] write(final TracTickets tracObj) {
            return tracObj.getSince() == null ? new Object[] {}
                    : new Object[] { tracObj.getSince() };
        }

    }

    private static class GetResultReader implements
            TracAPIResultReader<TracTicket> {

        @SuppressWarnings("unchecked")
        @Override
        public TracTicket read(final TracTicket tracObj, final Object result) {
            final Object[] objAry = (Object[]) result;
            tracObj.setId(((Integer) objAry[0]).intValue());
            tracObj.setValues((Map<String, Object>) objAry[3]);
            return tracObj;
        }

    }

    private static class IdOnlyParamWriter implements
            TracAPIParamWriter<TracTicket> {

        @Override
        public Object[] write(final TracTicket tracObj) {
            return new Object[] { tracObj.getId() };
        }

    }

    private static class CreateParamWriter implements
            TracAPIParamWriter<TracTicket> {

        @Override
        public Object[] write(final TracTicket tracObj) {
            final Map<String, Object> attrs = new HashMap<String, Object>(
                    tracObj.getValues());
            attrs.remove(Attribute.TIME.getName());
            attrs.remove(Attribute.CHANGETIME.getName());
            return new Object[] { tracObj.getSummary(),
                    tracObj.getDescription(), attrs };
        }

    }

    private static class UpdateParamWriter implements
            TracAPIParamWriter<TracTicket> {

        @Override
        public Object[] write(final TracTicket tracObj) {
            final Map<String, Object> attrs = new HashMap<String, Object>(
                    tracObj.getValues());
            attrs.remove(Attribute.TIME.getName());
            attrs.remove(Attribute.CHANGETIME.getName());
            return new Object[] { tracObj.getId(), tracObj.getUpdateComment(),
                    attrs };
        }

    }

    private static class ChangeLogParamWriter implements
            TracAPIParamWriter<TracTicketChangeLogs> {

        @Override
        public Object[] write(final TracTicketChangeLogs tracObj) {
            return new Object[] { tracObj.getTicket().getId() };
        }

    }

    private static class ChangeLogResultReader implements
            TracAPIResultReader<TracTicketChangeLog> {

        @Override
        public TracTicketChangeLog read(final TracTicketChangeLog tracObj,
                final Object result) {
            final Object[] aryObj = (Object[]) result;
            return tracObj.setTime((Date) aryObj[0])
                    .setAuthor((String) aryObj[1]).setField((String) aryObj[2])
                    .setOldvalue((String) aryObj[3])
                    .setNewvalue((String) aryObj[4])
                    .setPermanent((Integer) aryObj[5]);
        }

    }

    private static class ListAttachmentsResultReader implements
            TracAPIResultReader<TracTicketAttachment> {

        @Override
        public TracTicketAttachment read(final TracTicketAttachment tracObj,
                final Object result) {
            final Object[] attrs = (Object[]) result;
            return tracObj.setFilename((String) attrs[0])
                    .setDescription((String) attrs[1])
                    .setSize((Integer) attrs[2]).setTime((Date) attrs[3])
                    .setAuthor((String) attrs[4]);
        }
    }

    private static class ListAttachmentsParamWriter implements
            TracAPIParamWriter<TracTicketAttachments> {

        @Override
        public Object[] write(final TracTicketAttachments tracObj) {
            return new Object[] { tracObj.getTicket().getId() };
        }

    }

    private static class GetAttachmentResultReader implements
            TracAPIResultReader<TracTicketAttachment> {

        @Override
        public TracTicketAttachment read(final TracTicketAttachment tracObj,
                final Object result) {
            return tracObj.setData((byte[]) result);
        }
    }

    private static class GetAttachmentParamWriter implements
            TracAPIParamWriter<TracTicketAttachment> {

        @Override
        public Object[] write(final TracTicketAttachment tracObj) {
            return new Object[] { tracObj.getId(), tracObj.getFilename() };
        }

    }

    private static class PutAttachmentResultReader implements
            TracAPIResultReader<TracTicketAttachment> {

        @Override
        public TracTicketAttachment read(final TracTicketAttachment tracObj,
                final Object result) {
            return tracObj.setFilename((String) result);
        }
    }

    private static class PutAttachmentParamWriter implements
            TracAPIParamWriter<TracTicketAttachment> {

        @Override
        public Object[] write(final TracTicketAttachment tracObj) {
            return new Object[] { tracObj.getId(), tracObj.getFilename(),
                    tracObj.getDescription(), tracObj.getData() };
        }

    }

    private static class DeleteAttachmentParamWriter implements
            TracAPIParamWriter<TracTicketAttachment> {

        @Override
        public Object[] write(final TracTicketAttachment tracObj) {
            return new Object[] { tracObj.getId(), tracObj.getFilename() };
        }

    }

}
