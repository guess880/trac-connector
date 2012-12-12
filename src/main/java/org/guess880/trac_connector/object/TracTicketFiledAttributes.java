package org.guess880.trac_connector.object;

// FIXME move to TracTicketField
public class TracTicketFiledAttributes extends AbsTracAttributes {

    public static final TracTicketFiledAttributes NAME = new TracTicketFiledAttributes("name");

    public static final TracTicketFiledAttributes LABEL = new TracTicketFiledAttributes("label");

    public static final TracTicketFiledAttributes TYPE = new TracTicketFiledAttributes("type");

    public static final TracTicketFiledAttributes VALUE = new TracTicketFiledAttributes("value");

    public static final TracTicketFiledAttributes OPTIONS = new TracTicketFiledAttributes("options");

    public static final TracTicketFiledAttributes OPTIONAL = new TracTicketFiledAttributes("optional");

    public static final TracTicketFiledAttributes ORDER = new TracTicketFiledAttributes("order");

    public static final TracTicketFiledAttributes FORMAT = new TracTicketFiledAttributes("format");

    public static final TracTicketFiledAttributes CUSTOM = new TracTicketFiledAttributes("custom");

    protected TracTicketFiledAttributes(final String name) {
        super(name);
    }

}
