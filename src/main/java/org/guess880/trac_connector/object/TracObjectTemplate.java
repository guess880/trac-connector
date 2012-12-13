package org.guess880.trac_connector.object;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracObjectTemplate implements TracObject {

    private TracAPIResultReader getMultiResultReader;

    private TracAPIResultReader getResultReader;

    private TracAPIParamWriter getParamWriter;

    private TracAPIParamWriter createParamWriter;

    private TracAPIParamWriter deleteParamWriter;

    private TracAPIParamWriter updateParamWriter;

    public TracObjectTemplate setGetMultiResultReader(final TracAPIResultReader reader) {
        this.getMultiResultReader = reader;
        return this;
    }

    public TracObjectTemplate setGetResultReader(final TracAPIResultReader reader) {
        this.getResultReader = reader;
        return this;
    }

    public TracObjectTemplate setGetParamWriter(final TracAPIParamWriter writer) {
        this.getParamWriter = writer;
        return this;
    }

    public TracObjectTemplate setCreateParamWriter(final TracAPIParamWriter writer) {
        this.createParamWriter = writer;
        return this;
    }

    public TracObjectTemplate setDeleteParamWriter(final TracAPIParamWriter writer) {
        this.deleteParamWriter = writer;
        return this;
    }

    public TracObjectTemplate setUpdateParamWriter(final TracAPIParamWriter writer) {
        this.updateParamWriter = writer;
        return this;
    }

    public TracObjectTemplate readGetMultiResult(final Object apiObj) {
        getMultiResultReader.read(this, apiObj);
        return this;
    }

    public TracObjectTemplate readGetResult(final Object apiObj) {
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
