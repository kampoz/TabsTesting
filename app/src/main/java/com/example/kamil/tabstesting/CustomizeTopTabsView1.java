package com.example.kamil.tabstesting;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomizeTopTabsView1 extends LinearLayout implements View.OnClickListener{

  private MyTopTabsViewCallback callback;
  private ImageButton ib0;
  private ImageButton ib1;
  private ImageButton ib2;
  private View vStripe;
  private ArrayList<View> tabsList = new ArrayList<>();

  public interface MyTopTabsViewCallback {
    void showFragmentAtIndex(int index);
  }

  public CustomizeTopTabsView1(Context context) {
    super(context);
    init();
  }

  public CustomizeTopTabsView1(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CustomizeTopTabsView1(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.layout_tabs_top_1, this);
    ib0 = (ImageButton) findViewById(R.id.ib_1_0);
    ib1 = (ImageButton) findViewById(R.id.ib_1_1);
    ib2 = (ImageButton) findViewById(R.id.ib_1_2);

    ib0.setOnClickListener(this);
    ib1.setOnClickListener(this);
    ib2.setOnClickListener(this);

    tabsList.add(ib0);
    tabsList.add(ib1);
    tabsList.add(ib2);

    vStripe = findViewById(R.id.v_stripe_1);
  }

  public void animateStripeToIndex(int index) {
    ObjectAnimator animX = ObjectAnimator.ofFloat(vStripe, "x", tabsList.get(index).getX());
    AnimatorSet animSetX = new AnimatorSet();
    animSetX.play(animX);
    animSetX.setDuration(100);
    animSetX.start();
  }

  @Override
  public void onClick(View v) {
    callback.showFragmentAtIndex(tabsList.indexOf(v));
    animateStripeToIndex(tabsList.indexOf(v));
  }

  public void setCallback(MyTopTabsViewCallback callback) {
    this.callback = callback;
  }
}
