package org.guess880.trac_connector.object;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracObjectBase implements TracObject {

    private TracAPIResultReader getMultiResultReader;

    private TracAPIResultReader getResultReader;

    private TracAPIParamWriter getParamWriter;

    private TracAPIParamWriter createParamWriter;

    private TracAPIParamWriter deleteParamWriter;

    private TracAPIParamWriter updateParamWriter;

    public TracObjectBase setGetMultiResultReader(final TracAPIResultReader reader) {
        this.getMultiResultReader = reader;
        return this;
    }

    public TracObjectBase setGetResultReader(final TracAPIResultReader reader) {
        this.getResultReader = reader;
        return this;
    }

    public TracObjectBase setGetParamWriter(final TracAPIParamWriter writer) {
        this.getParamWriter = writer;
        return this;
    }

    public TracObjectBase setCreateParamWriter(final TracAPIParamWriter writer) {
        this.createParamWriter = writer;
        return this;
    }

    public TracObjectBase setDeleteParamWriter(final TracAPIParamWriter writer) {
        this.deleteParamWriter = writer;
        return this;
    }

    public TracObjectBase setUpdateParamWriter(final TracAPIParamWriter writer) {
        this.updateParamWriter = writer;
        return this;
    }

    public TracObjectBase readGetMultiResult(final Object apiObj) {
        getMultiResultReader.read(this, apiObj);
        return this;
    }

    public TracObjectBase readGetResult(final Object apiObj) {
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
