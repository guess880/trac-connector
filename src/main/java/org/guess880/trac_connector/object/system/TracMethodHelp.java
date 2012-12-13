package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectTemplate;
import org.guess880.trac_connector.object.converter.TracAPIObjectReader;
import org.guess880.trac_connector.object.converter.TracAPIObjectWriter;

public class TracMethodHelp extends TracObjectTemplate {

    private final String name;

    private String help;

    public TracMethodHelp(final String name) {
        this.name = name;
        setGetResultReader(new DefaultAPIObjectReader());
        setGetParamWriter(new DefaultAPIObjectWriter());
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
