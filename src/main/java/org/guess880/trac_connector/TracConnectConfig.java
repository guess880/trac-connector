package org.guess880.trac_connector;

public class TracConnectConfig {

    private String url;

    private String username;

    private String password;

    public String getUrl() {
        return url;
    }

    public TracConnectConfig setUrl(final String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TracConnectConfig setUsername(final String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TracConnectConfig setPassword(final String password) {
        this.password = password;
        return this;
    }

}
