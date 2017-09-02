package com.example.kamil.tabstesting;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.kamil.tabstesting.CustomizeBottomTabsView.MyTabsViewCallback;

public class MainActivity extends AppCompatActivity implements MyTabsViewCallback{

  private ViewPager mViewPager;
  private CustomizeBottomTabsView customizeBottomTabsView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    customizeBottomTabsView = (CustomizeBottomTabsView) findViewById(R.id.tabs_view);
    customizeBottomTabsView.setCallback(this);

    mViewPager = (ViewPager) findViewById(R.id.view_pager_fragments);
    mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        customizeBottomTabsView.animateStripeToIndex(position);
      }

      @Override
      public void onPageSelected(int position) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
      }
    });
    setUpViewPager(mViewPager);
  }

  private void setUpViewPager(ViewPager viewPager) {
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
    adapter.addFragment(new Tab1Fragment(), "Tab1");
    adapter.addFragment(new Tab2Fragment(), "Tab2");
    adapter.addFragment(new Tab3Fragment(), "Tab3");
    adapter.addFragment(new Tab1Fragment(), "Tab4");
    viewPager.setAdapter(adapter);
  }


  @Override
  public void showFragmentAtIndex(int index) {
    Log.d("showFragmentAtIndex()", String.valueOf(index));
    mViewPager.setCurrentItem(index, true);
  }
}
