package org.guess880.trac_connector.api;


public class TracAPITestUtils {

    public static final TracAPIConfig getTestConfig() {
        return new TracAPIConfig()
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
