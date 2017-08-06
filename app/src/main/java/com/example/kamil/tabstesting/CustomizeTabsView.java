package com.example.kamil.tabstesting;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.08.2017.
 */

public class CustomizeTabsView extends LinearLayout implements OnClickListener {

  private MyTabsViewCallback callback;
  private ImageButton ib0;
  private TextView ib1;
  private ImageButton ib2;
  private View vStripe;
  private ArrayList<View> tabsList = new ArrayList<>();

  public interface MyTabsViewCallback {
    void showFragmentAtIndex(int index);
  }


  public CustomizeTabsView(Context context) {
    super(context);
    init();
  }

  public CustomizeTabsView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CustomizeTabsView(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }


  private void init() {
    inflate(getContext(), R.layout.layout_tabs, this);
    ib0 = (ImageButton) findViewById(R.id.ib_0);
    ib1 = (TextView) findViewById(R.id.ib_1);
    ib2 = (ImageButton) findViewById(R.id.ib_2);

    ib0.setOnClickListener(this);
    ib1.setOnClickListener(this);
    ib2.setOnClickListener(this);


    tabsList.add(ib0);
    tabsList.add(ib1);
    tabsList.add(ib2);

    vStripe = findViewById(R.id.v_stripe);

//    ib0.post(new Runnable() {
//      @Override
//      public void run() {
//        vStripe.getLayoutParams().width = ib0.getMeasuredWidth();
//      }
//    });
  }

  public void animateStripeToIndex(int index) {
    ObjectAnimator animX = ObjectAnimator.ofFloat(vStripe, "x", tabsList.get(index).getX());
    AnimatorSet animSetX = new AnimatorSet();
    animSetX.play(animX);
    animSetX.setDuration(100);
    animSetX.start();
  }

  /*****/
  @Override
  public void onClick(View v) {
    callback.showFragmentAtIndex(tabsList.indexOf(v));
    animateStripeToIndex(tabsList.indexOf(v));
  }

  public void setCallback(MyTabsViewCallback callback) {
    this.callback = callback;
  }
}
