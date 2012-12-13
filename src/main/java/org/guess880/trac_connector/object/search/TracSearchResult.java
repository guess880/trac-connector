package org.guess880.trac_connector.object.search;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.guess880.trac_connector.object.TracObject;

public class TracSearchResult implements TracObject {

    private String href;

    private String title;

    private Date date;

    private String author;

    private String excerpt;

    public TracSearchResult() {
        super();
    }

    public String getHref() {
        return href;
    }

    public TracSearchResult setHref(final String href) {
        this.href = href;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TracSearchResult setTitle(final String title) {
        this.title = title;
        return this;
    }

    public Date getDate() {
        return date == null ? null : (Date) date.clone();
    }

    public TracSearchResult setDate(final Date date) {
        this.date = date == null ? null : (Date) date.clone();
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public TracSearchResult setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public TracSearchResult setExcerpt(final String excerpt) {
        this.excerpt = excerpt;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
