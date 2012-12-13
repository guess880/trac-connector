package org.guess880.trac_connector.object.search;

import java.util.Date;

import org.guess880.trac_connector.object.TracObject;
import org.guess880.trac_connector.object.TracObjectBase;
import org.guess880.trac_connector.object.converter.TracAPIResultReader;

public class TracSearchResult extends TracObjectBase {

    private String href;

    private String title;

    private Date date;

    private String author;

    private String excerpt;

    public TracSearchResult() {
        super();
        setGetMultiResultReader(new GetMultiResultReader());
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

    private static class GetMultiResultReader implements
            TracAPIResultReader {

        @Override
        public TracObject read(final TracObject tracObj, final Object result) {
            final TracSearchResult searchResult = (TracSearchResult) tracObj;
            final Object[] attrs = (Object[]) result;
            searchResult.setHref((String) attrs[0]);
            searchResult.setTitle((String) attrs[1]);
            searchResult.setDate((Date) attrs[2]);
            searchResult.setAuthor((String) attrs[3]);
            searchResult.setExcerpt((String) attrs[4]);
            return searchResult;
        }

    }

}
