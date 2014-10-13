package com.hardsoftstudio.real.textview.views;


import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;

import com.hardsoftstudio.real.textview.utils.AutofitHelper;
import com.hardsoftstudio.real.textview.utils.FontManager;


public class RealButton extends Button implements AutofitHelper.OnTextSizeChangeListener {

    private static final long DEFAULT_ANIMATION_SPEED = 100;

    private AutofitHelper mHelper;
    private Handler mAnimateHandler;
    private CharSequence mCurrentText;
    private int mCurrentIndex;
    private long mAnimationSpeed = DEFAULT_ANIMATION_SPEED;
    private boolean isReverseMode = true;
    public boolean isForwardAnim=true;

    public RealButton(Context context) {
        this(context, null, 0);
    }

    public RealButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RealButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) return;

        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mHelper = AutofitHelper.create(this, attrs, defStyle)
                .addOnTextSizeChangeListener(this);

        FontManager.getInstance().setFont(this, attrs);
    }


    public void setFont(String fontPath) {
        FontManager.getInstance().setFont(this, fontPath);
    }

    public void setFont(int resId) {
        String fontPath = getContext().getString(resId);
        setFont(fontPath);
    }

    // Getters and Setters

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        if (mHelper != null) {
            mHelper.setTextSize(unit, size);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLines(int lines) {
        super.setLines(lines);
        if (mHelper != null) {
            mHelper.setMaxLines(lines);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
        if (mHelper != null) {
            mHelper.setMaxLines(maxLines);
        }
    }

    /**
     * @return the {@link AutofitHelper} for this View.
     */
    public AutofitHelper getAutofitHelper() {
        return mHelper;
    }

    /**
     * @return whether or not the text will be automatically re-sized to fit its constraints.
     */
    public boolean isSizeToFit() {
        return mHelper.isEnabled();
    }

    /**
     * Sets the property of this field (sizeToFit), to automatically resize the text to fit its
     * constraints.
     */
    public void setSizeToFit() {
        setSizeToFit(true);
    }

    /**
     * If true, the text will automatically be re-sized to fit its constraints; if false, it will
     * act like a normal TextView.
     *
     * @param sizeToFit
     */
    public void setSizeToFit(boolean sizeToFit) {
        mHelper.setEnabled(sizeToFit);
    }

    /**
     * @return the maximum size (in pixels) of the text in this View.
     */
    public float getMaxTextSize() {
        return mHelper.getMaxTextSize();
    }

    /**
     * Set the maximum text size to the given value, interpreted as "scaled pixel" units. This size
     * is adjusted based on the current density and user font size preference.
     *
     * @param size The scaled pixel size.
     *
     * @attr ref android.R.styleable#TextView_textSize
     */
    public void setMaxTextSize(float size) {
        mHelper.setMaxTextSize(size);
    }

    /**
     * Set the maximum text size to a given unit and value. See TypedValue for the possible
     * dimension units.
     *
     * @param unit The desired dimension unit.
     * @param size The desired size in the given units.
     *
     * @attr ref android.R.styleable#TextView_textSize
     */
    public void setMaxTextSize(int unit, float size) {
        mHelper.setMaxTextSize(unit, size);
    }

    /**
     * @return the minimum size (in pixels) of the text in this View.
     */
    public float getMinTextSize() {
        return mHelper.getMinTextSize();
    }

    /**
     * Set the minimum text size to the given value, interpreted as "scaled pixel" units. This size
     * is adjusted based on the current density and user font size preference.
     *
     * @param minSize The scaled pixel size.
     *
     * @attr ref me.grantland.R.styleable#AutofitTextView_minTextSize
     */
    public void setMinTextSize(int minSize) {
        mHelper.setMinTextSize(TypedValue.COMPLEX_UNIT_SP, minSize);
    }

    /**
     * Set the minimum text size to a given unit and value. See TypedValue for the possible
     * dimension units.
     *
     * @param unit The desired dimension unit.
     * @param minSize The desired size in the given units.
     *
     * @attr ref me.grantland.R.styleable#AutofitTextView_minTextSize
     */
    public void setMinTextSize(int unit, float minSize) {
        mHelper.setMinTextSize(unit, minSize);
    }

    /**
     * @return the amount of precision used to calculate the correct text size to fit within its
     * bounds.
     */
    public float getPrecision() {
        return mHelper.getPrecision();
    }

    /**
     * Set the amount of precision used to calculate the correct text size to fit within its
     * bounds. Lower precision is more precise and takes more time.
     *
     * @param precision The amount of precision.
     */
    public void setPrecision(float precision) {
        mHelper.setPrecision(precision);
    }

    @Override
    public void onTextSizeChange(float textSize, float oldTextSize) {
        // do nothing
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.v("MPB", "Detached from win");
        if (mAnimateHandler!=null)
            mAnimateHandler.removeCallbacksAndMessages(null);
    }

    public void setIndeterminateLoadingButton(boolean anim, String text) {
        if (!anim) {
            if (mAnimateHandler!=null) {
                mAnimateHandler.removeCallbacksAndMessages(null);
                setText(mCurrentText);
            }
            mAnimateHandler=null;
            return;
        }

        if (mAnimateHandler==null)
            mAnimateHandler = new Handler();
        else
            mAnimateHandler.removeCallbacksAndMessages(null);

        mCurrentText = text;
        mCurrentIndex = 0;
        setText(""+mCurrentText.charAt(0));
        mAnimateHandler.postDelayed(isReverseMode?ReverseLoadingRunnable:LoadingRunnable, mAnimationSpeed);
    }

    public boolean isIndeterminateLoading() {
        return mAnimateHandler!=null;
    }

    Runnable LoadingRunnable = new Runnable() {
        @Override
        public void run() {

            if (++mCurrentIndex>=mCurrentText.length()) {
                mCurrentIndex=0;
                setText(""+mCurrentText.charAt(0));
            } else {
                setText(getText().toString()+mCurrentText.charAt(mCurrentIndex));
            }
            if (getVisibility()==VISIBLE)
                mAnimateHandler.postDelayed(this, mAnimationSpeed);
        }
    };

    Runnable ReverseLoadingRunnable = new Runnable() {

        @Override
        public void run() {

            mCurrentIndex = isForwardAnim?mCurrentIndex+1:mCurrentIndex-1;
            if (mCurrentIndex>=mCurrentText.length()) {
                isForwardAnim = false;
                --mCurrentIndex;
            } else if (mCurrentIndex<0) {
                isForwardAnim=true;
                ++mCurrentIndex;
            }
            if (isForwardAnim) {
                setText(getText().toString()+mCurrentText.charAt(mCurrentIndex));
            } else
                setText(getText().toString().substring(0,mCurrentIndex));
            if (getVisibility()==VISIBLE)
                mAnimateHandler.postDelayed(this, mAnimationSpeed);
        }
    };

    public void setAnimationSpeed(long speed) {
        this.mAnimationSpeed = speed;
    }

}
