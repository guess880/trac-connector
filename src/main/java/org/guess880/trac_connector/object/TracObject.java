package org.guess880.trac_connector.object;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracObject implements ITracObject {

    private TracAPIObjectReader getMultiResultReader;

    private TracAPIObjectReader getResultReader;

    private TracAPIObjectWriter getParamWriter;

    private TracAPIObjectWriter createParamWriter;

    private TracAPIObjectWriter deleteParamWriter;

    private TracAPIObjectWriter updateParamWriter;

    public TracObject setGetMultiResultReader(final TracAPIObjectReader reader) {
        this.getMultiResultReader = reader;
        return this;
    }

    public TracObject setGetResultReader(final TracAPIObjectReader reader) {
        this.getResultReader = reader;
        return this;
    }

    public TracObject setGetParamWriter(final TracAPIObjectWriter writer) {
        this.getParamWriter = writer;
        return this;
    }

    public TracObject setCreateParamWriter(final TracAPIObjectWriter writer) {
        this.createParamWriter = writer;
        return this;
    }

    public TracObject setDeleteParamWriter(final TracAPIObjectWriter writer) {
        this.deleteParamWriter = writer;
        return this;
    }

    public TracObject setUpdateParamWriter(final TracAPIObjectWriter writer) {
        this.updateParamWriter = writer;
        return this;
    }

    public TracObject readGetMultiResult(final Object apiObj) {
        getMultiResultReader.read(this, apiObj);
        return this;
    }

    public TracObject readGetResult(final Object apiObj) {
        getResultReader.read(this, apiObj);
        return this;
    }

    public Object[] writeGetParam() {
        return getParamWriter.write(this);
    }

    public Object[] writeCreateParam() {
        return createParamWriter.write(this);
    }

    public Object[] writeDeleteParam() {
        return deleteParamWriter.write(this);
    }

    public Object[] writeUpdateParam() {
        return updateParamWriter.write(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
