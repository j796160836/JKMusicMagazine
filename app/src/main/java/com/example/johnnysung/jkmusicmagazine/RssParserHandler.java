package com.example.johnnysung.jkmusicmagazine;

import org.xmlpull.v1.XmlPullParser;

import java.util.Stack;

/**
 * Created by johnnysung on 2015/04/14.
 */
public class RssParserHandler implements IParserHandler {

    private RssObject rssObject;
    private RssItemObject currentItem;

    public RssParserHandler() {
    }

    @Override
    public void startDocument() {
        rssObject = new RssObject();
    }

    @Override
    public void endDocument() {

    }

    @Override
    public void startElement(XmlPullParser xpp, Stack<String> nodeStack) {
        if (nodeStack.size() == 3 &&
                nodeStack.get(0).equalsIgnoreCase("rss") &&
                nodeStack.get(1).equalsIgnoreCase("channel") &&
                nodeStack.get(2).equalsIgnoreCase("item")) {
            currentItem = new RssItemObject();
        }
    }

    @Override
    public void endElement(XmlPullParser xpp, Stack<String> nodeStack) {
        if (nodeStack.size() == 2 &&
                nodeStack.get(0).equalsIgnoreCase("rss") &&
                nodeStack.get(1).equalsIgnoreCase("channel") &&
                xpp.getName().equalsIgnoreCase("item")) {
            rssObject.getItem().add(currentItem);
            currentItem = null;
        }
    }

    @Override
    public void characters(String value, XmlPullParser xpp, Stack<String> nodeStack) {
        String n;
        if (nodeStack.size() >= 2 &&
                nodeStack.get(0).equalsIgnoreCase("rss") &&
                nodeStack.get(1).equalsIgnoreCase("channel")) {
            n = nodeStack.get(2);
            if (n.equalsIgnoreCase("title")) {
                rssObject.setTitle(value);
            } else if (n.equalsIgnoreCase("description")) {
                rssObject.setDescription(value);
            } else if (n.equalsIgnoreCase("link")) {
                rssObject.setLink(value);
            } else if (n.equalsIgnoreCase("pubDate")) {
                rssObject.setPubDate(value);
            } else if (n.equalsIgnoreCase("item")) {
                n = nodeStack.get(3);
                if (n.equalsIgnoreCase("link")) {
                    currentItem.setLink(value);
                } else if (n.equalsIgnoreCase("date")) {
                    currentItem.setDateRaw(value);
                } else if (n.equalsIgnoreCase("description")) {
                    currentItem.setDescription(value);
                } else if (n.equalsIgnoreCase("title")) {
                    currentItem.setTitle(value);
                }

            }
        }
    }

    public RssObject getResult() {
        return rssObject;
    }
}
