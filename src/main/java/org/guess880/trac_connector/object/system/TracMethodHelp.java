package org.guess880.trac_connector.object.system;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectTemplate;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;
import org.guess880.trac_connector.object.converter.TracAPIParamWriter;

public class TracMethodHelp extends TracObjectTemplate {

    private final String name;

    private String help;

    public TracMethodHelp(final String name) {
        this.name = name;
        setGetResultReader(new GetResultReader());
        setGetParamWriter(new GetParamWriter());
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

    private static class GetResultReader implements TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracMethodHelp signature = (TracMethodHelp) tracObj;
            signature.setHelp((String) result);
            return signature;
        }

    }

    private static class GetParamWriter implements TracAPIParamWriter {

        @Override
        public Object[] write(final TracObject tracObj) {
            return new Object[] { ((TracMethodHelp) tracObj).getName() };
        }

    }

}
