package com.example.johnnysung.jkmusicmagazine;

/**
 * Created by johnnysung on 2015/04/13.
 */
public class RssItemObject {

    private String link;

    private String description;

    private String title;

    private String dateRaw;

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

    public String getDateRaw() {
        return dateRaw;
    }

    public void setDateRaw(String dateRaw) {
        this.dateRaw = dateRaw;
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
