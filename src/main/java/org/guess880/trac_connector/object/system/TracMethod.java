package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectTemplate;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;

public class TracMethod extends TracObjectTemplate {

    private String name;

    private TracMethodHelp help;

    private TracMethodSignature signature;

    public TracMethod() {
        setGetMultiResultReader(new NameAPIObjectReader());
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

    private static class NameAPIObjectReader implements TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracMethod method = (TracMethod) tracObj;
            method.setName((String) apiObj);
            return method;
        }

    }

}
