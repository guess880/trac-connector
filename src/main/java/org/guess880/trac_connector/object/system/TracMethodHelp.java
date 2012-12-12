package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracAPIObjectWriter;
import org.guess880.trac_connector.object.TracObject;

public class TracMethodHelp extends TracObject {

    private final String name;

    private String help;

    public TracMethodHelp(final String name) {
        this.name = name;
        setAPIObjectReader(new DefaultAPIObjectReader());
        setAPIObjectWriterForGet(new DefaultAPIObjectWriter());
    }

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

    public TracMethodHelp setHelp(final String help) {
        this.help = help;
        return this;
    }

    private static class DefaultAPIObjectReader implements TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracMethodHelp signature = (TracMethodHelp) tracObj;
            signature.setHelp((String) apiObj);
            return signature;
        }

    }

    private static class DefaultAPIObjectWriter implements TracAPIObjectWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodHelp) tracObj).getName() };
        }

    }

}