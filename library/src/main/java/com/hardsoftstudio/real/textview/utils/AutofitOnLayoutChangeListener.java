package com.hardsoftstudio.real.textview.utils;

import android.annotation.TargetApi;
import android.view.View;

/**
 * @author Hannes Dorfmann
 */
@TargetApi(11)
public class AutofitOnLayoutChangeListener implements View.OnLayoutChangeListener {

  private AutofitHelper mHelper;

  public AutofitOnLayoutChangeListener(AutofitHelper helper) {
    mHelper = helper;
  }

  @Override
  public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft,
      int oldTop, int oldRight, int oldBottom) {
    mHelper.autofit();
  }
}
