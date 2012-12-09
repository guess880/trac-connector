package org.guess880.trac_connector.object;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TracObject {

    private TracAPIObjectReader reader;

    private TracAPIObjectWriter writerForGet;

    private TracAPIObjectWriter writerForCreate;

    private TracAPIObjectWriter writerForDelete;

    private TracAPIObjectWriter writerForUpdate;

    public TracObject setAPIObjectReader(final TracAPIObjectReader reader) {
        this.reader = reader;
        return this;
    }

    public TracObject setAPIObjectWriterForGet(final TracAPIObjectWriter writer) {
        this.writerForGet = writer;
        return this;
    }

    public TracObject setAPIObjectWriterForCreate(final TracAPIObjectWriter writer) {
        this.writerForCreate = writer;
        return this;
    }

    public TracObject setAPIObjectWriterForDelete(final TracAPIObjectWriter writer) {
        this.writerForDelete = writer;
        return this;
    }

    public TracObject setAPIObjectWriterForUpdate(final TracAPIObjectWriter writer) {
        this.writerForUpdate = writer;
        return this;
    }

    public TracObject readAPIObject(final Object apiObj) {
        return reader.read(this, apiObj);
    }

    public Object[] writeAPIObjectForGet() {
        return writerForGet.write(this);
    }

    public Object[] writeAPIObjectForCreate() {
        return writerForCreate.write(this);
    }

    public Object[] writeAPIObjectForDelete() {
        return writerForDelete.write(this);
    }

    public Object[] writeAPIObjectForUpdate() {
        return writerForUpdate.write(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
