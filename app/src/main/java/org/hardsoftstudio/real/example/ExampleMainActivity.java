package org.hardsoftstudio.real.example;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.hardsoftstudio.real.textview.views.RealButton;
import com.hardsoftstudio.real.textview.views.RealTextView;


public class ExampleMainActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

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
                mExample5.setIndeterminateLoadingButton(true, true, "Loading...");
            }
        });

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (!fromUser)
            return;

        mExample1.setText(getString(R.string.txt_example1) + EXTRA_TEXT.substring(0, progress));
        mExample2.setText(getString(R.string.txt_example2) + EXTRA_TEXT.substring(0, progress));
        mExample3.setText(getString(R.string.txt_example3) + EXTRA_TEXT.substring(0, progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
