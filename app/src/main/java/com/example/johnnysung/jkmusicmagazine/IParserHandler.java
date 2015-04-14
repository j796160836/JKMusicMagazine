package com.example.johnnysung.jkmusicmagazine;

import org.xmlpull.v1.XmlPullParser;

import java.util.Stack;

/**
 * Created by johnnysung on 2015/04/14.
 */
public interface IParserHandler {
    public void startDocument();

    public void endDocument();

    public void startElement(XmlPullParser xpp, Stack<String> nodeStack);

    public void endElement(XmlPullParser xpp, Stack<String> nodeStack);

    public void characters(String value, XmlPullParser xpp, Stack<String> nodeStack);
}
