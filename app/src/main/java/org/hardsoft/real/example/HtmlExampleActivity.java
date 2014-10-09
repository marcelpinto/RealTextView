package org.hardsoft.real.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import org.hardsoft.real.textview.utils.RealUrl;
import org.hardsoft.real.textview.views.RealTextView;

/**
 * Created by Marcel on 07/10/2014.
 */
public class HtmlExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_example_html);

        RealTextView text = (RealTextView) findViewById(R.id.w_rtv_html);

        String imgUrl = RealUrl.makeImageUrl("https://dl.dropboxusercontent.com/u/22991089/logos/engeldroid.png", 512, 512, Gravity.START);
        Log.d("MPB",imgUrl);
        text.setFont("fonts/Roboto-Thin.ttf");
        text.setHtmlFromString(
                "<center><h2>You can load images and use center tag</h2>" +
                        "<img src=\""+imgUrl+"\"></center>" +
                        "<h3>You can list as well</h3>"+
                        "<ul>\n" +
                        "  <li>Coffee</li>\n" +
                        "  <li>Tea</li>\n" +
                        "  <li>Milk</li>\n" +
                        "</ul>" +
                        "<h3>You can use cites and a lot of more tags</h3>" +
                        "<p><cite>The Scream</cite> by Edward Munch. Painted in 1893.</p>",false);
                //"<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"ic_launcher\"/>",true);


    }
}
