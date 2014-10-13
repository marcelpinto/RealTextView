package com.hardsoftstudio.real.textview.utils;

/**
 * Created by Marcel on 07/10/2014.
 */
public class RealUrl {

    public final static String TAG_SPLITER = "&&&";
    public final static String TAG_PARAM_SPLITER = ",";

    public final static String TAG_WIDTH = "width=";
    public final static String TAG_HEIGHT = "height=";
    public static final String TAG_GRAVITY = "gravity=";


    public static String makeImageUrl(String url, int width, int height, int gravity) {
        StringBuilder result = new StringBuilder();
        return result.insert(0,url)
                .append(TAG_SPLITER)
                .append(TAG_WIDTH+width)
                .append(TAG_PARAM_SPLITER)
                .append(TAG_HEIGHT+height)
                .append(TAG_PARAM_SPLITER)
                .append(TAG_GRAVITY+gravity)
                .toString();
    }
}
