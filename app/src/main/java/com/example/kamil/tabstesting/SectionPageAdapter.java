package com.example.kamil.tabstesting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 05.08.2017.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {

  private final List<Fragment> mFragmentList = new ArrayList<>();
  private final List<String> mFragmentsTitleList = new ArrayList<>();


  public SectionPageAdapter(FragmentManager fm) {
    super(fm);
  }

  public void addFragment(Fragment fragment, String title){
    mFragmentList.add(fragment);
    mFragmentsTitleList.add(title);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mFragmentsTitleList.get(position);
  }

  @Override
  public Fragment getItem(int position) {
    return mFragmentList.get(position);
  }

  @Override
  public int getCount() {
    return mFragmentList.size();
  }
}
