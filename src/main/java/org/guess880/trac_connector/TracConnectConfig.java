package org.guess880.trac_connector;

public class TracConnectConfig {

    private String url;

    private String username;

    private String password;

    public String getUrl() {
        return url;
    }

    public TracConnectConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TracConnectConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TracConnectConfig setPassword(String password) {
        this.password = password;
        return this;
    }

}
