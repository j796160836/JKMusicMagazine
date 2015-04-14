package com.example.johnnysung.jkmusicmagazine;

import android.text.TextUtils;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

/**
 * Created by johnnysung on 2015/04/13.
 */
public class RssParser {

    private static final String TAG = RssParser.class.getName();
    private String input;

    private Stack<String> inNode;

    private boolean debugMode = false;

    private IParserHandler parserHandler;

    public RssParser() {

    }

    public RssParser(String input) {
        this.input = input;
    }

    public void setParserHandler(IParserHandler parserHandler) {
        this.parserHandler = parserHandler;
    }

    public void parse() throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(input));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                inNode = new Stack<>();
                Log.v(TAG, "Start document");

                if (parserHandler != null)
                    parserHandler.startDocument();
            } else if (eventType == XmlPullParser.START_TAG) {
                if (debugMode) {
                    Log.v(TAG, "\t Start Element:" + xpp.getName());
                    for (int i = 0; i < xpp.getAttributeCount(); i++) {
                        Log.v(TAG, "\t\t atts[" + i + "] Name=" + xpp.getAttributeName(i) + "Value=" + xpp.getAttributeValue(i));
                    }
                }
                inNode.push(xpp.getName());

                if (parserHandler != null)
                    parserHandler.startElement(xpp, inNode);
            } else if (eventType == XmlPullParser.END_TAG) {
                if (debugMode) {
                    Log.v(TAG, "\t End Element:" + xpp.getName());
                }

                //                System.out.println("End tag " + xpp.getName());
                inNode.pop();
                if (parserHandler != null)
                    parserHandler.endElement(xpp, inNode);
            } else if (eventType == XmlPullParser.TEXT) {
                String text = xpp.getText().trim();
                if (!TextUtils.isEmpty(text)) {
                    if (debugMode) {
                        Log.v(TAG, "\t characters: \n" + text);
                    }

                    if (parserHandler != null)
                        parserHandler.characters(text, xpp, inNode);
                }
//                System.out.println("Text " + xpp.getText());
            }
            eventType = xpp.next();
        }
        if (parserHandler != null)
            parserHandler.endDocument();
    }
}
