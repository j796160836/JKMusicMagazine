package com.example.johnnysung.jkmusicmagazine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnysung on 2015/04/13.
 */
public class RssObject {

    private String title;

    private String description;

    private String pubDate;

    private String link;

    private List<RssItemObject> item;

    public RssObject() {
        super();
        item = new ArrayList<>();
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<RssItemObject> getItem() {
        return item;
    }

    public void setItem(List<RssItemObject> item) {
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

