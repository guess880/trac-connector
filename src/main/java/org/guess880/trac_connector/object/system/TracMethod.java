package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;

public class TracMethod extends TracObjectBase {

    private String name;

    private TracMethodHelp help;

    private TracMethodSignature signature;

    public TracMethod() {
        super();
        setGetMultiResultReader(new NameOnlyResultReader());
    }

    public String getName() {
        return name;
    }

    public TracMethod setName(final String name) {
        this.name = name;
        return this;
    }

    public TracMethodHelp getHelp() {
        if (help == null) {
            help = new TracMethodHelp(getName());
        }
        return help;
    }

    public TracMethod setHelp(final TracMethodHelp help) {
        this.help = help;
        return this;
    }

    public TracMethodSignature getSignature() {
        if (signature == null) {
            signature = new TracMethodSignature(getName());
        }
        return signature;
    }

    public TracMethod setSignature(final TracMethodSignature signature) {
        this.signature = signature;
        return this;
    }

    private static class NameOnlyResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracMethod method = (TracMethod) tracObj;
            method.setName((String) result);
            return method;
        }

    }

}
