package org.guess880.trac_connector.attr;

public class TracTicketAttributes extends AbsTracAttributes {

    public static final TracTicketAttributes TYPE = new TracTicketAttributes("type");

    public static final TracTicketAttributes COMPONENT = new TracTicketAttributes("component");

    public static final TracTicketAttributes SEVERITY = new TracTicketAttributes("severity");

    public static final TracTicketAttributes PRIORITY = new TracTicketAttributes("priority");

    public static final TracTicketAttributes OWNER = new TracTicketAttributes("owner");

    public static final TracTicketAttributes REPORTER = new TracTicketAttributes("reporter");

    public static final TracTicketAttributes CC = new TracTicketAttributes("cc");

    public static final TracTicketAttributes VERSION = new TracTicketAttributes("version");

    public static final TracTicketAttributes MILESTONE = new TracTicketAttributes("milestone");

    public static final TracTicketAttributes STATUS = new TracTicketAttributes("status");

    public static final TracTicketAttributes RESOLUTION = new TracTicketAttributes("resolution");

    public static final TracTicketAttributes SUMMARY = new TracTicketAttributes("summary");

    public static final TracTicketAttributes DESCRIPTION = new TracTicketAttributes("description");

    public static final TracTicketAttributes KEYWORDS = new TracTicketAttributes("keywords");

    public static final TracTicketAttributes TIME = new TracTicketAttributes("time");

    public static final TracTicketAttributes CHANGETIME = new TracTicketAttributes("changetime");

    protected TracTicketAttributes(final String name) {
        super(name);
    }

}
