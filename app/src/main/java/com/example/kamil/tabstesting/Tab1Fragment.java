package com.example.kamil.tabstesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kamil on 05.08.2017.
 */

public class Tab1Fragment extends Fragment implements CustomizeTopTabsView1.MyTopTabsViewCallback{

  private ViewPager mViewPager;
  private CustomizeTopTabsView1 customizeTopTabsView1;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_tab1, container, false);


    customizeTopTabsView1 = (CustomizeTopTabsView1)view.findViewById(R.id.ctv_in_fragment_1);
    customizeTopTabsView1.setCallback(this);

    mViewPager = (ViewPager) view.findViewById(R.id.view_pager_fragments_in_fr1);
    mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        customizeTopTabsView1.animateStripeToIndex(position);
      }

      @Override
      public void onPageSelected(int position) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
      }
    });
    setUpViewPager(mViewPager);


    return view;
  }

  @Override
  public void showFragmentAtIndex(int index) {
    mViewPager.setCurrentItem(index, true);
  }

  private void setUpViewPager(ViewPager viewPager) {
    SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
    adapter.addFragment(new Fragment1A(), "Tab1");
    adapter.addFragment(new Fragment1B(), "Tab2");
    adapter.addFragment(new Fragment1C(), "Tab3");
    viewPager.setAdapter(adapter);
  }
}
