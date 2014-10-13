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

## Usage

```
dependencies {
    compile 'com.hardsoftstudio.real.textview:library:0.88'
}
```

### AutoFit:

The autofit function is enabled by default with a minimum size of 12dip. If you want to disabled use
the real:enabled="false" tag in the XML or by code with the setAutoFit(false).

XML usage:

...
<com.hardsoftstudio.real.textview.views.RealTextView
            //the normal xml tags
            android:singleLine="true"
            android:textSize="30sp"
            real:minTextSize="5sp" />
...



## License

    Copyright 2013 Chris Banes

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
