# RealTextView

A new TextView for Android that includes a compilation of libraries to make a real TextView.
A lot of good libraries out there, but always I had to import each one, why not to merge and improve
them in a unique library.

This is what RealTextView does. As well for Button, CheckBox and EditText.

## Features:

* Autofit TextView, set a desired size and a minimun size, and never worry about if a text fits</li>
* Set any kind of font, only to a textview or set it as a theme for all the TextViews</li>
* RealTextView and RealButton with indeterminate progress loading</li>
* HTML text view extension, use RealTextView with html String.</li>

## Sample

[![Get it on Google Play](http://www.android.com/images/brand/get_it_on_play_logo_small.png)](http://play.google.com/store/apps/details?id=com.hardsoftstudio.real.textview)

![Example Image](/web_resources/rtv_sample.gif?raw=true)

![Example Image](/web_resources/rtv_html.gif?raw=true)

## Usage

```
dependencies {
    compile 'com.hardsoftstudio.real.textview:library:0.9.0'
}
```

SDK version >= 14

### AutoFit:

The Autofit function is enabled by default with a minimum size of 12dip. If you want to disabled use
the real:autoEnabled="false" tag in the XML or by code with the setAutoFit(false).

XML usage:

```
<com.hardsoftstudio.real.textview.views.RealTextView
            //the normal xml tags
            android:singleLine="true" // or android:maxLines="n" must set a limit in order to compute the autofit
            android:textSize="30sp"
            real:minTextSize="5sp" />
```

### Font:

The RealTextView allows to set custom fonts using assets resources, you can set up just for a TextView
or you can set it up as style and theme.

As a theme

```
    <style name="AppTheme" parent="android:Theme.Holo.Light.DarkActionBar">
        <item name="fontifyStyle">@style/CustomTextViewStyle</item>
    </style>

    <style name="CustomTextViewStyle">
        <item name="font">@string/app_default_font</item>
    </style>

    <!-- in strings.xml -->
    <string name="app_default_font">fonts/RobotoCondensed-Light.ttf</string>
```

Just for a textview

```
<com.hardsoftstudio.real.textview.views.RealTextView
            android:maxLines="2"
            real:font="fonts/Roboto-Black.ttf"
            real:minTextSize="8sp" />
```

The font can be set from Java code but the good thing of this lib is to avoid setting up the font in
java code everytime.

### Extended TextView HTML tags

* ``<ul>``
* ``<ol>``
* ``<dd>``
* ``<li>``
* ``<code>``
* ``<center>``

### Set HTML

```
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
```

In order to correctly display the image, the size must be set. This is an problem of using html in the textview
To fix this the best solution approached is this:
```
String imgUrl = RealUrl.makeImageUrl("Url to any image", 512, 512, Gravity.START);
```

Must remark that it's not a WebView it's a TextView! So it has it's pros and contras.

### Indeterminate progress Text

You can use RealTextView or RealButton to set a Indeterminate text to show a loading efect.
```
    mRealButton.setIndeterminateLoadingButton(isAnimated,isReverseMode,"Loading...");
```
The code above will change the text of the Button and make a writing animation forward and backwards if
isReverseMode=true

## Acknowledgment

This library is a mix of other libraries plus some improvements. Most of the work is made by the following open sources projects:

* [AutoFitTextView](https://github.com/grantland/android-autofittextview) developed by [Grantland Chew](https://github.com/grantland)
* [Fontify](https://github.com/danh32/Fontify) developed by [Dan Hill](https://github.com/danh32)
* [HtmlTextView](https://github.com/dschuermann/html-textview) developed by [Dominik Schürmann](https://github.com/dschuermann)


## License

This library is composed by other open source libraries, if used, must include all the license files.

    Copyright 2014 Marcel Pintó Biescas

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
