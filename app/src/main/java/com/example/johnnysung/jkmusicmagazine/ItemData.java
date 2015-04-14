package com.example.johnnysung.jkmusicmagazine;

/**
 * Created by johnnysung on 2015/04/14.
 */
public class ItemData {
    private String title;
    private String iconColor;

    public ItemData(String title, String iconColor) {

        this.title = title;
        this.iconColor = iconColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }
}