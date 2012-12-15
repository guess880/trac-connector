package org.guess880.trac_connector.object.ticket;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracTicketAction implements TracObject {

    private String action;

    private String label;

    private String hints;

    private TracTicketActionFields inputFields;

    public String getAction() {
        return action;
    }

    public TracTicketAction setAction(final String action) {
        this.action = action;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public TracTicketAction setLabel(final String label) {
        this.label = label;
        return this;
    }

    public String getHints() {
        return hints;
    }

    public TracTicketAction setHints(final String hints) {
        this.hints = hints;
        return this;
    }

    public TracTicketActionFields getInputFields() {
        if (inputFields == null) {
            inputFields = new TracTicketActionFields();
        }
        return inputFields;
    }

    public TracTicketAction setInputFields(
            final TracTicketActionFields inputFields) {
        this.inputFields = inputFields;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
