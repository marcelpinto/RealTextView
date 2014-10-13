package org.hardsoftstudio.real.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import com.hardsoftstudio.real.textview.views.RealButton;
import com.hardsoftstudio.real.textview.views.RealTextView;


public class ExampleMainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private final static String EXTRA_TEXT = " more text to add when seekbar is seeked, when the text doesn't fit it resize it";

    private SeekBar mSeekBar;
    private RealTextView mExample1;
    private RealTextView mExample2;
    private RealButton mExample3;
    private RealTextView mExample4;
    private RealButton mExample5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_example_main);

        mSeekBar = (SeekBar) findViewById(R.id.w_seb_example);
        mSeekBar.setMax(EXTRA_TEXT.length());
        mSeekBar.setOnSeekBarChangeListener(this);
        mExample1 = (RealTextView) findViewById(R.id.w_rtv_example1);
        mExample2 = (RealTextView) findViewById(R.id.w_rtv_example2);
        mExample3 = (RealButton) findViewById(R.id.w_rbut_example3);
        mExample4 = (RealTextView) findViewById(R.id.w_rtv_example4);
        mExample5 = (RealButton) findViewById(R.id.w_rbut_example5);
        mExample4.setIndeterminateLoadingTextView(true);
        mExample5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExample5.setIndeterminateLoadingButton(true,"Loading...");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.example_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, HtmlExampleActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (!fromUser)
            return;

        mExample1.setText(getString(R.string.txt_example1)+EXTRA_TEXT.substring(0,progress));
        mExample2.setText(getString(R.string.txt_example2)+EXTRA_TEXT.substring(0,progress));
        mExample3.setText(getString(R.string.txt_example3)+EXTRA_TEXT.substring(0,progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
