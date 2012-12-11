package org.guess880.trac_connector.object.search;

import java.util.Date;

import org.guess880.trac_connector.object.TracAPIObjectReader;
import org.guess880.trac_connector.object.TracObject;


public class TracSearchResult extends TracObject {

    private String href;

    private String title;

    private Date date;

    private String author;

    private String excerpt;

    public TracSearchResult() {
        setAPIObjectReader(new DefaultAPIObjectReader());
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
        return date;
    }

    public TracSearchResult setDate(final Date date) {
        this.date = date;
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

    private static class DefaultAPIObjectReader implements
            TracAPIObjectReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object apiObj) {
            final TracSearchResult result = (TracSearchResult) tracObj;
            final Object[] attrs = (Object[]) apiObj;
            result.setHref((String) attrs[0]);
            result.setTitle((String) attrs[1]);
            result.setDate((Date) attrs[2]);
            result.setAuthor((String) attrs[3]);
            result.setExcerpt((String) attrs[4]);
            return result;
        }

    }

}
