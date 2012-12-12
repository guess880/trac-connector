package org.guess880.trac_connector.api;

import org.guess880.trac_connector.TracConnectConfig;

public class TracAPITestUtils {

    public static final TracConnectConfig getTestConfig() {
        return new TracConnectConfig()
                .setUrl("http://localhost/trac/SampleProject/login/xmlrpc")
                .setUsername("rpc")
                .setPassword("rpc");
    }

    public static final void sysOutArray(final Object obj) {
        final Object[] objAry = (Object[]) obj;
        for (Object o : objAry) {
            System.out.println(o);
        }
    }

}
