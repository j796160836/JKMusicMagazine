package com.example.johnnysung.jkmusicmagazine;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by johnnysung on 2015/04/13.
 */
@Root(strict = false)
public class Rss {

    @Element
    @Path("channel")
    private String title;

    @Element
    @Path("channel")
    private String description;

    @Element
    @Path("channel")
    private String pubDate;

    @ElementList(name = "item")
    @Path("channel")
    private List<Item> item;

    public Rss() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "RssData{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", item=" + item +
                '}';
    }
}

