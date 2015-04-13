package com.example.johnnysung.jkmusicmagazine;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by johnnysung on 2015/04/13.
 */
@Root(strict = false)
public class Item {

    @Element(name = "link", type = String.class)
    private String link;

    @Element(name = "description", type = String.class)
    private String description;

    @Element(name = "title", type = String.class)
    private String title;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RssDataItem{" +
                "link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
