package org.guess880.trac_connector.object.ticket;

import java.util.Date;

import org.guess880.trac_connector.object.TracAttributeBase;
import org.guess880.trac_connector.object.TracStructBase;

public class TracTicket extends TracStructBase {

    private int id;

    private String updateComment;

    private TracTicketAttachments attachments;

    private TracTicketChangeLogs changelogs;

    private TracTicketActions actions;

    public TracTicket() {
        super();
    }

    public int getId() {
        return id;
    }

    public TracTicket setId(final int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return (String) getValue(Attribute.TYPE);
    }

    public TracTicket setType(final String type) {
        return (TracTicket) setValue(Attribute.TYPE, type);
    }

    public String getComponent() {
        return (String) getValue(Attribute.COMPONENT);
    }

    public TracTicket setComponent(final String component) {
        return (TracTicket) setValue(Attribute.COMPONENT, component);
    }

    public String getSeverity() {
        return (String) getValue(Attribute.SEVERITY);
    }

    public TracTicket setSeverity(final String severity) {
        return (TracTicket) setValue(Attribute.SEVERITY, severity);
    }

    public String getPriority() {
        return (String) getValue(Attribute.PRIORITY);
    }

    public TracTicket setPriority(final String priority) {
        return (TracTicket) setValue(Attribute.PRIORITY, priority);
    }

    public String getOwner() {
        return (String) getValue(Attribute.OWNER);
    }

    public TracTicket setOwner(final String owner) {
        return (TracTicket) setValue(Attribute.OWNER, owner);
    }

    public String getReporter() {
        return (String) getValue(Attribute.REPORTER);
    }

    public TracTicket setReporter(final String reporter) {
        return (TracTicket) setValue(Attribute.REPORTER, reporter);
    }

    public String getCc() {
        return (String) getValue(Attribute.CC);
    }

    public TracTicket setCc(final String cc) {
        return (TracTicket) setValue(Attribute.CC, cc);
    }

    public String getVersion() {
        return (String) getValue(Attribute.VERSION);
    }

    public TracTicket setVersion(final String version) {
        return (TracTicket) setValue(Attribute.VERSION, version);
    }

    public String getMilestone() {
        return (String) getValue(Attribute.MILESTONE);
    }

    public TracTicket setMilestone(final String milestone) {
        return (TracTicket) setValue(Attribute.MILESTONE, milestone);
    }

    public String getStatus() {
        return (String) getValue(Attribute.STATUS);
    }

    public TracTicket setStatus(final String status) {
        return (TracTicket) setValue(Attribute.STATUS, status);
    }

    public String getResolution() {
        return (String) getValue(Attribute.RESOLUTION);
    }

    public TracTicket setResolution(final String resolution) {
        return (TracTicket) setValue(Attribute.RESOLUTION, resolution);
    }

    public String getSummary() {
        return (String) getValue(Attribute.SUMMARY);
    }

    public TracTicket setSummary(final String summary) {
        return (TracTicket) setValue(Attribute.SUMMARY, summary);
    }

    public String getDescription() {
        return (String) getValue(Attribute.DESCRIPTION);
    }

    public TracTicket setDescription(final String description) {
        return (TracTicket) setValue(Attribute.DESCRIPTION, description);
    }

    public String getKeywords() {
        return (String) getValue(Attribute.KEYWORDS);
    }

    public TracTicket setKeywords(final String keywords) {
        return (TracTicket) setValue(Attribute.KEYWORDS, keywords);
    }

    public Date getTime() {
        return (Date) getValue(Attribute.TIME);
    }

    public TracTicket setTime(final Date time) {
        return (TracTicket) setValue(Attribute.TIME, time);
    }

    public Date getChangetime() {
        return (Date) getValue(Attribute.CHANGETIME);
    }

    public TracTicket setChangetime(final Date changetime) {
        return (TracTicket) setValue(Attribute.CHANGETIME, changetime);
    }

    public String getUpdateComment() {
        return updateComment;
    }

    public TracTicket setUpdateComment(final String updateComment) {
        this.updateComment = updateComment;
        return this;
    }

    public TracTicketAttachments getAttachments() {
        if (attachments == null) {
            attachments = new TracTicketAttachments(this);
        }
        return attachments;
    }

    public TracTicket setAttachments(final TracTicketAttachments attachments) {
        this.attachments = attachments;
        return this;
    }

    public TracTicketChangeLogs getChangelogs() {
        if (changelogs == null) {
            changelogs = new TracTicketChangeLogs(this);
        }
        return changelogs;
    }

    public TracTicket setAttachments(final TracTicketChangeLogs changelogs) {
        this.changelogs = changelogs;
        return this;
    }

    public TracTicketActions getActions() {
        if (actions == null) {
            actions = new TracTicketActions(this);
        }
        return actions;
    }

    public TracTicket setActions(final TracTicketActions actions) {
        this.actions = actions;
        return this;
    }

    public static class Attribute extends TracAttributeBase {

        public static final Attribute TYPE = new Attribute("type");

        public static final Attribute COMPONENT = new Attribute("component");

        public static final Attribute SEVERITY = new Attribute("severity");

        public static final Attribute PRIORITY = new Attribute("priority");

        public static final Attribute OWNER = new Attribute("owner");

        public static final Attribute REPORTER = new Attribute("reporter");

        public static final Attribute CC = new Attribute("cc");

        public static final Attribute VERSION = new Attribute("version");

        public static final Attribute MILESTONE = new Attribute("milestone");

        public static final Attribute STATUS = new Attribute("status");

        public static final Attribute RESOLUTION = new Attribute("resolution");

        public static final Attribute SUMMARY = new Attribute("summary");

        public static final Attribute DESCRIPTION = new Attribute("description");

        public static final Attribute KEYWORDS = new Attribute("keywords");

        public static final Attribute TIME = new Attribute("time");

        public static final Attribute CHANGETIME = new Attribute("changetime");

        protected Attribute(final String name) {
            super(name);
        }

    }

}
