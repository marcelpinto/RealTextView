package org.hardsoft.real.textview.utils;

import android.content.Context;
import android.graphics.Point;

import org.hardsoft.real.textview.exceptions.RealHtmlTextViewException;

/**
 * Created by Marcel on 07/10/2014.
 */
public class SizeUtils {

    public static float getDensity(Context context){
        float scale = context.getResources().getDisplayMetrics().density;
        return scale;
    }

    public static int convertDiptoPix(Context c, int dip){
        if (dip==0)
            return 0;
        float scale = getDensity(c);
        return (int) (dip * scale + 0.5f);
    }

    public static int convertPixtoDip(Context c, int pixel){
        if (pixel==0)
            return 0;
        float scale = getDensity(c);
        return (int)((pixel - 0.5f)/scale);
    }

    public static Point getSizeFromString(String source) throws RealHtmlTextViewException, NumberFormatException {

        if (source==null || source.isEmpty())
            return new Point(0,0);

        int index = source.lastIndexOf("width");
        if (index<0)
            throw new RealHtmlTextViewException("No width tag found for remote image");

        String sizeTag = source.substring(index,source.length());
        int end = sizeTag.indexOf("&");
        if (end<0)
            throw new RealHtmlTextViewException("Missing & in size tag");

        String width = sizeTag.substring(index+6,end);
        String height = sizeTag.substring(end+8,sizeTag.length());

        return new Point(Integer.parseInt(width),Integer.parseInt(height));
    }

    public static String removeSizeTag(String source) {
        return source.substring(0,source.lastIndexOf("width")-1);
    }
}
