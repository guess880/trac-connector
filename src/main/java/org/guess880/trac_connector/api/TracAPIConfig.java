package org.guess880.trac_connector.api;

public class TracAPIConfig {

    private String url;

    private String username;

    private String password;

    public String getUrl() {
        return url;
    }

    public TracAPIConfig setUrl(final String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TracAPIConfig setUsername(final String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TracAPIConfig setPassword(final String password) {
        this.password = password;
        return this;
    }

}
