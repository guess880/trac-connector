package org.guess880.trac_connector.object.ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.guess880.trac_connector.attr.TracTicketAttributes;
import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracStruct;


public class TracTicket extends TracStruct {

    private int id;

    private String updateComment;

    private TracTicketAttachments attachments;

    public TracTicket() {
        attachments = new TracTicketAttachments(this);
        setAPIObjectReader(new DefaultAPIObjectReader());
        setAPIObjectWriterForGet(new DefaultAPIObjectWriterIdOnly());
        setAPIObjectWriterForCreate(new DefaultAPIObjectWriterForCreate());
        setAPIObjectWriterForDelete(new DefaultAPIObjectWriterIdOnly());
        setAPIObjectWriterForUpdate(new DefaultAPIObjectWriterForUpdate());
    }

    public int getId() {
        return id;
    }

    public TracTicket setId(final int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return (String) getValue(TracTicketAttributes.TYPE);
    }

    public TracTicket setType(final String type) {
        return (TracTicket) setValue(TracTicketAttributes.TYPE, type);
    }

    public String getComponent() {
        return (String) getValue(TracTicketAttributes.COMPONENT);
    }

    public TracTicket setComponent(final String component) {
        return (TracTicket) setValue(TracTicketAttributes.COMPONENT, component);
    }

    public String getSeverity() {
        return (String) getValue(TracTicketAttributes.SEVERITY);
    }

    public TracTicket setSeverity(final String severity) {
        return (TracTicket) setValue(TracTicketAttributes.SEVERITY, severity);
    }

    public String getPriority() {
        return (String) getValue(TracTicketAttributes.PRIORITY);
    }

    public TracTicket setPriority(final String priority) {
        return (TracTicket) setValue(TracTicketAttributes.PRIORITY, priority);
    }

    public String getOwner() {
        return (String) getValue(TracTicketAttributes.OWNER);
    }

    public TracTicket setOwner(final String owner) {
        return (TracTicket) setValue(TracTicketAttributes.OWNER, owner);
    }

    public String getReporter() {
        return (String) getValue(TracTicketAttributes.REPORTER);
    }

    public TracTicket setReporter(final String reporter) {
        return (TracTicket) setValue(TracTicketAttributes.REPORTER, reporter);
    }

    public String getCc() {
        return null;
    }

    public String getCcCommaText() {
        return (String) getValue(TracTicketAttributes.CC);
    }

    public TracTicket setCc(final String cc) {
        return (TracTicket) setValue(TracTicketAttributes.CC, cc);
    }

    public TracTicket addCc(final String oneOfCc) {
        return null;
    }

    public String getVersion() {
        return (String) getValue(TracTicketAttributes.VERSION);
    }

    public TracTicket setVersion(final String version) {
        return (TracTicket) setValue(TracTicketAttributes.VERSION, version);
    }

    public String getMilestone() {
        return (String) getValue(TracTicketAttributes.MILESTONE);
    }

    public TracTicket setMilestone(final String milestone) {
        return (TracTicket) setValue(TracTicketAttributes.MILESTONE, milestone);
    }

    public String getStatus() {
        return (String) getValue(TracTicketAttributes.STATUS);
    }

    public TracTicket setStatus(final String status) {
        return (TracTicket) setValue(TracTicketAttributes.STATUS, status);
    }

    public String getResolution() {
        return (String) getValue(TracTicketAttributes.RESOLUTION);
    }

    public TracTicket setResolution(final String resolution) {
        return (TracTicket) setValue(TracTicketAttributes.RESOLUTION, resolution);
    }

    public String getSummary() {
        return (String) getValue(TracTicketAttributes.SUMMARY);
    }

    public TracTicket setSummary(final String summary) {
        return (TracTicket) setValue(TracTicketAttributes.SUMMARY, summary);
    }

    public String getDescription() {
        return (String) getValue(TracTicketAttributes.DESCRIPTION);
    }

    public TracTicket setDescription(final String description) {
        return (TracTicket) setValue(TracTicketAttributes.DESCRIPTION, description);
    }

    public String getKeywords() {
        return (String) getValue(TracTicketAttributes.KEYWORDS);
    }

    public TracTicket setKeywords(final String keywords) {
        return (TracTicket) setValue(TracTicketAttributes.KEYWORDS, keywords);
    }

    public Date getTime() {
        return (Date) getValue(TracTicketAttributes.TIME);
    }

    public TracTicket setTime(final Date time) {
        return (TracTicket) setValue(TracTicketAttributes.TIME, time);
    }

    public Date getChangetime() {
        return (Date) getValue(TracTicketAttributes.CHANGETIME);
    }

    public TracTicket setChangetime(final Date changetime) {
        return (TracTicket) setValue(TracTicketAttributes.CHANGETIME, changetime);
    }

    public String getUpdateComment() {
        return updateComment;
    }

    public TracTicket setUpdateComment(final String updateComment) {
        this.updateComment = updateComment;
        return this;
    }

    public TracTicketAttachments getAttachments() {
        return attachments;
    }

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @SuppressWarnings("unchecked")
        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final Object[] objAry = (Object[]) apiObj;
            final TracTicket ticket = (TracTicket) tracObj;
            ticket.setId(((Integer) objAry[0]).intValue());
            ticket.setValues((Map<String, Object>) objAry[3]);
            return ticket;
        }

    }

    private static class DefaultAPIObjectWriterIdOnly implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracTicket) tracObj).getId() };
        }
        
    }

    private static class DefaultAPIObjectWriterForCreate implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicket ticket = (TracTicket) tracObj;
            final Map<String, Object> attrs = new HashMap<String, Object>(ticket.getValues());
            attrs.remove(TracTicketAttributes.TIME.getName());
            attrs.remove(TracTicketAttributes.CHANGETIME.getName());
            return new Object[] { ticket.getSummary(), ticket.getDescription(), attrs };
        }
        
    }

    private static class DefaultAPIObjectWriterForUpdate implements
            TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            final TracTicket ticket = (TracTicket) tracObj;
            final Map<String, Object> attrs = new HashMap<String, Object>(ticket.getValues());
            attrs.remove(TracTicketAttributes.TIME.getName());
            attrs.remove(TracTicketAttributes.CHANGETIME.getName());
            return new Object[] { ticket.getId(), ticket.getUpdateComment(), attrs };
        }
        
    }

}
